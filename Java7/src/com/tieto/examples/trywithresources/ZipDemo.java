package com.tieto.examples.trywithresources;

import java.io.IOException;

public class ZipDemo {

	/**
	 * Main method
	 * 
	 * @param args
	 *            parameters
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final String zipFileName = "src/com/tieto/examples/trywithresources/test.zip";
		final String outputFileName = "src/com/tieto/examples/trywithresources/outputFile";

		writeToFileZipFileContents(zipFileName, outputFileName);

	}

	public static void writeToFileZipFileContents(String zipFileName,
			String outputFileName) throws java.io.IOException {

		java.nio.charset.Charset charset = java.nio.charset.Charset.forName("US-ASCII");
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

		// Open zip file and create output file with try-with-resources
		// statement

		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
			 java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {

			// Enumerate each entry
			for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {

				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName = ((java.util.zip.ZipEntry) entries
						.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}

}
