package Elements;

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
}
