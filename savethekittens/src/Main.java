import java.awt.Color;

import fr.umlv.zen4.Application;
import fr.umlv.zen4.ApplicationContext;
import fr.umlv.zen4.MotionEvent;
import fr.umlv.zen4.MotionEvent.Action;
import fr.umlv.zen4.ScreenInfo;
import game.BoardGame;
import graphics.GUI;

public class Main {

	public static float WIDTH;
	public static float ORIGIN_X;
	public static float HEIGHT;
	public static float ORIGIN_Y;

	public static void main(String[] args) {
		Application.run(Color.BLACK, context -> {

			// get the size of the screen
				ScreenInfo screenInfo = context.getScreenInfo();
				WIDTH = screenInfo.getWidth();
				ORIGIN_X = WIDTH / 2 - 300;
				HEIGHT = screenInfo.getHeight();
				ORIGIN_Y = HEIGHT / 2 - 300;

				boolean pickingBomb = false;
				BoardGame game = BoardGame.loadWorld("World/World1.txt");
				GUI gui = new GUI(ORIGIN_X, ORIGIN_Y);
				gui.loadingScreen(context);
				try {
					Thread.sleep(2000);
				} catch (Exception e1) {
					System.err.println("Fatal error");
				}
				for (;;) {

					if (game.isFinished()) {
						gui.renderNext(context);
					} else {
						gui.renderLevel(context, game);
					}

					MotionEvent event = null;
					try { // wait for a motion event
					event = context.waitAndBlockUntilAMotion();
				} catch (InterruptedException e) {
					throw new AssertionError(e);
				}

				// exit if the pointer is in the top left corner of the
				// screen
				if (!pickingBomb && event.getAction() == Action.UP
						&& event.getX() < 20 && event.getY() < 20) {
					context.exit(0);
				}

				if (game.isFinished()) {
					if (checkNext(game, event)) {
						game = BoardGame.loadWorld("World/World2.txt");
						continue;
					}
				}

				if (!pickingBomb && checkStart(game, event, gui, context)) {
					game.start(gui, context);
				}
				;

			}
		});
	}

	private static boolean checkNext(BoardGame game, MotionEvent event) {
		if (event.getAction() == Action.UP && event.getX() < 350 + ORIGIN_X
				&& event.getX() > 250 + ORIGIN_X
				&& event.getY() < 525 + ORIGIN_Y
				&& event.getY() > 475 + ORIGIN_Y) {
			return true;
		}
		return false;
	}

	private static boolean checkStart(BoardGame game, MotionEvent event,
			GUI gui, ApplicationContext context) {
		if (!game.isStarted() && event.getAction() == Action.UP
				&& event.getX() < 350 + ORIGIN_X
				&& event.getX() > 250 + ORIGIN_X
				&& event.getY() < 525 + ORIGIN_Y
				&& event.getY() > 475 + ORIGIN_Y) {
			return true;
		}
		return false;
	}

}
