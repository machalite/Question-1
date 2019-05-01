package com.test.testCase;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test.app.Question1;
import com.test.functions.Question1Functions;

public class Question1Test {
	
	private Map<Integer, Map<String, String>> inputArr;
	
	private String inputStr = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB;keyC=valueC\nkeyAD=valueAD;keyBD=valueBD;keyCD=valueCD\nkeyFin=finValue";
	
	private Question1Functions funcs = new Question1Functions();
	
	public Map<Integer, Map<String, String>> createInputArr(){
		Map<Integer, Map<String, String>> array = new HashMap<Integer, Map<String, String>>();
		Map<String, String> innerArr0 = new HashMap<String, String>();
		Map<String, String> innerArr1 = new HashMap<String, String>();
		Map<String, String> innerArr2 = new HashMap<String, String>();
		Map<String, String> innerArr3 = new HashMap<String, String>();

		array.put(0, createInnerArray(innerArr0, "key1", "value1"));
		array.put(0, createInnerArray(innerArr0, "key2", "value2"));
		
		array.put(1, createInnerArray(innerArr1, "keyA", "valueA"));
		array.put(1, createInnerArray(innerArr1, "keyB", "valueB"));
		array.put(1, createInnerArray(innerArr1, "keyC", "valueC"));
		
		array.put(2, createInnerArray(innerArr2, "keyAD", "valueAD"));
		array.put(2, createInnerArray(innerArr2, "keyBD", "valueBD"));
		array.put(2, createInnerArray(innerArr2, "keyCD", "valueCD"));
		
		array.put(3, createInnerArray(innerArr3, "keyFin", "finValue"));
		return array;
	}
	
	public Map<String, String> createInnerArray(Map<String, String> array, String key, String value){
		array.put(key, value);
		return array;
	}
	
	@Test
    public void storeTest() {
		inputArr = createInputArr();
		String outputStr = funcs.store(inputArr);
		funcs.printEscapedString(inputStr);
		funcs.printEscapedString(outputStr);
		assertEquals(funcs.escapeString(inputStr), funcs.escapeString(outputStr));
    }
	
	@Test
    public void loadTest() {
		inputArr = createInputArr();
		Map<Integer, Map<String, String>> outputArr = funcs.load(inputStr);
		assertEquals(inputArr, outputArr);
    }
	
}
