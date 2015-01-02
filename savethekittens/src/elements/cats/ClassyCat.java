package elements.cats;

import java.awt.Color;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class ClassyCat extends AbstractCat {

	public ClassyCat(Body body) {
        super(body);
	}
	
	public static ClassyCat createAClassyCat(World world, float width, float height) {
		return new ClassyCat(AbstractCat.createABody(world, width, height));
	}
	
	@Override
	public Color getColor() {
		return Color.CYAN;
	}

}
