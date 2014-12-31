package Elements.Cats;

import java.awt.Color;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import Elements.Wall;

public class GymCat implements Cat {
	private final Body body;
    private boolean saved;
    
	public GymCat(Body body) {
        saved = false;
        this.body = body;
	}
    
	public static GymCat createAGymCat(World world, float pos, float width, float height) {
		return new GymCat(AbstractCat.createABody(world, pos, width, height));
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
		return Color.PINK;
	}

}
