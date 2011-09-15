package com.tieto.examples.syntax;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Binary integral literals and underscores in numeric literals
 * 
 * @author pfeffvla (Pfeffer Vladimír)
 *
 */
public class SytaxChangesWithMain {
	
	public static void main(String[] args) {
		// Literals
		literalsDemo();
		System.out.println("===============================================");
		
		// String in switch
		final String stringsInSwitch = stringsInSwitch(Locale.getDefault().getCountry());
		System.out.println(stringsInSwitch);
		System.out.println("===============================================");
		System.out.println();

		// Diamond syntax
		diamondSyntax();
		
	}
	
	public static void diamondSyntax() {
		// Instead of writing this:  -- uaaaa crazy old style... 
		final Map<String, Collection<Integer>> oldMap = new LinkedHashMap<String, Collection<Integer>>();
			
		// This feature is a really simple syntax improvement for generics. 
		// With that feature, you can avoid to write twice the generics type in a generics declaration.
		final Map<String, Collection<Integer>> newMap = new LinkedHashMap<>();
						
		// We can try to create simple example with ArrayList .... 
	}
	
	/**
	 * You can declare integers using binary values
	 * You can use _ (underscores) in the declaration
	 * That’s allow to make more verbose code. 
	 * 
	 */
	public static void literalsDemo() {
		// binary integral literals
		int binary = 0b11001001001;
		System.out.println("===============================================");
		System.out.println("Binary number: 0b" + Integer.toBinaryString(binary) + "=" + binary);				
		// hex
		int hex = 0x32;
		System.out.println("Hex number: 0x" + Integer.toHexString(hex) + "=" + hex);		
		// oct
		int oct = 036;
		System.out.println("Oct number: 0" + Integer.toOctalString(oct) + "=" + oct);		
		System.out.println("===============================================");
		
		// Underscores in numeric literals
		int oldMilion = 1000000;
		int newMilion = 1_000_000;
		System.out.println("Large number: " + newMilion);
		
		int color = 0xdd_dd_dd;
		System.out.println("Color: " + color);
		
		double amount = 1_999_888_777.25;
		System.out.println("Amount: " + amount);
	}
		 
	/**
	 * A really good feature: Switch with Strings values. You can now do that kind of switch
	 * @param language country code according ISO3166
	 */
	public static String stringsInSwitch(final String language) {
		String value = "";		 
		switch (language) {
		  case "FR":
		    value = "Bonjour";
		    break;
		  case "US":
		    value = "Hi";
		    break;
		  case "DE":
		    value = "Guten tag";
		    break;
		  case "CZ":
			value = "Dobrý den";
			break;
		  case "FI":
				value = "Hyvaa huomenta";
				break;
		  default:
		    value = "Hello";
		    break;		  
		}
		return value;
	}
	
	
}
