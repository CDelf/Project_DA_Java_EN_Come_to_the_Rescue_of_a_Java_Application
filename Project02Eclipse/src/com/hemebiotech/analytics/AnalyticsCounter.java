package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is a proposition of correction of Alex's initial code.
 * 
 * It works whatever the number of symptoms contained by the file symptoms.txt
 * and allows the addition of new ones.
 * 
 * Exceptions handling is managed.
 * 
 * However this code doesn't respect the POO method.
 */

public class AnalyticsCounter {

	public static String filepath = "symptoms.txt"; // This is the file containing the list of Symptoms

	public static void main(String[] args) throws Exception {

		/**
		 * Arraylist of strings containing the list of symptoms. If no data is
		 * available, return an empty List.
		 * 
		 * @return a raw listing of all Symptoms obtained from a data source, duplicates
		 *         are possible/probable.
		 */

		ArrayList<String> getSymptoms = new ArrayList<>();

		if (filepath != null) {
			try {
				BufferedReader readSymptoms = new BufferedReader(new FileReader(filepath));

				String line = readSymptoms.readLine();

				while (line != null) {
					getSymptoms.add(line);
					line = readSymptoms.readLine();

				}
				readSymptoms.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Creation of a map associating a string (=symptom) to a value (=number of
		 * occurence in the list).
		 * 
		 * Utilisation of a TreeMap that automatically respects alphabetical order for
		 * strings.
		 */

		Map<String, Integer> mapCounter = new TreeMap<String, Integer>();

		for (String symptoms : getSymptoms) {

			mapCounter.put(symptoms, mapCounter.get(symptoms) == null ? 1 : mapCounter.get(symptoms) + 1);
		}

		/**
		 * Export the list of symptoms in natural ordrer with their occurences into a
		 * .txt file "results.out"
		 */

		// Export dans un fichier txt results.out
		FileWriter writer = new FileWriter("results.out.txt");
		for (Map.Entry<String, Integer> entry : mapCounter.entrySet()) {
			writer.write(entry.getKey() + " = " + entry.getValue());
			writer.write(System.lineSeparator());
		}
		writer.close();
	}

}