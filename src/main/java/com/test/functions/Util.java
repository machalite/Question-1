package com.test.functions;

public class Util {
	public void printEscapedString(String str) {
		System.out.println(str.replace("\n","\\n"));
	}
	
	public String escapeString(String str) {
		return str.replace("\n","\\n");
	}
}
