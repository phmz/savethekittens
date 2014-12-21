package Interface;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import fr.umlv.zen4.ApplicationContext;

public class GUI {

	public static class Area {
		private Rectangle2D.Float rectangle = new Rectangle2D.Float(0, 0, 0, 0);

		public void render(ApplicationContext context, float x, float y, float width, float height) {
			context.renderFrame((graphics, contentLost) -> {
				if (contentLost) {  // we need to render the whole screen
					graphics.setColor(Color.BLACK);
					graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
				}

				// hide the previous rectangle
				graphics.setColor(Color.BLACK);
				graphics.draw(rectangle);

				// show a new rectangle at the position of the pointer
				graphics.setColor(Color.CYAN);
				rectangle = new Rectangle2D.Float(x - 20, y - 20, 40, 40);
				graphics.draw(rectangle);
			});
		}
	}

	public void loadingScreen(ApplicationContext context, float width, float height) {
		context.renderFrame((graphics, contentLost) -> {
			if (contentLost) {  // we need to render the whole screen
				graphics.setColor(Color.BLACK);
				graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
			}

			graphics.setColor(Color.WHITE);
			graphics.drawString("Bomb'o Cat", width/2, height/2);
		});
	}
}
