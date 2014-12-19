package Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import Elements.Cat;
import Elements.IBomb;
import Elements.Wall;

public class BoardGame {
	private final List<Wall> walls;
	private final List<Cat> cats;
	private final List<IBomb> bombs;

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
}
