package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomsFromFile {

	private String filePath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */

	public ReadSymptomsFromFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Arraylist of strings containing the list of symptoms. If no data is
	 * available, return an empty List.
	 * 
	 * @return symptoms : a raw listing of all Symptoms obtained from a data source,
	 *         duplicates are possible/probable.
	 * 
	 * @throws IOException
	 */

	public List<String> GetSymptom() {
		ArrayList<String> symptoms = new ArrayList<String>();

		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				String line = reader.readLine();

				while (line != null) {
					symptoms.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return symptoms;
	}
}
