package game;

import java.util.List;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;

import elements.Net;
import elements.Wall;
import elements.bombs.Bomb;
import elements.bombs.IBomb;
import elements.cats.Cat;
import elements.guns.Gun;
import fr.umlv.zen4.ApplicationContext;
import graphics.GUI;

public class BoardGame {
	private final List<Wall> walls;
	private final List<Cat> cats;
	private final List<IBomb> bombs;
	private final List<Net> nets;
	private final Gun gun;
	private IBomb pickingBomb;
	private final World world;
	private boolean finish = false;

	private boolean isStarted = false;

	public BoardGame(World world, List<Wall> walls, List<Cat> cats, List<IBomb> bombs, List<Net> nets, Gun gun) {
		this.walls = walls;
		this.cats = cats;
		this.bombs = bombs;
		this.nets = nets;
		this.gun = gun;
		this.world = world;
		generateBoundaries(0, 0);
	}


	/**
	 * picks the bomb at the position (x, y)
	 *
	 */
	public void pickABomb(int x, int y) {
		for(IBomb bomb: bombs) {
			float posX = bomb.getPosX();
			float posY = bomb.getPosY();
			if(x > posX-20 && x < posX+20 && y > posY-20 && y < posY+20) {
				pickingBomb = bomb;
				break;
			}
		}
	}

	/**
	 * places the picking bomb at the (x,y) position
	 *
	 */
	public void placeABomb(int x, int y) {
		pickingBomb.setX(x);
		pickingBomb.setY(y);
	}

	private void generateBoundaries(float width, float height) {
		for(int i = 0; i < 20; i++) {
			walls.add(Wall.createAWall(world, width, height+i*20.0f));
			walls.add(Wall.createAWall(world, width+580.0f, height+i*20.0f));
		}
		for(int i = 0; i < 30; i++) {
			walls.add(Wall.createAWall(world, width+i*20.0f, height));
			walls.add(Wall.createAWall(world, width+i*20.0f,height+ 380));
		}

	}

	/**
	 * Starts the game.
	 * @param context 
	 */
	public void start(GUI gui, ApplicationContext context) {
		world.setContactListener(new ContactListener() {
			@Override
			public void beginContact(Contact contact) {
				Fixture fixtureA = contact.getFixtureA();
				Fixture fixtureB = contact.getFixtureB();
				beginContactType(fixtureA, fixtureB);
				beginContactType(fixtureB, fixtureA);
			}

			private void beginContactType(Fixture fixtureA, Fixture fixtureB) {
				Body bodyA = fixtureA.getBody();
				Body bodyB = fixtureB.getBody();
				Object cat = bodyB.getUserData();
				switch((String)fixtureA.getUserData()) {
				case Wall.USER_DATA:
					((Cat) cat).contactWithWall();
					break;
				case Net.USER_DATA:
					Object net = bodyA.getUserData();
					((Cat) cat).contactWithNet((Net) net);
					break;
				case Bomb.USER_DATA:
					Object bomb = bodyA.getUserData();
					((Cat) cat).contactWithBomb((Bomb) bomb);
					break;
				default:
					break;
				}
			}

			@Override
			public void endContact(Contact arg0) {
				// nothing to do
			}
			@Override
			public void postSolve(Contact arg0, ContactImpulse arg1) {
				// nothing to do
			}
			@Override
			public void preSolve(Contact arg0, Manifold arg1) {
				// nothing to do
			}
		});
		isStarted = true;
		for(Cat cat: cats) {
			cat.move(new Vec2(5f, 0f));
		}
		while(!victory() && !defeat()) {
			update(gui, context);
		}
		gui.renderEnd(context, victory());
	}

	private void update(GUI gui, ApplicationContext context) {
		world.step(1f/60f, 6, 2);
		world.clearForces();
		gui.renderLevel(context, this);
	}


	private boolean defeat() {
		for(Cat cat: cats) {
			if(cat.isDead()) {
				finish = true;
				return true;
			}
		}
		return false;
	}

	private boolean victory() {
		for(Cat cat: cats) {
			if(!cat.isSafe()) {
				return false;
			}
		}
		finish = true;
		return true;
	}


	public boolean isFinished() {
		return finish;
	}

	/**
	 * Returns the list of the walls
	 * @return list of the walls
	 */
	public List<Wall> getWalls() {
		return walls;
	}

	/**
	 * Returns the list of the cats
	 * @return list of the cats
	 */
	public List<Cat> getCats() {
		return cats;
	}

	/**
	 * Returns the list of the bombs
	 * @return list of the bomb
	 */
	public List<IBomb> getBombs() {
		return bombs;
	}

	/**
	 * Returns the gun
	 * @return the gun
	 */
	public Gun getGun() {
		return gun;
	}

	/**
	 * Returns the list of the nets
	 * @return list of the nets
	 */
	public List<Net> getNets() {
		return nets;
	}

	/**
	 * Returns the JBox2D world
	 * @return JBox2D world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Returns true if the has started
	 * @return true if the game has started
	 */
	public boolean isStarted() {
		return isStarted;
	}
}
