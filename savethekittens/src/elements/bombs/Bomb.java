package elements.bombs;

import java.awt.Color;

public class Bomb implements IBomb {
	public static final String USER_DATA = "Bomb";
	public static final int ID_BOMB = 32;
	private float width;
	private float height;

	/**
	 * Creates a new bomb
	 * @param pos position of the bomb
	 */
	public Bomb(float pos) {
		width = 400f+pos;
		height = 490f;
	}
	
	@Override
	public float getPosX() {
		return width;
	}

	@Override
	public float getPosY() {
		return height;
	}

	@Override
	public void setX(int x) {
		width = x;
	}

	@Override
	public void setY(int y) {
		height = y;	
	}
	
	@Override
	public Color getColor() {
		return Color.BLACK;
	}

}
