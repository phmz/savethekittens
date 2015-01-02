package elements.cats;

import java.awt.Color;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class GymCat extends AbstractCat {
    
	public GymCat(Body body) {
        super(body);
	}
    
	public static GymCat createAGymCat(World world, float width, float height) {
		return new GymCat(AbstractCat.createABody(world, width, height));
	}
	
	@Override
	public Color getColor() {
		return Color.PINK;
	}

}
