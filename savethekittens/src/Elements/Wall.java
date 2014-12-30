package Elements;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class Wall {
    private final Body body;
    
    public Wall(Body body) {
        this.body = body;
    }
    
    public static void createAWall(float x, float y) {
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(20.0f, 20.0f);
        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.position = new Vec2(x, y);
        Body myBody = getWorld().createBody(bd);
        FixtureDef fd = new FixtureDef();
        fd.shape = poly;
        fd.friction = 1.0f;
        myBody.createFixture(fd);
    }

	public int getPosX() {
		return (int) body.getPosition().x;
	}

	public int getPosY() {
		return (int) body.getPosition().y;
	}
}
