package elements.guns;

import java.awt.Color;

public class BurstGun implements Gun {
	private final float x;
	private final float y;

	public BurstGun(float x, float y) {
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
		return Color.ORANGE;
	}

}
