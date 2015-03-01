package com.stass.toyrobot;

/**
 * This class is an implementation
 * of the io layer interface, and serves
 * as an io abstruction layer the DateDifferenceRunner class
 */

import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

public class REAIOLayer implements IOLayer {

	BufferedReader reader = null;

	/**
     * A constructor that creats a buffered reader.
	 * @param A reader object
     */
	public REAIOLayer(Reader reader) {

		try {
		
			this.reader = new BufferedReader(reader);
		
		} catch (Exception e){
			
			System.out.println(e.getMessage());
			e.printStackTrace();				
		}
	}
	
	/**
     * A method that reads a line from an input
	 * @param A Counter object
     * @return A String read
     */
	public String readLine(ICounter counter) {
	
		String line = null;
		
		try {
				
			line = reader.readLine();
			counter.increment();
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		while( line != null ) {
		
			if ( line.equals("end") ) {
			
				System.exit(0);
			
			}
			
			if ( line.trim().equals("") || line.charAt(0) == '#' ) {
			
				try {
				
					line = reader.readLine();
					counter.increment();
					
				} catch (IOException e) {
					
					System.out.println(e.getMessage());
					e.printStackTrace();
					
				}
			
			} else {
			
				return line;
			
			}
		
		}
		
		return line;
	}
}