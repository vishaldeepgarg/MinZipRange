package com.vishalgarg;

/* 
 * Class for storing the ZipRange object with each object having a lower and upper value
 * 
 */

public class ZipRange {
	private int lower;
	private int upper;
	
	//Constructors
	ZipRange(int lower, int upper){
		if(lower <= upper) {
			this.lower = lower;
			this.upper = upper;
		} else {
			this.lower = upper;
			this.upper = lower;	
		}
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	public String toString() {
		return String.format("['%d','%d']", lower, upper );
	}
	

}
