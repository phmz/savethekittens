package elements;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Net {
    private final Body body;
    private static final float width = 20.0f;
    private static final float height = 20.0f;
	public static final String USER_DATA = "Net";
    
    private Net(Body body) {
        this.body = body;
    }
    
    /**
     * Returns the width of the net.
     * @return width of the net
     */
    public float getWidth() {
		return width;
	}
    
    /**
     * Returns the height of the net
     * @return height of the net
     */
    public float getHeight() {
		return height;
	}
    
    /**
     * Creates a net.
     * @param world JBox2D world
     * @param x position of the net
     * @param y position of the net
     * @return  a new net
     */
    public static Net createANet(World world, float x, float y) {
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width, height);
        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.position = new Vec2(x, y);
        Body myBody = world.createBody(bd);
        FixtureDef fd = new FixtureDef();
        fd.shape = poly;
        fd.friction = 1.0f;
        myBody.createFixture(fd).setUserData(USER_DATA);
        return new Net(myBody);
    }

    /**
     * Returns the horizontal position of the net.
     * @return horizontal position of the net
     */
	public float getPosX() {
		return body.getPosition().x;
	}

	/**
	 * Returns the vertical position of the net.
	 * @return vertical position of the net
	 */
	public float getPosY() {
		return body.getPosition().y;
	}
}
