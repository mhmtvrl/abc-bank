package com.abc;

import static java.lang.Math.abs;

public class Util {
	
	public static String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
	
	//Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    public static String format(int number, String word) {
    	if(word == null)
    		throw new NullPointerException("word is null");
    	if(number <= 0)
    		throw new IllegalArgumentException("number is smaller than zero");
        return number + " " + (number == 1 ? word : word + "s");
    }
	
}
