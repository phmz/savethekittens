package elements.guns;

import java.awt.Color;

public class SimpleGun implements Gun {
	private final float x;
	private final float y;

	/**
	 * Creates a new simple gun.
	 * 
	 * @param x
	 *            horizontal position of the gun
	 * @param y
	 *            vertical position of the gun
	 */
	public SimpleGun(float x, float y) {
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
		return Color.MAGENTA;
	}

}
