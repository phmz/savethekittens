package Interface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import Elements.Wall;
import Elements.Cats.Cat;
import Game.BoardGame;
import fr.umlv.zen4.ApplicationContext;

public class GUI {

	public void renderLevel(ApplicationContext context, float width,
			float height, BoardGame boardgame) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				graphics.setColor(Color.BLACK);
				graphics.fill(new Rectangle2D.Float(0, 0, width, height));
			}
			graphics.setColor(new Color(240, 240, 240));
			graphics.fill(new Rectangle2D.Float(0, 0, width, height * 0.8f));
			if (boardgame != null) {
				renderWalls(boardgame, graphics);
				renderCats(boardgame, graphics);
			}
		});
	}

	private void renderWalls(BoardGame boardgame, Graphics2D graphics) {
		for (Wall wall : boardgame.getWalls()) {
			renderWall(graphics, wall);
		}
	}

	private void renderWall(Graphics2D graphics, Wall wall) {
		graphics.setColor(Color.RED);
		graphics.fill(new Rectangle2D.Float(wall.getPosX(), wall
				.getPosY(), wall.getWidth(), wall.getHeight()));
	}
	
	private void renderCats(BoardGame boardgame, Graphics2D graphics) {
		for (Cat cat : boardgame.getCats()) {
			renderCat(graphics, cat);
		}
	}

	private void renderCat(Graphics2D graphics, Cat cat) {
		graphics.setColor(cat.getColor());		
		graphics.fill(new Ellipse2D.Float(100f,100f,cat.getPosX(), cat.getPosY()));
	}

	public void loadingScreen(ApplicationContext context, float width,
			float height) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				graphics.setColor(Color.BLACK);
				graphics.fill(new Rectangle2D.Float(0, 0, width, height));
			}

			graphics.setColor(Color.WHITE);
			graphics.drawString("Bomb'o Cat", width / 2, height / 2);
		});
	}
}
