import java.awt.Color;

import parser.Parser;
import fr.umlv.zen4.Application;
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
			ORIGIN_X = WIDTH/2-300;
			HEIGHT = screenInfo.getHeight();
			ORIGIN_Y = HEIGHT/2-300;
			System.out.println("size of the screen (" + WIDTH + " x " + HEIGHT + ")");
			System.out.println("origin of the screen (" + ORIGIN_X + " x " + ORIGIN_Y + ")");
			
			boolean pickingBomb = false;
			BoardGame game = null;
			try {
				game = Parser.parseWorld("World/World1.txt");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			GUI gui = new GUI(ORIGIN_X, ORIGIN_Y);
			gui.renderLevel(context, game);

			for(;;) {
				MotionEvent event;
				try {   // wait for a motion event
					event = context.waitAndBlockUntilAMotion();
				} catch (InterruptedException e) {
					throw new AssertionError(e);
				}
				System.out.println(event);

				// exit if the pointer is in the top left corner of the screen 
				if (!pickingBomb && event.getAction() == Action.UP && event.getX() < 20 && event.getY() < 20) {
					context.exit(0);
				}

			}
		});
	}

}
