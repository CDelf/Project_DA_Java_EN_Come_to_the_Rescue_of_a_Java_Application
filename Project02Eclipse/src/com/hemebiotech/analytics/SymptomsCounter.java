package com.hemebiotech.analytics;

import java.text.Collator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Creation of a map associating a string (=symptom) to a value (=number of
 * occurence in the list).
 * 
 * Utilisation of a TreeMap that automatically respects alphabetical order for
 * strings.
 * 
 * @return mapCounter : a list of symptoms in natural ordrer with their
 *         occurences
 */

public class SymptomsCounter {

	public static Map<String, Integer> mapSymptom(List<String> symptoms) {

		Map<String, Integer> mapCounter = new TreeMap<>(Collator.getInstance());

			for (String str : symptoms) {
				mapCounter.put(str, mapCounter.get(str) == null ? 1 : mapCounter.get(str) + 1);
			}

		return mapCounter;
	}
}
