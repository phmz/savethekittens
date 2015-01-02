package elements.cats;

import java.awt.Color;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import elements.Net;
import elements.Wall;
import elements.bombs.Bomb;
import elements.bombs.IBomb;

class AbstractCat implements Cat {

	private final Body body;
	private boolean saved;
	private boolean dead;

	/**
	 * creates a JBox2D body
	 * 
	 * @param world
	 *            JBox2D world
	 * @param width
	 *            position of the cat on x
	 * @param height
	 *            position of the cat on y
	 * @return JBox2D body
	 */
	public static Body createABody(World world, float width, float height) {
		CircleShape circ = new CircleShape();
		FixtureDef fd = new FixtureDef();
		fd.shape = circ;
		fd.filter.categoryBits = ID_CAT;
		fd.filter.maskBits = Wall.ID_WALL | Net.ID_NET | Bomb.ID_BOMB;
		BodyDef bod = new BodyDef();
		bod.type = BodyType.DYNAMIC;
		bod.position.set(21f, 190f);
		Body myBody = world.createBody(bod);
		myBody.createFixture(fd).setUserData(USER_DATA);
		return myBody;
	}

	/**
	 * Creates a new cat
	 * 
	 * @param body
	 *            JBox2D body
	 */
	AbstractCat(Body body) {
		this.body = body;
		saved = false;
		dead = false;
	}

	@Override
	public float getPosX() {
		return body.getPosition().x;
	}

	@Override
	public float getPosY() {
		return body.getPosition().y;
	}

	@Override
	public boolean isSafe() {
		return saved;
	}

	@Override
	public Color getColor() {
		return Color.DARK_GRAY;
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void move(Vec2 v) {
		body.setActive(true);
		body.setLinearVelocity(v);
	}

	@Override
	public void contactWithWall() {
		dead = true;
	}

	@Override
	public void contactWithNet(Net net) {
		if (net.isEmpty()) {
			saved = true;
		} else {
			dead = true;
		}
	}

	@Override
	public void contactWithBomb(IBomb bomb) {
		Vec2 impulse = new Vec2(5f, 5f);
		Vec2 point = new Vec2(0,0);
		body.applyLinearImpulse(impulse, point);
	}

}