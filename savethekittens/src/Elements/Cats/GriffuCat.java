package Elements.Cats;

import Elements.Cat;

public class GriffuCat implements Cat {
	private int posX;
	private int posY;
	private int speed;
	
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
}
