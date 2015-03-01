package com.stass.toyrobot;

/**
 * A command interface between the runner 
 * class and the Robot and Board classes
 */

public class CommandInterface implements ICommandInterface {

	/**
	 * Performs an action requested the runner
	 * @return true if successful, false otherwise
	 */
	public void performAction(IBoard board, String[] action) throws Exception {

		String command = action[0].trim();

		switch (command) {

			case "MOVE":

				// The robot is [assed to the move methodin order for future extensio
				// if there will be more than one robot on the board.
				if ( !move(board) ) {

					throw new Exception("Cannot move the robot. Either not on the board or is moving outside of the board edge...");
				}
				break;

			case "REPORT":

				if ( !report(board) ) {

					throw new Exception("Nothing to report - the robot has not been placed on the board.");
				}
				break;

			case "LEFT":

				if ( !turnLeft(board) ) {

					throw new Exception("Cannot turn left - the robot has not been placed on the board.");
				}
				break;

			case "RIGHT":
				if ( !turnRight(board) ) {

					throw new Exception("Cannot turn right - the robot has not been placed on the board.");
				}
				break;

			case "PLACE":

				try {

					// Unpack and check the command arguments
					int xPos = Integer.parseInt(action[1].trim());
					int yPos = Integer.parseInt(action[2].trim());
					String direction = action[3].trim();

					ICoordinates coordinates = new Coordinates(xPos, yPos);

					if ( !direction.equals("NORTH") && !direction.equals("EAST") &&
						!direction.equals("SOUTH") && !direction.equals("WEST") ) {

						throw new Exception("The direction " + direction + " is invalid.");
					}

					if( !place(board, coordinates, direction) ) {
						throw new Exception("The robot has npt been placed on the board. Please check your coordinates.");
					}

					break;
				} catch (Exception e) {
					throw e;
				}

			default:

				throw new Exception("Unrecognized command " + command + " ");
		}
	}


	/**
	 * Moves a robot on the board
	 * @return true if the move is successful
	 */
	public boolean move(IBoard board) {

		return board.moveRobot();
	}
	
	/**
	 * Print out the location of the robot on the board
	 */
	public boolean report(IBoard board) {

		IRobot r = board.getRobot();

		if ( r == null ) {

			// This means there is no robot on the board yet
			return false;
		}

		ICoordinates c = board.getCoordinates();

		if ( r == null ) {

			// This should never happen, as if there is a robot, there must be coordinates
			return false;
		}

		System.out.println("Output: " + c.getX() + ", " + c.getY() + ", " + r.getDirection());

		return true;
	}

	/**
	 * Turn the robot left
	 */
	public boolean turnLeft(IBoard board) {

		if (board.getRobot() == null ) {

			return false;
		} else {
			
			return board.getRobot().left();
		}
	}

	/**
	 * Turn the robot right
	 */
	public boolean turnRight(IBoard board) {

		if (board.getRobot() == null ) {

			return false;
		} else {

			return board.getRobot().right();
		}
	}

	/**
	 * Place the robot on the board at specified coordinates
	 * @return true is placed successfully, false otherwise
	 */
	public boolean place(IBoard board, ICoordinates coordinates, String direction) {
	
		return board.addRobot(coordinates, direction);
	}
}
