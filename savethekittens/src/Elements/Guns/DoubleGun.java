package Elements.Guns;

import java.awt.Color;

public class DoubleGun implements Gun {

	@Override
	public float getX() {
		return 0;
	}

	@Override
	public float getY() {
		return 400;
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}

}
