package com.test.app;


import java.util.Map;

import com.test.functions.Question1Functions;

public class Question1 {	
	public static void main(String[] args) {
		String inputStr = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB;keyC=valueC\nkeyAD=valueAD;keyBD=valueBD;keyCD=valueCD\nkeyFin=finValue";
		
		Question1Functions funcs = new Question1Functions();
		Map<Integer, Map<String, String>> arrOutput = funcs.load(inputStr);
		String outputStr = funcs.store(arrOutput);
		
		System.out.println("Input string : ");
		funcs.printEscapedString(inputStr);
		System.out.println();
		System.out.println("Converted to array : ");
		System.out.println(arrOutput.toString());
		System.out.println();
		System.out.println("Array after stored to string : ");
		funcs.printEscapedString(outputStr);
	}

}
