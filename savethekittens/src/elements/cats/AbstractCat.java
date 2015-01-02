package elements.cats;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

class AbstractCat {

	/**
	 * creates a JBos2D body
	 * @param world JBox2D world
	 * @param width position of the cat on x
	 * @param height position of the cat on y 
	 * @return JBox2D body
	 */
	public static Body createABody(World world, float width, float height) {
	    CircleShape circ = new CircleShape();
	    BodyDef bod = new BodyDef();
	    bod.type = BodyType.DYNAMIC;
	    FixtureDef fd = new FixtureDef();
	    fd.shape = circ;
	    bod.position = new Vec2(0f, 190f);
	    Body myBody = world.createBody(bod);
	    myBody.createFixture(fd);
	    myBody.setSleepingAllowed(true);
	    return myBody;
	}

	public AbstractCat() {
		super();
	}

}