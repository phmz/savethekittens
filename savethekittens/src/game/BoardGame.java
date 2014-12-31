package game;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import elements.Net;
import elements.Wall;
import elements.bombs.IBomb;
import elements.cats.Cat;
import elements.guns.Gun;

public class BoardGame {
	private final List<Wall> walls;
	private final List<Cat> cats;
	private final List<IBomb> bombs;
	private final List<Net> nets;
	private final Gun gun;
    private IBomb pickingBomb;
    private final World world;
   
	
	public BoardGame(float width, float height, Wall wall, List<Cat> cats, Gun gun, Net net) {
		this.walls = new ArrayList<Wall>();
		walls.add(wall);
		this.cats = cats;
		this.bombs = new ArrayList<IBomb>();
		this.gun = gun;
		this.nets = new ArrayList<Net>();
		nets.add(net);
		world = new World(new Vec2(0, 0));
		generateBoundaries(width, height);
	}

   
    public BoardGame(List<Wall> walls, List<Cat> cats, List<IBomb> bombs, List<Net> nets, Gun gun, World world) {
    	this.walls = walls;
    	this.cats = cats;
    	this.bombs = bombs;
    	this.nets = nets;
    	this.gun = gun;
    	this.world = world;
	}


	/**
     * picks the bomb at the position (x, y)
     *
     */
    public void pickABomb(int x, int y) {
        for(IBomb bomb: bombs) {
            int posX = bomb.getPosX();
            int posY = bomb.getPosY();
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
    		walls.add(Wall.createAWall(width, height+i*20.0f, world));
    		walls.add(Wall.createAWall(width+580.0f, height+i*20.0f, world));
    	}
    	for(int i = 0; i < 30; i++) {
    		walls.add(Wall.createAWall(width+i*20.0f, height, world));
    		walls.add(Wall.createAWall(width+i*20.0f,height+ 380, world));
    	}
    	
    }

	public void start() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Wall> getWalls() {
		return walls;
	}
	
	public List<Cat> getCats() {
		return cats;
	}
	
	public List<IBomb> getBombs() {
		return bombs;
	}
	
	public Gun getGun() {
		return gun;
	}
	
	public List<Net> getNets() {
		return nets;
	}
}
