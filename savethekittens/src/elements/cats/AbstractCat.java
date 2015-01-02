package elements.cats;

import java.awt.Color;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

class AbstractCat implements Cat {

	private final Body body;
    private boolean saved;
    private boolean dead;
    
	/**
	 * creates a JBox2D body
	 * @param world JBox2D world
	 * @param width position of the cat on x
	 * @param height position of the cat on y 
	 * @return JBox2D body
	 */
	public static Body createABody(World world, float width, float height) {
	    /*
	    BodyDef bod = new BodyDef();
	    bod.type = BodyType.DYNAMIC;
	    bod.position = new Vec2(20f, 190f);*/
		CircleShape circ = new CircleShape();
	    FixtureDef fd = new FixtureDef();
	    fd.shape = circ;
		
		
		BodyDef bod = new BodyDef();
		bod.type = BodyType.DYNAMIC;
		bod.bullet = true;
		bod.active = false;
		bod.fixedRotation = false;
		bod.position.set(20f, 190f);
		bod.linearVelocity = new Vec2(0f,0f);
		bod.angularVelocity = 10f;

		
		
	    Body myBody = world.createBody(bod);
	    myBody.createFixture(fd);
	    return myBody;
	}

	/**
	 * Creates a new cat
	 * @param body JBox2D body
	 */
	public AbstractCat(Body body) {
		this.body = body;
		saved = false;
		dead = false;
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
	public Color getColor() {
		// ok
		return null;
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void move(Vec2 v) {
		body.setActive(true);
		body.setLinearVelocity(v);
	}

}