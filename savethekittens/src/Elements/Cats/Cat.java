package Elements.Cats;

import java.awt.Color;

import Elements.Wall;

public interface Cat {
	/**
	 * Returns the horizontal position of the cat.
	 * 
	 * @return coordonate x
	 */
	int getPosX();

	/**
	 * Returns the vertical position of the cat.
	 * 
	 * @return coordonate y
	 */
	int getPosY();

	/**
	 * Returns true if the cat is in a net.
	 * 
	 * @return true if the cat is in a net, false otherwise
	 */
	boolean isSafe();

	/**
	 * Tests if the cat enter in collision with an edge
	 */
	void edgeCollision();

	/**
	 * Adds a jointure between walls and the cat
	 * @param walls list of the walls
	 */
	void addJointure(Wall...walls);

	Color getColor();
}
