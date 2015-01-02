package elements.cats;

import java.awt.Color;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class ClawedCat extends AbstractCat {
    
	public ClawedCat(Body body) {
		super(body);
	}
    
	public static ClawedCat createAClawedCat(World world, float width, float height) {
		return new ClawedCat(AbstractCat.createABody(world, width, height));
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}

}
