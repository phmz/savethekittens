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
    private final float width = 50.0f;
    private final float height = 50.0f;
    
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
        poly.setAsBox(50.0f, 50.0f);
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

	public int getPosX() {
		return (int) body.getPosition().x;
	}

	public int getPosY() {
		return (int) body.getPosition().y;
	}
}
