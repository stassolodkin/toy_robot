package com.stass.toyrobot;

/**
 * A simple counter class
 */

 public class Counter implements ICounter {

    int myCount;

    /**
     * Construct a counter whose value is zero.
     */
    public Counter() {
	
		myCount = 0;
		
    }

    /**
     * Construct a counter with given initial value.
     * @param init is the initial value of the counter
     */
    public Counter(int init) {
	
		myCount = init;
		
    }

    /**
     * Returns the value of the counter.
     * @return the value of the counter
     */
    public int getValue() {
	
		return myCount;
		
    }

    /**
     * Zeros the counter so getValue() == 0.
     */
    public void clear() {
		myCount = 0;
		
    }

    /**
     * Increase the value of the counter by one.
     */
    public void increment() {
	
		myCount++;
		
    }

    /**
     * Return a string representing the value of this counter.
     * @return a string representation of the value
     */
    public String toString() {
		return ""+myCount;
		
    }
}