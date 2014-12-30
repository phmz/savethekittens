package Elements.Cats;

import java.awt.Color;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import Elements.Wall;

public class ClassyCat implements Cat {
	private final Body body;
    private boolean saved;

	public ClassyCat(Body body) {
        saved = false;
		this.body = body;
	}
	
	public static ClassyCat createAClassyCat(World world, float pos) {
		return new ClassyCat(AbstractCat.createABody(world, pos));
	}
    
	@Override
	public float getPosX() {
		return body.getPosition().x;
	}

	@Override
	public float getPosY() {
		return body.getPosition().y;
	}

	@Override
	public boolean isSafe() {
		return saved;
	}

	@Override
	public void edgeCollision() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addJointure(Wall... walls) {
		for(Wall wall:walls) {
			// TO DO
		}
	}
	
	@Override
	public Color getColor() {
		return Color.CYAN;
	}

}
