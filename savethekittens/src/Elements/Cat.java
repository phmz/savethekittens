package Elements;

public interface Cat {
	/**
	 * Returns the horizontal position of the cat.
	 * @return coordonate x
	 */
	int getPosX();
	
	/**
	 * Returns the vertical position of the cat.
	 * @return coordonate y
	 */
	int getPosY();
	
	/**
	 * Returns the acceleration vector of the cat.
	 * @return the acceleration
	 */
	int getAccelaration();
	
	/**
	 * Returns true if the cat is  in a net.
	 * @return true if the cat is in a net, false otherwise
	 */
	boolean isSafe();
	
	/**
	 * Tests if the cat enter in collision with an edge
	 */
	void edgeCollision();

}
