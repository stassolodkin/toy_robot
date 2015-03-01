package com.stass.toyrobot;

/**
 * A very simple Board interface
 */

public class Board implements IBoard {

	// Width of the board
	int width;

	// Height of the board
	int height;

	// The robot placed on the board
	IRobot robot;

	// The coordinates for the robot
	ICoordinates coordinates;

	// A default constructor to initialise the board to the size of 5x5
	public Board() {

		width = 5;
		height = 5;
	}

	// A constructor to initialise the board to an arbitrary size
	public Board(int w, int h) {
	
		width = w;
		height = h;
	}

	/**
	 * Returns the width of the board.
	 */
	public int getWidth() {

		return width;
	}

	/**
	 * Returns the height of the board.
	 */
	public int getHeight() {
	
		return height;
	}

	/**
	 * Adds a robot to the board.
	 */
	public boolean addRobot(ICoordinates coordinates, String direction) {

		if ( coordinates.getX() < 0 || coordinates.getX() >= width ) {

			return false;
		} else if ( coordinates.getY() < 0 || coordinates.getY() >= height ) {

			return false;
		} else {

			robot = new Robot();
			robot.setDirection(direction);
			this.coordinates = coordinates;

			return true;
		}
	}

	/**
	 * Returns a the robot.
	 */
	public Robot getRobot() {
		return (Robot)robot;
	}

	/**
	 * Returns a the coordinates.
	 */
	public Coordinates getCoordinates() {
		return (Coordinates)coordinates;
	}

	/**
	 * Move the robot one step forward
	 */
	public boolean moveRobot() {

		if( coordinates == null ) {

			// There is no robot on the board
			return false;
		}

		String direction = robot.getDirection();

		switch ( direction ) {

			case "NORTH":
				int yu = coordinates.getY();

				if ( yu < (height - 1) ) {

					coordinates.setY(++yu);
					break;
				} else {

					return false;
				}

			case "EAST":
				int xu = coordinates.getX();

				if ( xu < (width - 1) ) {

					coordinates.setX(++xu);
					break;
				} else {

					return false;
				}

			case "SOUTH":
				int y = coordinates.getY();

				if ( y > 0 ) {

					coordinates.setY(--y);
					break;
				} else {

					return false;
				}
				
			case "WEST":
				int x = coordinates.getX();

				if ( x > 0 ) {
					coordinates.setX(--x);
					break;

				} else {

					return false;
				}

			default:

				return false;
		}

		return true;
	}
}
