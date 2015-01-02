package elements.bombs;

import java.awt.Color;

public class Vortex implements IBomb {
	private float width;
	private float height;

	/**
	 * Creates a new vortex
	 * 
	 * @param pos
	 *            position of the vortex
	 */
	public Vortex(float pos) {
		width = 400f + pos;
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
		return new Color(183, 52, 216);
	}

}
