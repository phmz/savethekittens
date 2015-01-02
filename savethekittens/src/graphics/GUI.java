package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import elements.Net;
import elements.Wall;
import elements.bombs.IBomb;
import elements.cats.Cat;
import fr.umlv.zen4.ApplicationContext;
import game.BoardGame;

public class GUI {

	private final float originX;
	private final float originY;

	public GUI(float width, float height) {
		this.originX = width;
		this.originY = height;
	}

	public void renderLevel(ApplicationContext context, BoardGame boardgame) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				fillScreen(graphics);
			}
			// render the 600*600 screen
			graphics.setColor(new Color(240, 240, 240));
			graphics.fill(new Rectangle2D.Float(originX, originY, 600, 400));
			graphics.fill(new Rectangle2D.Float(originX, originY + 402, 600,
					198));

			renderButton(graphics);
			if (boardgame != null) {
				renderWalls(boardgame, graphics);
				renderCats(boardgame, graphics);
				renderGun(boardgame, graphics);
				renderNets(boardgame, graphics);
				renderBombs(boardgame, graphics);
			}
		});
	}

	public void fillScreen(ApplicationContext context) {
		context.renderFrame((graphics, contentLost) -> {
			fillScreen(graphics);
		});
	}

	private void fillScreen(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Rectangle2D.Float(0, 0, originX, originY));
	}

	private void renderWalls(BoardGame boardgame, Graphics2D graphics) {
		for (Wall wall : boardgame.getWalls()) {
			renderWall(graphics, wall);
		}
	}

	private void renderWall(Graphics2D graphics, Wall wall) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Rectangle2D.Float(wall.getPosX() + originX, wall
				.getPosY() + originY, wall.getWidth(), wall.getHeight()));
		graphics.setColor(Color.GRAY);
		graphics.fill(new Rectangle2D.Float(wall.getPosX() + 1 + originX, wall
				.getPosY() + 1 + originY, wall.getWidth() - 2,
				wall.getHeight() - 2));

	}

	private void renderCats(BoardGame boardgame, Graphics2D graphics) {
		for (Cat cat : boardgame.getCats()) {
			renderCat(graphics, cat);
		}
	}

	private void renderCat(Graphics2D graphics, Cat cat) {
		graphics.setColor(cat.getColor());
		graphics.fill(new Ellipse2D.Float(cat.getPosX() + originX, cat
				.getPosY() + originY, 20f, 20f));
	}

	public void loadingScreen(ApplicationContext context) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				fillScreen(graphics);
			}

			graphics.setColor(Color.WHITE);
			graphics.drawString("Bomb'o Cat", originX / 2, originY / 2);
		});
	}

	public void renderGun(BoardGame boardGame, Graphics2D graphics) {
		graphics.setColor(boardGame.getGun().getColor());
		graphics.fill(new Rectangle2D.Float(boardGame.getGun().getX()+originX,
				boardGame.getGun().getY()+originY, 40f, 30f));
	}

	public void renderButton(Graphics2D graphics) {
		graphics.setColor(Color.RED);
		graphics.fill(new Rectangle2D.Float(originX + 250, originY + 475, 100,
				50));
		graphics.setColor(Color.GREEN);
		graphics.fill(new Rectangle2D.Float(originX + 255, originY + 480, 90,
				40));
		graphics.setColor(Color.BLACK);
		graphics.drawString("START", originX + 282, originY + 505);
	}

	public void renderNets(BoardGame boardGame, Graphics2D graphics) {
		for (Net net : boardGame.getNets()) {
			renderNet(graphics, net);
		}
	}

	private void renderNet(Graphics2D graphics, Net net) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Rectangle2D.Float(net.getPosX() + originX, net
				.getPosY() + originY, net.getWidth(), net.getHeight()));
		graphics.setColor(Color.ORANGE);
		graphics.fill(new Rectangle2D.Float(net.getPosX()+1 + originX, net
				.getPosY()+1 + originY, net.getWidth()-2, net.getHeight()-2));
	}
	
	private void renderBombs(BoardGame boardgame, Graphics2D graphics) {
		for(IBomb bomb:boardgame.getBombs()) {
			renderBomb(graphics, bomb);
		}
	}

	private void renderBomb(Graphics2D graphics, IBomb bomb) {
		graphics.setColor(bomb.getColor());
		graphics.fill(new Ellipse2D.Float(bomb.getPosX()+originX, bomb.getPosY()+originY, 20f, 20f));
	}
}
