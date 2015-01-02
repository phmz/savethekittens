package parser;

import elements.Net;
import elements.Wall;
import elements.bombs.Bomb;
import elements.bombs.IBomb;
import elements.bombs.Vortex;
import elements.cats.Cat;
import elements.cats.ClassyCat;
import elements.cats.ClawedCat;
import elements.cats.GymCat;
import elements.guns.BurstGun;
import elements.guns.DoubleGun;
import elements.guns.Gun;
import elements.guns.SimpleGun;
import game.BoardGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class Parser {
	private static int nbBomb = 0;

	/**
	 * Parse a file to create a new {@link BoardGame}.
	 * 
	 * @param fileName
	 *            name of the file
	 * @return a new {@link BoardGame}
	 * @throws IOException
	 */
	public static BoardGame parseWorld(String fileName) throws IOException {
		List<Wall> walls = new ArrayList<Wall>();
		List<Cat> cats = new ArrayList<Cat>();
		List<IBomb> bombs = new ArrayList<IBomb>();
		List<Net> nets = new ArrayList<Net>();
		Gun gun = null;
		World world = new World(new Vec2(0, 0));
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName),
				StandardCharsets.UTF_8)) {
			String line;
			while (null != (line = br.readLine())) {
				String[] tokens = line.split(" ");
				switch (tokens[0]) {
				case "Cat":
					cats.add(parseCat(world, tokens[1], cats.size()));
					break;
				case "Wall":
					walls.add(parseWall(world, tokens[1], tokens[2]));
					break;
				case "Net":
					nets.add(parseNet(world, tokens[1], tokens[2]));
					break;
				case "Bomb":
					bombs.addAll(parseBomb(tokens[1]));
					break;
				case "Vortex":
					bombs.addAll(parseVortex(tokens[1]));
					break;
				default:
					throw new IOException("err: " + tokens[0]
							+ " not recognized.");
				}
			}

		} catch (IOException e) {
			System.err.println("Cant read file");
		}

		if (cats.size() != nets.size()) {
			throw new IOException("err: number of cats (" + cats.size()
					+ ") different from number of nets (" + nets.size() + ").");
		}

		switch (cats.size()) {
		case 1:
			gun = new SimpleGun(0.0f, 190.0f);
			break;
		case 2:
			gun = new DoubleGun(0.0f, 190.0f);
			break;
		case 3:
			gun = new BurstGun(0.0f, 190.0f);
			break;
		}
		return new BoardGame(world, walls, cats, bombs, nets, gun);
	}

	private static List<IBomb> parseVortex(String count) {
		List<IBomb> vortex = new ArrayList<IBomb>();
		int nbVortex = Integer.parseInt(count);
		for (int i = 0; i < nbVortex; i++) {
			vortex.add(new Vortex((nbBomb++) * 20));
		}
		return vortex;
	}

	private static List<IBomb> parseBomb(String count) {
		List<IBomb> bombs = new ArrayList<IBomb>();
		int nbBombs = Integer.parseInt(count);
		for (int i = 0; i < nbBombs; i++) {
			bombs.add(new Bomb((nbBomb++) * 20));
		}
		return bombs;
	}

	private static Net parseNet(World world, String posX, String posY) {
		return Net.createANet(world, Float.parseFloat(posX),
				Float.parseFloat(posY));
	}

	private static Wall parseWall(World world, String posX, String posY) {
		return Wall.createAWall(world, Float.parseFloat(posX),
				Float.parseFloat(posY));
	}

	private static Cat parseCat(World world, String type, int pos)
			throws IOException {
		switch (type) {
		case "ClassyCat":
			return ClassyCat.createAClassyCat(world, 20f, 20f);
		case "GymCat":
			return GymCat.createAGymCat(world, 20f, 20f);
		case "ClawedCat":
			return ClawedCat.createAClawedCat(world, 20f, 20f);
		default:
			throw new IOException();
		}
	}
}
