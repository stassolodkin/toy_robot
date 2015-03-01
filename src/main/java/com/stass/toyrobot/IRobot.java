package com.stass.toyrobot;

/**
 * A simple Robot interface
 */

public interface IRobot {

	/**
	 * Returns the direction the robot is facing.
	 */
	String getDirection();

	/**
	 * Sets the direction the robot is facing.
	 */
	void setDirection(String d);

	/**
	  * Turn the robot left
	  */
	boolean left();

	/**
	  * Turn the robot right
	  */
	boolean right();
}
