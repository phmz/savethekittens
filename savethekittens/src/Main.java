import java.awt.Color;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import Elements.Wall;
import Elements.Cats.Cat;
import Elements.Cats.ClassyCat;
import Elements.Cats.ClawedCat;
import Elements.Cats.GymCat;
import Elements.Guns.Gun;
import Elements.Guns.SimpleGun;
import Game.BoardGame;
import Interface.GUI;
import fr.umlv.zen4.Application;
import fr.umlv.zen4.MotionEvent;
import fr.umlv.zen4.MotionEvent.Action;
import fr.umlv.zen4.ScreenInfo;

public class Main {

	public static float WIDTH;
	public static float ORIGIN_X;
	public static float HEIGHT;
	public static float ORIGIN_Y;

	public static void main(String[] args) {
		System.out.println("hello world!");
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
			Path path = null;
			/*BoardGame game = null;
			try {
				game = BoardGame.createABoardGame(path);
			} catch (Exception e1) {
				System.err.println("unknown file");
				//return;
			}*/
			World world = new World(new Vec2(0, 0));
			Wall wall = Wall.createAWall(ORIGIN_X+100f, ORIGIN_Y+100f, world);
			List<Cat> cats = new ArrayList<Cat>();

			float posCat = 0;
			Cat cat = ClassyCat.createAClassyCat(world, posCat, ORIGIN_X, ORIGIN_Y);
			posCat+=50f;
			Cat cat2 = ClawedCat.createAClawedCat(world, posCat, ORIGIN_X, ORIGIN_Y);
			posCat+=50f;
			Cat cat3 = GymCat.createAGymCat(world, posCat, ORIGIN_X, ORIGIN_Y);
			cats.add(cat);
			cats.add(cat2);
			cats.add(cat3);
			Gun gun = new SimpleGun(ORIGIN_X, ORIGIN_Y);
			BoardGame game = new BoardGame(wall, cats, gun);

			GUI gui = new GUI();
			//gui.loadingScreen(context, WIDTH, HEIGHT);
			gui.fillScreen(context, WIDTH, HEIGHT);
			gui.renderLevel(context, ORIGIN_X, ORIGIN_Y, game);

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
