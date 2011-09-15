package com.tieto.examples.multicatch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tieto.examples.multicatch.exception.Exception1;
import com.tieto.examples.multicatch.exception.Exception2;


/**
 * Multi-Catch
 * 
 * finally, we can treat several Exception types in one catch block
 * 
 * @author pfeffvla (Pfeffer Vladimír)
 *
 */
public class Exceptions {
	
	/**
	 * Main method 
	 * @param args parameters from command line
	 
	 */
	public static void main(final String[] args) {
		multiCatch();
		try {
			safeReThrowJava7(true);
		} catch (Exception1 e) {
			System.out.println(e.getMessage());
		} catch (Exception2 e) {
			System.err.println(e.getMessage());
		}
	}
	

	public static void multiCatch() {
		try {
			final Class<?> helperClass = Class.forName("com.tieto.examples.multicatch.Helper");			 
			final Object helper = helperClass.newInstance();			
			final Method method= helperClass.getDeclaredMethod("getSomething");			
			final String str = (String) method.invoke(helper);
			System.out.println(str);
			
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("Error message: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFound: " + e.getMessage());
		}
	}
		
	
	/**
	 * SafeReThrow in Java7
	 * 
	 * @param bool
	 * @throws Exception1
	 * @throws Exception2
	 */
	public static void safeReThrowJava7(final boolean bool) throws Exception1, Exception2 {		
		try {
			if (bool) {
				throw new Exception1();
			}
			throw new Exception2();
		} catch (final Throwable e) {
			//	logger.log(e);
			System.out.println("Java 7 is great!!");
			throw e; // Compiles OK; can throw X1,X2
		}		
	}
	
}
