package game;

import java.util.List;

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
    		walls.add(Wall.createAWall(world, width, height+i*20.0f));
    		walls.add(Wall.createAWall(world, width+580.0f, height+i*20.0f));
    	}
    	for(int i = 0; i < 30; i++) {
    		walls.add(Wall.createAWall(world, width+i*20.0f, height));
    		walls.add(Wall.createAWall(world, width+i*20.0f,height+ 380));
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
