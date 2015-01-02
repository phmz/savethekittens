package elements.cats;

import java.awt.Color;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class ClassyCat extends AbstractCat {

	private ClassyCat(Body body) {
        super(body);
	}
	
	/**
	 * Creates a classy cat.
	 * @param world JBox2D world
	 * @param width position of the cat
	 * @param height position of the cat
	 * @return a new classy cat
	 */
	public static ClassyCat createAClassyCat(World world, float width, float height) {
		Body body = AbstractCat.createABody(world, width, height);
		ClassyCat newCat = new ClassyCat(body);
		body.setUserData(newCat);
		return newCat;
	}
	
	@Override
	public Color getColor() {
		return Color.CYAN;
	}

}
