package Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import Elements.Gun;
import Elements.Wall;
import Elements.Bombs.IBomb;
import Elements.Cats.Cat;

public class BoardGame {
	private final List<Wall> walls;
	private final List<Cat> cats;
	private final List<IBomb> bombs;
	private final Gun gun;
    private IBomb pickingBomb;
   
	public BoardGame(List<Wall> walls, List<Cat> cats, List<IBomb> bombs, Gun gun) {
		this.walls = walls;
		this.cats = cats;
		this.bombs = bombs;
		this.gun = gun;
	}
	
	public BoardGame(Wall wall, List<Cat> cats) {
		walls = new ArrayList<Wall>();
		walls.add(wall);
		this.cats = cats;
		this.bombs = null;
		this.gun = null;
	}

	public static BoardGame createABoardGame(Path path) throws IOException {
		List<Wall> walls = null;
		List<Cat> cats = null;
		List<IBomb> bombs = null;
		Gun gun = null;
		Files.lines(path).forEach(l -> parseLine(l));
		return new BoardGame(walls, cats, bombs, gun);
	}

	private static Object parseLine(String l) {
		// TODO Auto-generated method stub
		return null;
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
}
