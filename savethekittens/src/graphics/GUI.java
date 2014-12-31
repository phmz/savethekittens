package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import elements.Net;
import elements.Wall;
import elements.cats.Cat;
import fr.umlv.zen4.ApplicationContext;
import game.BoardGame;

public class GUI {

	public void renderLevel(ApplicationContext context, float width, float height, BoardGame boardgame) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				fillScreen(width, height, graphics);
			}
			// render the 600*600 screen
			graphics.setColor(new Color(240, 240, 240));
			graphics.fill(new Rectangle2D.Float(width, height, 600, 400));
			graphics.fill(new Rectangle2D.Float(width, height+402, 600, 198));
			
			renderButton(graphics, width, height);
			if (boardgame != null) {
				renderWalls(boardgame, graphics);
				renderCats(boardgame, graphics);
				renderGun(boardgame, graphics);
				renderNets(boardgame, graphics);
			}
		});
	}

	public void fillScreen(ApplicationContext context, float width, float height) {
		context.renderFrame((graphics, contentLost) -> {
			fillScreen(width, height, graphics);
		});
	}
	
	private void fillScreen(float width, float height, Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Rectangle2D.Float(0, 0, width, height));
	}

	private void renderWalls(BoardGame boardgame, Graphics2D graphics) {
		for (Wall wall : boardgame.getWalls()) {
			renderWall(graphics, wall);
		}
	}

	private void renderWall(Graphics2D graphics, Wall wall) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Rectangle2D.Float(wall.getPosX(), wall
				.getPosY(), wall.getWidth(), wall.getHeight()));
		graphics.setColor(Color.GRAY);
		graphics.fill(new Rectangle2D.Float(wall.getPosX()+1, wall
				.getPosY()+1, wall.getWidth()-1, wall.getHeight()-1));

	}
	
	private void renderCats(BoardGame boardgame, Graphics2D graphics) {
		for (Cat cat : boardgame.getCats()) {
			renderCat(graphics, cat);
		}
	}

	private void renderCat(Graphics2D graphics, Cat cat) {
		graphics.setColor(cat.getColor());		
		graphics.fill(new Ellipse2D.Float(cat.getPosX(), cat.getPosY(), 20f, 20f));
	}

	public void loadingScreen(ApplicationContext context, float width, float height) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				fillScreen(width, height, graphics);
			}

			graphics.setColor(Color.WHITE);
			graphics.drawString("Bomb'o Cat", width / 2, height / 2);
		});
	}
	
	public void renderGun(BoardGame boardGame, Graphics2D graphics) {
		graphics.setColor(boardGame.getGun().getColor());
		graphics.fill(new Rectangle2D.Float(boardGame.getGun().getX(), boardGame.getGun().getY(), 40f, 30f));
	}
	
	public void renderButton(Graphics2D graphics, float width, float height) {
		graphics.setColor(Color.RED);
		graphics.fill(new Rectangle2D.Float(width+250, height+475, 100, 50));
		graphics.setColor(Color.GREEN);
		graphics.fill(new Rectangle2D.Float(width+255, height+480, 90, 40));
		graphics.setColor(Color.BLACK);
		graphics.drawString("START", width+282, height+505);
	}

	public void renderNets(BoardGame boardGame, Graphics2D graphics) {
		for(Net net:boardGame.getNets()) {
			renderNet(graphics, net);
		}
	}

	private void renderNet(Graphics2D graphics, Net net) {
		graphics.setColor(Color.ORANGE);
		graphics.fill(new Rectangle2D.Float(net.getX(), net.getY(), net.getWidth(), net.getHeight()));
	}
}
