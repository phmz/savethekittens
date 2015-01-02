package elements.cats;

import java.awt.Color;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import elements.Wall;

public class GymCat implements Cat {
	private final Body body;
    private boolean saved;
    private boolean dead;
    
	public GymCat(Body body) {
        saved = false;
        dead = false;
        this.body = body;
	}
    
	public static GymCat createAGymCat(World world, float width, float height) {
		return new GymCat(AbstractCat.createABody(world, width, height));
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
	public boolean isDead() {
		return dead;
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

	@Override
	public void move(Vec2 v) {
		body.setActive(true);
		body.setLinearVelocity(v);
	}

}
