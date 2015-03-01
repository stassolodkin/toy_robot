package com.stass.toyrobot;

/**
 * A simple Board interface
 */

public interface IBoard {

	/**
     * Returns the width of the board.
     */
	int getWidth();
	
	/**
     * Returns the height of the board.
     */
    int getHeight();
	
	/**
     * Adds a robot to the board.
     */
    boolean addRobot(ICoordinates c, String direction);
	
	/**
     * Returns a the robot.
     */
    Robot getRobot();
	
	/**
     * Returns a the coordinates.
     */
	Coordinates getCoordinates();
	
	/**
     * Move the robot one step formward
     */
	boolean moveRobot();
    
}
