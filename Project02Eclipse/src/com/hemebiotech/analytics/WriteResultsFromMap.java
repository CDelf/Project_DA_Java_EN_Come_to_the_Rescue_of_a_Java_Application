package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Exports the list of symptoms in natural ordrer with their occurences into a
 * .txt file "results.out"
 * 
 * @throws IOException
 */

public class WriteResultsFromMap {

	public static void writeResult(Map<String, Integer> mapCounter, List<String> symptoms) throws IOException {

		FileWriter writer = new FileWriter("results.out.txt");
		for (Map.Entry<String, Integer> entry : mapCounter.entrySet()) {
			writer.write(entry.getKey() + " = " + entry.getValue());
			writer.write(System.lineSeparator());
		}
		writer.close();

	}
}
