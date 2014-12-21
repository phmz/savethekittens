import java.awt.Color;


import Interface.GUI;
import Interface.GUI.Area;
import fr.umlv.zen4.Application;
import fr.umlv.zen4.MotionEvent;
import fr.umlv.zen4.ScreenInfo;
import fr.umlv.zen4.MotionEvent.Action;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world!");
		Application.run(Color.BLACK, context -> {

			// get the size of the screen
			ScreenInfo screenInfo = context.getScreenInfo();
			float width = screenInfo.getWidth();
			float height = screenInfo.getHeight();
			System.out.println("size of the screen (" + width + " x " + height + ")");

			Area area = new Area();
			GUI gui = new GUI();
			gui.loadingScreen(context, width, height);
			for(;;) {
				MotionEvent event;
				try {   // wait for a motion event
					event = context.waitAndBlockUntilAMotion();
				} catch (InterruptedException e) {
					throw new AssertionError(e);
				}
				System.out.println(event);

				// exit if the pointer is in the top left corner of the screen 
				if (event.getAction() == Action.UP && event.getX() < 20 && event.getY() < 20) {
					context.exit(0);
				}
				area.render(context, event.getX(), event.getY(), width, height);
				
			}
		});
	}

}
