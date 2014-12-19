package Interface;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen4.Application;
import fr.umlv.zen4.ApplicationContext;
import fr.umlv.zen4.MotionEvent;
import fr.umlv.zen4.ScreenInfo;
import fr.umlv.zen4.MotionEvent.Action;

public class Graphic {
	static class Area {
	    private Rectangle2D.Float rectangle = new Rectangle2D.Float(0, 0, 0, 0);
	    
	    void render(ApplicationContext context, float x, float y, float width, float height) {
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
	  
	  public static void main(String[] args) {
	    Application.run(Color.BLACK, context -> {
	      
	      // get the size of the screen
	      ScreenInfo screenInfo = context.getScreenInfo();
	      float width = screenInfo.getWidth();
	      float height = screenInfo.getHeight();
	      System.out.println("size of the screen (" + width + " x " + height + ")");
	      
	      Area area = new Area();
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
