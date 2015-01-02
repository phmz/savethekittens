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

	/**
	 * Creates a new GUI.
	 * @param width width of the screen
	 * @param height height of the screen
	 */
	public GUI(float width, float height) {
		this.originX = width;
		this.originY = height;
	}

	/**
	 * Print the level on the screen.
	 * @param context the context
	 * @param boardgame the boardgame
	 */
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

			renderButton(graphics, "START");
			if (boardgame != null) {
				renderWalls(boardgame, graphics);
				renderGun(boardgame, graphics);
				renderCats(boardgame, graphics);
				renderNets(boardgame, graphics);
				renderBombs(boardgame, graphics);
			}
		});
	}

	/**
	 * Fills the screen with black.
	 * @param context the context
	 */
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
		for (int i = 0; i < boardgame.getCats().size(); i++) {
			renderCat(graphics, boardgame.getCats().get(i), i);
		}
	}

	private void renderCat(Graphics2D graphics, Cat cat, int pos) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Ellipse2D.Float(cat.getPosX() + originX, cat
				.getPosY() + originY, 20f, 20f));
		graphics.setColor(cat.getColor());
		graphics.fill(new Ellipse2D.Float(cat.getPosX() + 1 + originX, cat
				.getPosY() + 1 + originY, 20f - 2, 20f - 2));

		graphics.setColor(Color.BLACK);
		graphics.fill(new Ellipse2D.Float(50 + 20 * pos + originX,
				490 + originY, 20f, 20f));
		if (cat.isSafe()) {
			graphics.setColor(Color.GREEN);
		} else if (cat.isDead()) {
			graphics.setColor(Color.RED);
		} else {
			graphics.setColor(cat.getColor());
		}
		graphics.fill(new Ellipse2D.Float(50 + 20 * pos + originX + 1,
				490 + originY + 1, 20f - 2, 20f - 2));

	}

	/**
	 * Renders the loading screen
	 * @param context the context
	 */
	public void loadingScreen(ApplicationContext context) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				fillScreen(graphics);
			}

			graphics.setColor(Color.YELLOW);
			graphics.drawString("Bomb'o Cat", originX+280, originY-20);
		});
	}

	private void renderGun(BoardGame boardGame, Graphics2D graphics) {
		graphics.setColor(boardGame.getGun().getColor());
		graphics.fill(new Rectangle2D.Float(
				boardGame.getGun().getX() + originX, boardGame.getGun().getY()
						+ originY, 40f, 20f));
	}

	private void renderButton(Graphics2D graphics, String string) {
		graphics.setColor(Color.RED);
		graphics.fill(new Rectangle2D.Float(originX + 250, originY + 475, 100,
				50));
		graphics.setColor(Color.GREEN);
		graphics.fill(new Rectangle2D.Float(originX + 255, originY + 480, 90,
				40));
		graphics.setColor(Color.BLACK);
		graphics.drawString(string, originX + 282, originY + 505);
	}

	private void renderNets(BoardGame boardGame, Graphics2D graphics) {
		for (Net net : boardGame.getNets()) {
			renderNet(graphics, net);
		}
	}

	private void renderNet(Graphics2D graphics, Net net) {
		graphics.setColor(Color.BLACK);
		graphics.fill(new Rectangle2D.Float(net.getPosX() + originX, net
				.getPosY() + originY, net.getWidth(), net.getHeight()));
		graphics.setColor(Color.ORANGE);
		graphics.fill(new Rectangle2D.Float(net.getPosX() + 1 + originX, net
				.getPosY() + 1 + originY, net.getWidth() - 2,
				net.getHeight() - 2));
	}

	private void renderBombs(BoardGame boardgame, Graphics2D graphics) {
		for (IBomb bomb : boardgame.getBombs()) {
			renderBomb(graphics, bomb);
		}
	}

	private void renderBomb(Graphics2D graphics, IBomb bomb) {
		graphics.setColor(bomb.getColor());
		graphics.fill(new Ellipse2D.Float(bomb.getPosX() + originX, bomb
				.getPosY() + originY, 20f, 20f));
	}

	/**
	 * Render the end when the level is finished
	 * @param context the context
	 * @param victory true if player is victorious
	 */
	public void renderEnd(ApplicationContext context, boolean victory) {
		context.renderFrame((graphics, contentLost) -> {
			Color color;
			String str;
			if(victory) {
				color = Color.YELLOW;
				str = "VICTORY";
			}
			else {
				color = Color.RED;
				str = "DEFEAT";
			}
			graphics.setColor(Color.BLACK);
			graphics.fill(new Rectangle2D.Float(originX+200, originY+150, 200,100));
			graphics.setColor(color);
			graphics.fill(new Rectangle2D.Float(originX+210, originY+160, 180, 80));
			graphics.setColor(Color.BLACK);
			graphics.drawString(str, originX+280, originY+205);
		});
	}

	/**
	 * Renders the next button.
	 * @param context the context
	 */
	public void renderNext(ApplicationContext context) {
		context.renderFrame((graphics, contentlost) -> {
			renderButton(graphics, "NEXT");
		});
	}
}
