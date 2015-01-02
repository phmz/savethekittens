package elements.bombs;

import java.awt.Color;

public interface IBomb {
	/**
	 * 
	 * @return coordonate x of the bomb
	 */
	float getPosX();

	/**
	 * 
	 * @return coordonate y of the bomb
	 */
	float getPosY();

	/***
	 * 
	 * @return the time left before the bomb explodes
	 */
	int getTime();

	void setX(int x);

	void setY(int y);

	Color getColor();
}
