package com.tieto.examples.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Try-with_resources simplest demo
 * 
 * @author pfeffvla (Pfeffer Vladimir)
 * 
 */
public class FirstLine {

	public static void main(String[] args) throws IOException {
		final String path = "src/com/tieto/examples/trywithresources/testFile";

		String line = readFirstLineFromFile(path);
		String oldLine = readFirstLineFromFileWithFinallyBlock(path);

		System.out.println(line);
	}

	/**
	 * New style comes with Java7. It's really great!!!
	 * 
	 * @param path
	 *            path to file
	 * @return the first line of file
	 * @throws IOException
	 */
	static String readFirstLineFromFile(final String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	/**
	 * Old style with manual close is still working.
	 * 
	 * @param path
	 *            path to the file
	 * @return the first line of file.
	 * @throws IOException
	 */
	static String readFirstLineFromFileWithFinallyBlock(String path)
			throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}
}
