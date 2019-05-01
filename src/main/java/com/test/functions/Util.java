package com.test.functions;


/**
 * Additional class which contains string functions 
 * @author Jonathan Huang
 *
 */
public class Util {
	
	/**
	 * Prints escaped input string so newlines will shown as '\n' 
	 * @param str
	 */
	public void printEscapedString(String str) {
		System.out.println(str.replace("\n","\\n"));
	}
}
