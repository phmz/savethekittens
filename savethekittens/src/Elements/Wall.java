package Elements;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Wall {
    private final Body body;
    private static final float width = 10.0f;
    private static final float height = 10.0f;
    
    public Wall(Body body) {
        this.body = body;
    }
    
    public float getWidth() {
		return width;
	}
    
    public float getHeight() {
		return height;
	}
    
    public static Wall createAWall(float x, float y, World world) {
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width, height);
        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.position = new Vec2(x, y);
        Body myBody = world.createBody(bd);
        FixtureDef fd = new FixtureDef();
        fd.shape = poly;
        fd.friction = 1.0f;
        myBody.createFixture(fd);
        return new Wall(myBody);
    }

	public float getPosX() {
		return body.getPosition().x;
	}

	public float getPosY() {
		return body.getPosition().y;
	}
}
