package Elements.Cats;

import java.awt.Color;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Elements.Wall;

public class GymCat implements Cat {
	private final Body body;
    private boolean saved;
    
	public GymCat(Body body) {
        saved = false;
        this.body = body;
	}
    
    public static GymCat createAGymCat(World world) {
        CircleShape circ = new CircleShape();
        BodyDef bod = new BodyDef();
        bod.type = BodyType.DYNAMIC;
        FixtureDef fd = new FixtureDef();
        fd.shape = circ;
        bod.position = new Vec2(100f, 100f);
        Body myBody = world.createBody(bod);
        myBody.createFixture(fd);
        myBody.setSleepingAllowed(true);
        return new GymCat(myBody);
    }
	
	@Override
	public int getPosX() {
		return (int) body.getPosition().x;
	}

	@Override
	public int getPosY() {
		return (int) body.getPosition().y;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		return Color.PINK;
	}

}
