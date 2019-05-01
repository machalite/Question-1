package com.test.functions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Processor class contains store and load functions
 * @author Jonathan Huang
 *
 */
public class DataProcessor {
	/**
	 * Convert list of list map values into String
	 * @param listOflistMap 
	 * @return string output
	 */
	public String store(List<List<Map<String, String>>> listOflistMap) {
		String output = "";
		for (List<Map<String, String>> listMap : listOflistMap) {
			for(Map<String, String> map : listMap) {
				for(Map.Entry<String, String> mapEntry : map.entrySet()) {
					output+= convertMapToText(mapEntry.getKey(), mapEntry.getValue());	
				}
			}
			output = removeLastSemicolon(output);
			output += addLiteralNewLine();
		}
		output = removeLastNewLine(output);
		return output;
	}
	
	/**
	 * Concatenate map key and map value into desired format
	 * @param key
	 * @param value
	 * @return string of map 
	 */
	public String convertMapToText(String key, String value) {
		return key + "=" + value + ";";
	}
	
	/**
	 * Used to remove excess semicolon in list map iterations
	 * @param str string input
	 * @return string input minus last semicolon
	 */
	public String removeLastSemicolon(String str) {
		return str.substring(0, str.length() - 1);
	}
	
	/**
	 * Used to remove excess newline when list of list map iteration ends
	 * @param str string input
	 * @return string input minus last newline
	 */
	public String removeLastNewLine(String str) {
		return str.substring(0, str.length() - 1);
	}
	
	public String addLiteralNewLine() {
		return "\n";
	}
	
	/**
	 * Load string value into list of list map
	 * @param inputStr
	 * @return output list of list map
	 */
	public List<List<Map<String, String>>> load(String inputStr) {
		List<List<Map<String, String>>> listOflistMap = new ArrayList<List<Map<String,String>>>();
		
		String[] arrNewLine = inputStr.split("\n");
		for(String str1 : arrNewLine) {
			List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
			String[] arrSemicolon = str1.split(";");
			for(String str2 : arrSemicolon) {
				Map<String, String> map = new HashMap<String, String>();
				String[] arrEqual = str2.split("=");
				map.put(arrEqual[0], arrEqual[1]);
				listMap.add(map);
			}
			listOflistMap.add(listMap);
		}
		return listOflistMap;
	}
}
