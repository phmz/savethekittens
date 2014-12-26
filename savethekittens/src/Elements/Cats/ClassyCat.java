package Elements.Cats;

import org.jbox2d.dynamics.Fixture;

import Elements.Wall;

public class ClassyCat implements Cat {
	private final Body body;
    private boolean saved;

	public ClassyCat(Body body) {
        saved = false;
		this.body = body;
	}
	
    public static void createAClassyCat() {
        CircleShape circ = new CircleShape();
        BodyDef bod = new BodyDef();
        bod.type = BodyType.DYNAMIC;
        FixtureDef fd = new FixtureDef();
        fd.shape = circ;
        bod.position = new Vec2(0, HEIGHT/2);
        Body myBody = getWorld().createBody(bod);
        myBody.createFixture(fd);
        myBody.setSleepingAllowed(true);
        return new ClassyCat(body);
    }
    
	@Override
	public int getPosX() {
		return body.getPosition().x;
	}

	@Override
	public int getPosY() {
		return body.getPosition().y;
	}

	@Override
	public int getAccelaration() {
		return speed;
	}

	@Override
	public boolean isSafe() {
		return saved;
	}

	@Override
	public void edgeCollision() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addJointure(Wall... walls) {
		for(Wall wall:walls) {
			// TO DO
		}
	}

}
