package com.stass.toyrobot;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;

public class ToyRobotRunner {

	public static void main(String[] args) throws IOException {

		System.out.println("Starting the ToyRobotTest...");

		String usage =	"Usage:" +
						"\njava -jar ToyRobot.jar [filename]" +
						"\nThe optional parameter filename indicates that" +
						"\nthe commands must be read from a file to which the argumen points.";

		// Declare an instance of the io layer
		IOLayer reaInReader = null;

		// Declare an instance of the ToyRobotRunnerUtilities class
		ToyRobotRunnerUtilities tru = null;

		// Declare am instance of a Counter class
		ICounter counter;

		// Declare the board and the command interface
		IBoard board;
		ICommandInterface ci;

		if ( args.length == 0 ) {
			// Create an instance of Reader that would read from the command line
			reaInReader = new REAIOLayer(new InputStreamReader(System.in));

		} else if ( args.length == 1 ) {
			// Create an instance of Reader that would read from the given file
			reaInReader = new REAIOLayer(new FileReader(args[0]));

		} else {
			// No other usage is supported at the moment
			System.out.println("Command line error: Please see the usage below:\n" + usage);
			System.exit(0);
		}

		// Initialise the an instance of the ToyRobotRunnerUtilities
		tru = new ToyRobotRunnerUtilities();

		// Initialise the Board and CommandInterface;
		board = new Board(5, 5);
		ci = new CommandInterface();

		// A string to contain the line
		String line;
		counter = new Counter();

		// Read the first line
		line = reaInReader.readLine(counter);

		// Process each line one by one
		while( line != null ) {
		
			try {

				String[] command = tru.validateLine(line, counter);
				// System.out.println("My command: " + command[0]);
				ci.performAction(board, command);
			} catch (Exception ex) {

				System.out.println(ex.getMessage() + " skipping to the next line...");

				// Read the next line
				line = reaInReader.readLine(counter);
				continue;
			}

			// Read the next line
			line = reaInReader.readLine(counter);
		}
	}
}
