package com.stass.toyrobot;

/**
 * A simple Robot class
 */

public class Robot implements IRobot {

	// The direction of the robot
	private String direction;

	// A default constructor
	public void Robot() {
		direction = null;
	}

	/**
	 * Returns the direction the robot is facing.
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * Sets the direction the robot is facing.
	 */
	public void setDirection(String d) {
		direction = d;
	}

	/**
	  * Turn the robot left
	  */
	public boolean left() {

		if ( direction == null ) {
			// The robot has not been placed on the board yet
			return false;	
		}

		switch ( direction ) {

			case "NORTH":
				direction = "WEST";
				break;

			case "WEST":
				direction = "SOUTH";
				break;

			case "SOUTH":
				direction = "EAST";
				break;

			default:
				direction = "NORTH";
				break;
		}

		return true;
	}

	/**
	  * Turn the robot right
	  */
	public boolean right() {

		if ( direction == null ) {
			// The robot has not been placed on the board yet
			return false;
		}

		switch ( direction ) {
			case "NORTH":
				direction = "EAST";
				break;
			case "EAST":
				direction = "SOUTH";
				break;
			case "SOUTH":
				direction = "WEST";
				break;
			default:
				direction = "NORTH";
				break;
		}

		return true;
	}
}
