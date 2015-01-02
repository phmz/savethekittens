package elements.bombs;

import java.awt.Color;

public interface IBomb {
	public static final String USER_DATA = "Bomb";
	public static final int ID_BOMB = 32;

	/**
	 * Returns horizontal position of the bomb.
	 * 
	 * @return position x of the bomb
	 */
	float getPosX();

	/**
	 * Returns vertical position of the bomb
	 * 
	 * @return position y of the bomb
	 */
	float getPosY();

	/**
	 * Sets the position x of the bomb
	 * 
	 * @param x
	 */
	void setX(int x);

	/**
	 * Sets the position y of the bomb
	 * 
	 * @param y
	 */
	void setY(int y);

	/**
	 * Gets the color of the bomb
	 * 
	 * @return color of the bomb
	 */
	Color getColor();
}
