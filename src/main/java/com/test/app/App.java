package com.test.app;


import java.util.List;
import java.util.Map;

import com.test.functions.DataProcessor;
import com.test.functions.Util;


/**
 * Question 1 main app
 * Loads String value into list of list map
 * Store list of list map value into String
 * Change inputStr variable to test other values
 * @author Jonathan Huang
 *
 */
public class App {	
	public static void main(String[] args) {
		String inputStr = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB;keyC=valueC\nkeyAD=valueAD;keyBD=valueBD;keyCD=valueCD\nkeyFin=finValue";
		
		DataProcessor funcs = new DataProcessor();
		Util util = new Util();
		List<List<Map<String, String>>> listOfListMap = funcs.load(inputStr);
		String outputStr = funcs.store(listOfListMap);
		
		System.out.println("Input string : ");
		System.out.println(inputStr);
		System.out.println("\nEscaped Input string : ");
		util.printEscapedString(inputStr);
		System.out.println();
		System.out.println("Converted to array : ");
		System.out.println(listOfListMap.toString());
		System.out.println();
		System.out.println("Array after stored to string : ");
		System.out.println(outputStr);
		System.out.println("\nEscaped Output string : ");
		util.printEscapedString(outputStr);
	}

}
