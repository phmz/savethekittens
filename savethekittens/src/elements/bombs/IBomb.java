package elements.bombs;

import java.awt.Color;

public interface IBomb {
	/**
	 * Returns horizontal position of the bomb.
	 * @return position x of the bomb
	 */
	float getPosX();

	/**
	 * Returns vertical position of the bomb
	 * @return posittion y of the bomb
	 */
	float getPosY();

	/**
	 * Sets the position x of the bomb
	 * @param x
	 */
	void setX(int x);

	/**
	 * Sets the position y of the bomb
	 * @param y
	 */
	void setY(int y);

	/**
	 * Gets the color of the bomb
	 * @return color of the bomb
	 */
	Color getColor();
}
