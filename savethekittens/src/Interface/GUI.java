package Interface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


import Elements.Wall;
import Elements.Cats.Cat;
import Game.BoardGame;
import fr.umlv.zen4.ApplicationContext;

public class GUI {

	public void renderLevel(ApplicationContext context, float width, float height, BoardGame boardgame) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				graphics.setColor(Color.BLACK);
				graphics.fill(new Rectangle2D.Float(0, 0, width, height));
			}
			graphics.setColor(new Color(240, 240, 240));
			graphics.fill(new Rectangle2D.Float(width/2-300, height/2-300, 600, 600));
			graphics.setColor(Color.BLACK);
			graphics.fill(new Line2D.Float(width/2-300, height/2+100, width/2+300, height/2+100));
			if (boardgame != null) {
				renderWalls(boardgame, graphics);
				renderCats(boardgame, graphics);
				renderGun(boardgame, graphics);
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
		graphics.fill(new Ellipse2D.Float(cat.getPosX(), cat.getPosY(), 20f, 20f));
	}

	public void loadingScreen(ApplicationContext context, float width, float height) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) { // we need to render the whole screen
				graphics.setColor(Color.BLACK);
				graphics.fill(new Rectangle2D.Float(0, 0, width, height));
			}

			graphics.setColor(Color.WHITE);
			graphics.drawString("Bomb'o Cat", width / 2, height / 2);
		});
	}
	
	public void renderGun(BoardGame boardGame, Graphics2D graphics) {
		graphics.setColor(boardGame.getGun().getColor());
		graphics.fill(new Rectangle2D.Float(boardGame.getGun().getX(), boardGame.getGun().getY(), 100f, 50f));
	}
}
