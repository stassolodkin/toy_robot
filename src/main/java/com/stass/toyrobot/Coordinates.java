package com.stass.toyrobot;

/**
 * An class to represent coordinates on the plane 
 */
public class Coordinates implements ICoordinates {

	// The X value
	int coordinateX;
	
	// The Y value
	int coordinateY;

	// A default constructor. Sets the coordinates to 0,0 
	public Coordinates() {
	
		coordinateX = 0;
		coordinateY = 0;
	}
	
	// A constructor. Sets the coordinates explicitely 
	public Coordinates(int x, int y) {
	
		coordinateX = x;
		coordinateY = y;
	
	}
	
	
	/**
     * Return the value of X
     */
	public int getX() {
	
		return coordinateX;
		
	}
	
	/**
     * Return the value of Y
     */
	public int getY() {
	
		return coordinateY;
	
	}
	
	/**
     * Set the value of X
     */
	public void setX(int x) {
	
		coordinateX = x;
	
	}
	
	/**
     * Sets the value of Y
     */
	public void setY(int y) {
	
		coordinateY = y;
	
	}
	
}