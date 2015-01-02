package elements.cats;

import java.awt.Color;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class ClawedCat extends AbstractCat {
    
	private ClawedCat(Body body) {
		super(body);
	}
	
	/**
	 * Creates a clawed cat.
	 * @param world JBox2D world
	 * @param width position of the cat
	 * @param height position of the cat
	 * @return a new clawed cat
	 */
	public static ClawedCat createAClawedCat(World world, float width, float height) {
		Body body = AbstractCat.createABody(world, width, height);
		ClawedCat clawedCat = new ClawedCat(body);
		body.setUserData(clawedCat);
		return clawedCat;
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}

}
