package com.stass.toyrobot;

/**
 * A command interface between the runner 
 * class and the Robot and Board classes
 */

public interface ICommandInterface {

	/**
     * Performs an action requested the runner
     * @return true if successful, false otherwise
     */
	void performAction(IBoard board, String[] action)  throws Exception;

	/**
     * Moves a robot on the board
     * @return true if the move is successful
     */
	boolean move(IBoard board);

	/**
     * Print out the location of the robot on the board
     */
    boolean report(IBoard board);

	/**
     * Turn the robot left
     */
    boolean turnLeft(IBoard board);

	/**
    * Turn the robot right
    */
    boolean turnRight(IBoard board);

	/**
     * Place the robot on the board at specified coordinates
     * @return true is placed successfully, false otherwise
     */
    boolean place(IBoard board, ICoordinates coordinates, String direction);

}