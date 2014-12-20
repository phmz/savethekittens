package Elements.Cats;

import org.jbox2d.dynamics.Fixture;

import Elements.Wall;


public class ClawedCat implements Cat {
	private int posX;
	private int posY;
	private int speed;
	private final Fixture fixture;

	public ClawedCat() {
		posX = -1;
		posY = -1;
		fixture = new Fixture();
	}
	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

	@Override
	public int getAccelaration() {
		return speed;
	}

	@Override
	public boolean isSafe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void edgeCollision() {
		// TODO Auto-generated method stub

	}
	@Override
	public void addJointure(Wall... walls) {
		// TODO Auto-generated method stub
		
	}
}
