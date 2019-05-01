package com.test.functions;


import java.util.HashMap;
import java.util.Map;

public class Question1Functions {
	
	public String store(Map<Integer, Map<String, String>> inputArr) {
		String output = "";
		for (Map.Entry<Integer, Map<String, String>> index1 : inputArr.entrySet()) {
			for(Map.Entry<String, String> index2 : index1.getValue().entrySet()) {
				output+= convertArrayValueToText(index2.getKey(), index2.getValue());
			}
			output = removeLastSemiColon(output);
			output += addLiteralNewLine();
		}
		output = removeLastNewLine(output);
		return output;
	}
	
	public String convertArrayValueToText(String key, String value) {
		return key + "=" + value + ";";
	}
	
	public String removeLastSemiColon(String str) {
		return str.substring(0, str.length() - 1);
	}
	
	public String removeLastNewLine(String str) {
		return str.substring(0, str.length() - 2);
	}
	
	public String addLiteralNewLine() {
		return "\\" + "n";
	}
	
	public Map<Integer, Map<String, String>> load(String inputStr) {
		Map<Integer, Map<String, String>> index1Map = new HashMap<Integer, Map<String, String>>();
		
		String[] index1 = inputStr.split("\n");
		Integer count = 0;
		for(String str1 : index1) {
			String[] index2 = str1.split(";");
			Map<String, String> index2Map = new HashMap<String, String>();
			for(String str2 : index2) {
				String[] index3 = str2.split("=");
				index2Map.put(index3[0], index3[1]);
			}
			index1Map.put(count, index2Map);
			count++;
		}
		return index1Map;
	}
	
	public void printEscapedString(String str) {
		System.out.println(str.replace("\n","\\n"));
	}
	
	public String escapeString(String str) {
		return str.replace("\n","\\n");
	}
}
