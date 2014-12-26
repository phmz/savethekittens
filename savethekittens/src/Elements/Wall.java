package Elements;

public class Wall {
    private final Body body;
    
    public Wall(Body body) {
        this.body = body;
    }
    
    public static createAWall(float x, float y) {
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
		return body.getPosition().x;
	}

	public int getPosY() {
		return body.getPosition().y;
	}
}
