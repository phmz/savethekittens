package elements;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import elements.cats.Cat;

public class Wall {
    private final Body body;
    private static final float width = 20.0f;
    private static final float height = 20.0f;
    public static final int ID_WALL = 16;
	public static final String USER_DATA = "Wall";
    
    private Wall(Body body) {
        this.body = body;
    }
    
    /**
     * Returns the width of the wall.
     * @return width of the wall
     */
    public float getWidth() {
		return width;
	}
    
    /**
     * Returns the height of the wall
     * @return height of the wall
     */
    public float getHeight() {
		return height;
	}
    
    /**
     * Creates a wall.
     * @param world JBox2D world
     * @param x position of the wall
     * @param y position of the wall
     * @return  a new wall
     */
    public static Wall createAWall(World world, float x, float y) {
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width, height);
        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.position = new Vec2(x, y);
        Body myBody = world.createBody(bd);
        FixtureDef fd = new FixtureDef();
        fd.shape = poly;
        fd.friction = 1.0f;
        fd.filter.categoryBits = ID_WALL;
        fd.filter.maskBits = Cat.ID_CAT;
        myBody.createFixture(fd).setUserData(USER_DATA);
        Wall newWall = new Wall(myBody);
        myBody.setUserData(newWall);
        return newWall;
    }

    /**
     * Returns the horizontal position of the wall.
     * @return horizontal position of the wall
     */
	public float getPosX() {
		return body.getPosition().x;
	}

	/**
	 * Returns the vertical position of the wall.
	 * @return vertical position of the wall
	 */
	public float getPosY() {
		return body.getPosition().y;
	}
}
