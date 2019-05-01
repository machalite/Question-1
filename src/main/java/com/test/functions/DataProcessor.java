package com.test.functions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor {
	
	public String store(List<List<Map<String, String>>> listOflistMap) {
		String output = "";
		for (List<Map<String, String>> listMap : listOflistMap) {
			for(Map<String, String> map : listMap) {
				for(Map.Entry<String, String> mapEntry : map.entrySet()) {
					output+= convertMapToText(mapEntry.getKey(), mapEntry.getValue());	
				}
			}
			output = removeLastSemiColon(output);
			output += addLiteralNewLine();
		}
		output = removeLastNewLine(output);
		return output;
	}
	
	public String convertMapToText(String key, String value) {
		return key + "=" + value + ";";
	}
	
	public String removeLastSemiColon(String str) {
		return str.substring(0, str.length() - 1);
	}
	
	public String removeLastNewLine(String str) {
		return str.substring(0, str.length() - 1);
	}
	
	public String addLiteralNewLine() {
		return "\n";
	}
	
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
