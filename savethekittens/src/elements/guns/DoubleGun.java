package elements.guns;

import java.awt.Color;

public class DoubleGun implements Gun {
	private final float x;
	private final float y;

	/**
	 * Creates a new double gun.
	 * 
	 * @param x
	 *            horizontal position of the gun
	 * @param y
	 *            vertical position of the gun
	 */
	public DoubleGun(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}

}
