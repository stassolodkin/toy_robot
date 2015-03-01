package com.stass.toyrobot;

/**
 * A class that holds support methods
 * for the main runner class ToyRobotRunner.
 */
 
import java.util.Map;
import java.util.HashMap;
 
public class ToyRobotRunnerUtilities {

	// This map will hold command names mapped to the number of parameters to this command
	private Map<String, String> commands;

	// Constructor to initialise commands
	public ToyRobotRunnerUtilities() {

		commands = new HashMap<String, String>();
		commands.put("MOVE", "0");
		commands.put("REPORT", "0");
		commands.put("RIGHT", "0");
		commands.put("LEFT", "0");
		commands.put("PLACE", "3");
	}

	private boolean isCommand(String command) {
		return ( commands.get(command) != null );
	}

	/**
     * Return a dates read from a line in a string array
     *
	 * @param line to be validated, counter
     * @return a string array representation of the command
     */
	public String[] validateLine(String line, ICounter counter) throws Exception {

		String[] command = line.trim().split(",");

		// CHeck tha the command exists and is valid
		if ( command.length == 0 || !isCommand(command[0]) ) {
			throwException(line, counter);
		} 

		// Check that the number of arguments is correct
		if( (command.length - 1) != Integer.parseInt((String)commands.get(command[0])) ) {
			throwException(line, counter);
		} 

		return command;
	}

	private void throwException(String line, ICounter counter) throws Exception {
		throw new Exception("Wrong line format at line " + counter.getValue() + ": \"" + line + "\".");
	}
}
