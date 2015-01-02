package elements.cats;

import java.awt.Color;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class GymCat extends AbstractCat {
    
	private GymCat(Body body) {
        super(body);
	}
    
	/**
	 * Creates a gym cat.
	 * @param world JBox2D world
	 * @param width position of the cat
	 * @param height position of the cat
	 * @return a new gym cat
	 */
	public static GymCat createAGymCat(World world, float width, float height) {
		Body body = AbstractCat.createABody(world, width, height);
		GymCat gymCat = new GymCat(body);
		body.setUserData(gymCat);
		return gymCat;
	}
	
	@Override
	public Color getColor() {
		return Color.PINK;
	}

}
