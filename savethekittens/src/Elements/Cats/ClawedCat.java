package Elements.Cats;

import java.awt.Color;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import Elements.Wall;

public class ClawedCat extends AbstractCat implements Cat {
	private final Body body;
    private boolean saved;
    
	public ClawedCat(Body body) {
        saved = false;
		this.body = body;
	}
    
	public static ClawedCat createAClawedCat(World world, float pos) {
		return new ClawedCat(AbstractCat.createABody(world, pos));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}
}
