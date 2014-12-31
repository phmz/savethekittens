package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import Elements.Net;
import Elements.Wall;
import Elements.Bombs.IBomb;
import Elements.Cats.Cat;
import Elements.Guns.Gun;
import Game.BoardGame;

public class Parser {

	public static BoardGame parser(String fileName) throws IOException {
		List<Wall> walls = new ArrayList<Wall>();
		List<Cat> cats = new ArrayList<Cat>();
		List<IBomb> bombs = new ArrayList<IBomb>();
		List<Net> nets = new ArrayList<Net>();
		Gun gun = null;
		World world = new World(new Vec2(0, 0));
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName),
				StandardCharsets.UTF_8)) {
			String line = br.readLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "Gun":
				gun = parseGun(tokens[1], tokens[2], tokens[3]);
				break;
			case "Cat":
				cats.add(parseCat(tokens[1], tokens[2], tokens[3]));
				break;
			case "Wall":
				walls.add(parseWall(tokens[1], tokens[2]));
				break;
			case "Net":
				nets.add(parseNet(tokens[1], tokens[2]));
				break;
			case "Bomb":
				bombs.add(parseBomb(tokens[1]));
				break;
			case "Vortex":
				bombs.add(parseVortex(tokens[1]));
				break;
			default:
				throw new IOException("err: " + tokens[0] + " not recognized.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cats.size() != nets.size()) {
			throw new IOException("err: number of cats ("+cats.size()+") different from number of nets ("+nets.size()+").");
		}
		
		if(null == gun) {
			throw new IOException("err: no gun has been created.");
		}

		return new BoardGame(walls, cats, bombs, gun, world);
	}

	private static IBomb parseVortex(String count) {
		// TODO Auto-generated method stub
		return null;
	}

	private static IBomb parseBomb(String count) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Net parseNet(String posX, String posY) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Wall parseWall(String posX, String posY) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Cat parseCat(String type, String posX, String posY) {
		switch(type) {
		case "ClassyCat":
			break;
		case "GymCat":
			break;
		case "ClawedCat":
			break;		
		}
		return null;
	}

	private static Gun parseGun(String type, String posX, String posY) {
		switch(type) {
		case "Simple":
			break;
		case "Double":
			break;
		case "Burst":
			break;		
		}
		return null;
	}

}
