package com.stass.toyrobot;

/**
 * An interface to represent coordinates on the plane 
 */
public interface ICoordinates {

	/**
     * Return the value of X
     */
	int getX();
	
	/**
     * Return the value of Y
     */
	int getY();
	
	/**
     * Set the value of X
     */
	void setX(int x);
	
	/**
     * Sets the value of Y
     */
	void setY(int y);
	
}