package elements.guns;

import java.awt.Color;

public interface Gun {
	/**
	 * Returns the horizontal position of the cat.
	 * @return horizontal position of the cat
	 */
	float getX();
	
	/**
	 * Returns the vertical position of the cat.
	 * @return vertical position of the cat
	 */
	float getY();
	
	/**
	 * Returns the color of the gun.
	 * @return color of the gun
	 */
	Color getColor();
}
