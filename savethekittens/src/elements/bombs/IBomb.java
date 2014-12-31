package elements.bombs;

public interface IBomb {
	/**
	 * 
	 * @return coordonate x of the bomb
	 */
	int getPosX();

	/**
	 * 
	 * @return coordonate y of the bomb
	 */
	int getPosY();

	/***
	 * 
	 * @return the time left before the bomb explodes
	 */
	int getTime();

	void setX(int x);

	void setY(int y);
}
