package com.tieto.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.tieto.examples.multicatch.exception.Exception1;
import com.tieto.examples.multicatch.exception.Exception2;

/**
 * jUnit tests for Syntax changes
 * 
 * @author Vladimir Pfeffer
 *
 */
public class SynatxChanges {
	private static String LANGUAGE_CZECH_NAME = "cestina";
	private static String LANGUAGE_ENGLISH_NAME = "anlictina";
	private static String LANGUAGE_UNKNOWN_NAME = "unknown";
	
	@Test
	public void underscoresInNumbers() {
		Assert.assertEquals(1000000, 1_000_000);
		Assert.assertEquals(2015210.15, 2_015_210.15);
		Assert.assertEquals(0b1101001110, 0b11_0100_1110);
		Assert.assertEquals(0xFFFFFF, 0xFF_FF_FF);		
	}
	
	@Test
	public void binaryLiterals() {		
		int newBinary = 0b1001_1001; // Yes, it works... :-)
		Assert.assertEquals(153, newBinary);
		Assert.assertEquals(128 ^ 0 ^ 0 ^ 16 ^ 8 ^ 0 ^ 0 ^ 1, newBinary);
	}
	
	@Test
	public void stringsInSwitch() {
		Assert.assertEquals(LANGUAGE_CZECH_NAME, getLanguageName("CZ"));
		Assert.assertEquals(LANGUAGE_ENGLISH_NAME, getLanguageName("EN"));
		Assert.assertEquals(LANGUAGE_UNKNOWN_NAME, getLanguageName("BG"));
	}	
	
		
	@Test (expected=Exception1.class)	
	public void multiCatch() throws Exception1, Exception2 {
		boolean ex1 = true;
		try {
			if (ex1) { 
				throw new Exception1();
			}
			throw new Exception2();
		} catch (Exception1 | Exception2 ex) {
			throw ex;
		}
	}
	
	@Test (expected=Exception1.class)	
	public void morePreciseReThrow() throws Exception1, Exception2 {
		boolean ex1 = true;
		try {
			if (ex1) { 
				throw new Exception1();
			}
			throw new Exception2();
		} catch (Throwable ex) {
			throw ex; // Exception1 or Exception2
		}
	}
	
	
	@Test
	public void diamondOperator() {
		Map<String, List<String>> oldAnagrams = new HashMap<String, List<String>>();
		Map<String, List<String>> newAnagrams = new HashMap<>();		
		Assert.assertEquals(newAnagrams, oldAnagrams);
		
		// Here is a situation, where we are not able to use diamond syntax -> Please uncomment line below... 
		// List<List<String>> ll = Collections.singletonList(new java.util.ArrayList<>());;
	}
	
	/**
	 * Method return whole language name according abbreviation
	 * @param abb - abbreviation
	 * @return language name
	 */
	public String getLanguageName(final String abb) {		
		String result;
		switch (abb) {
			case "CZ": 
					result = LANGUAGE_CZECH_NAME;
					break;
			case "EN": 
					result = LANGUAGE_ENGLISH_NAME;
					break;
			default:
					result = LANGUAGE_UNKNOWN_NAME;
					break;
		
		}
		return result;
	}

}
