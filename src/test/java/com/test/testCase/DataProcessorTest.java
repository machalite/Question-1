package com.test.testCase;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.test.functions.DataProcessor;
import com.test.functions.Util;

public class DataProcessorTest {
	
	private List<List<Map<String, String>>> inputListOfListMap;
	
	private String inputStr = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB;keyC=valueC\nkeyAD=valueAD;keyBD=valueBD;keyCD=valueCD\nkeyFin=finValue";
	
	private DataProcessor funcs = new DataProcessor();
	
	private Util util = new Util();
	
	public List<List<Map<String, String>>> createListOfListMap(){
		List<List<Map<String, String>>> listOfListMap = new ArrayList<List<Map<String,String>>>();
		List<Map<String, String>> listMap0 = new ArrayList<Map<String,String>>();
		List<Map<String, String>> listMap1 = new ArrayList<Map<String,String>>();
		List<Map<String, String>> listMap2 = new ArrayList<Map<String,String>>();
		List<Map<String, String>> listMap3 = new ArrayList<Map<String,String>>();
		
		listMap0.add(createMapValue("key1", "value1"));
		listMap0.add(createMapValue("key2", "value2"));
		
		listMap1.add(createMapValue("keyA", "valueA"));
		listMap1.add(createMapValue("keyB", "valueB"));
		listMap1.add(createMapValue("keyC", "valueC"));
		
		listMap2.add(createMapValue("keyAD", "valueAD"));
		listMap2.add(createMapValue("keyBD", "valueBD"));
		listMap2.add(createMapValue("keyCD", "valueCD"));
		
		listMap3.add(createMapValue("keyFin", "finValue"));
		
		listOfListMap.add(listMap0);
		listOfListMap.add(listMap1);
		listOfListMap.add(listMap2);
		listOfListMap.add(listMap3);
		return listOfListMap;
	}
	
	public Map<String, String> createMapValue(String key, String value){
		Map<String, String> map = new HashMap<String, String>();
		map.put(key, value);
		return map;
	}
	
	@Test
    public void testStore() {
		inputListOfListMap = createListOfListMap();
		String outputStr = funcs.store(inputListOfListMap);
		util.printEscapedString(inputStr);
		util.printEscapedString(outputStr);
		assertEquals(inputStr, outputStr);
    }
	
	@Test
    public void testLoad() {
		inputListOfListMap = createListOfListMap();
		List<List<Map<String, String>>> outputListOfListMap = funcs.load(inputStr);
		System.out.println(inputListOfListMap.toString());
		System.out.println(outputListOfListMap.toString());
		assertEquals(inputListOfListMap, outputListOfListMap);
    }
	
}
