package Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import Elements.Wall;
import Elements.Bombs.IBomb;
import Elements.Cats.Cat;

public class BoardGame {
	private final List<Wall> walls;
	private final List<Cat> cats;
	private final List<IBomb> bombs;
    private IBomb pickingBomb;
   
	private BoardGame(List<Wall> walls, List<Cat> cats, List<IBomb> bombs) {
		this.walls = walls;
		this.cats = cats;
		this.bombs = bombs;
	}

	public static BoardGame createABoardGame(Path path) throws IOException {
		List<Wall> walls = null;
		List<Cat> cats = null;
		List<IBomb> bombs = null;
		Files.lines(path).forEach(l -> parseLine(l));
		return new BoardGame(walls, cats, bombs);
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
}
