package Elements.Cats;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

class AbstractCat {

	public static Body createABody(World world, float pos, float width, float height) {
	    CircleShape circ = new CircleShape();
	    BodyDef bod = new BodyDef();
	    bod.type = BodyType.DYNAMIC;
	    FixtureDef fd = new FixtureDef();
	    fd.shape = circ;
	    bod.position = new Vec2(width+20f+pos, height+500f);
	    Body myBody = world.createBody(bod);
	    myBody.createFixture(fd);
	    myBody.setSleepingAllowed(true);
	    return myBody;
	}

	public AbstractCat() {
		super();
	}

}