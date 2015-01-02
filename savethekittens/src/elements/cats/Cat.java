package elements.cats;

import java.awt.Color;

import org.jbox2d.common.Vec2;

import elements.Net;
import elements.bombs.Bomb;

public interface Cat {
	public static final int ID_CAT = 2;
	
	/**
	 * Returns the horizontal position of the cat.
	 * @return coordonate x
	 */
	float getPosX();

	/**
	 * Returns the vertical position of the cat.
	 * @return coordonate y
	 */
	float getPosY();

	/**
	 * Returns true if the cat is in a net.
	 * @return true if the cat is in a net, false otherwise
	 */
	boolean isSafe();

	/**
	 * Returns the color of the cat.
	 * @return Color of the cat.
	 */
	Color getColor();

	/**
	 * Returns true if the cat is dead.
	 * @return true if the cat is dead, false otherwise
	 */
	boolean isDead();
	
	/**
	 * Moves the cat.
	 * @param v vector of the linear velocity
	 */
	void move(Vec2 v);

	void contactWithWall();

	void contactWithNet(Net net);

	void contactWithBomb(Bomb bomb);
}
