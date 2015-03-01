package com.stass.toyrobot;

/**
 * A simple counter interface
 */

public interface ICounter {

	/**
     * Returns the value of the counter.
     * @return the value of the counter
     */
	int getValue();
	
	/**
     * Zeros the counter so getValue() == 0.
     */
    void clear();
    
	/**
     * Increase the value of the counter by one.
     */
    void increment();
    
	/**
     * Return a string representing the value of this counter.
     * @return a string representation of the value
     */
    String toString();


}