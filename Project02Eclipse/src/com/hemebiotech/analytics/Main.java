package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is the main method wich reads, counts, orders and exports a list of
 * symptoms from file symptoms.txt
 * 
 * @throws Exception
 */

public class Main {

	static String filepath = new String("symptoms.txt"); // File containing the list of symptoms

	static List<String> getSymptomsFromFile = new ArrayList<String>(); // List of symptoms

	static Map<String, Integer> symptomsCounter = new TreeMap<>(); // Map of symptoms

	public static void main(String[] args) throws Exception {

		ReadSymptomsFromFile readSymptoms = new ReadSymptomsFromFile(filepath);

		getSymptomsFromFile = readSymptoms.getSymptom();

		symptomsCounter = SymptomsCounter.mapSymptom(getSymptomsFromFile);

		WriteResultsFromMap.writeResult(symptomsCounter, getSymptomsFromFile);

	}

}