/*
 * Copyright (c) 2023 Hridaya Bijayananda
 */

package edu.frcc.csc1061j.SentimentAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import edu.frcc.csc1061j.MyHashMap.MyHashMap;

/**
 * 
 * Driver class for Sentiment Analysis, where the analysis takes place
 * 
 * @author Hridaya Bijayananda
 *
 */
public class SentimentAnalysisMenu 
{
	
	static Scanner input;
	/**
	 * Main method for the sentiment analysis
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) 
	{
		input = new Scanner(System.in);
		sentimentAnalyzer();
		input.close();
	} // end of main
	
	/**
	 * Analyzes the sentiment for a text by reading trough the text and finding specific words
	 * with sentiment values specified in a different file. Reads file, then adds together the sentiment
	 * value according to the specified values.
	 */
	public static void sentimentAnalyzer()
	{
 	   File myFile = new File("C:\\Users\\HRBCR\\CSC1061-HBijayananda\\SentimentAnalysis/sentiments.txt");
 	   Map<String, Integer> sentimentsMap = new MyHashMap<String, Integer>();
 	   try
 	   {
 		   BufferedReader reader = new BufferedReader(new FileReader(myFile));
			
 		   String line;
 		   while ((line = reader.readLine()) != null) 
 		   {
 			  String[] parts = line.split(",");
              sentimentsMap.put(parts[0], Integer.parseInt(parts[1]));
		   }
 		   reader.close();
 	   } 
 	   catch (IOException e) 
 	   {
 		   System.err.println("Error reading from file: " + e.getMessage());
 		   System.exit(-1);
 	   }
 	   
	 	String text; // User input text
		String prevWord = null; // Previous word in the string
		int totalSentiment = 0; // The total of the sentiments
		int numWords = 0; // The total number of words in the text
		boolean quit = false; // LCV
		
		System.out.println("Enter text (type 'END' to finish text): ");
		text = input.nextLine();
		
		while (quit != true)
		{
			// User keeps entering text until they type 'END'
			if (!text.contains("END"))
			{
				String text2 = input.nextLine();
				String finalTxt = text.concat(" " + text2);
				text = finalTxt;
			} // end of if statement

			// After user types 'END'
			if (text.contains("END"))
			{
				// Remove punctuation and convert to lower case
				String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
				for (String word : words)
				{
					String phrase = prevWord + " " + word; // Phrase concatenating previous word and current word
					
					  // If the hashmap contains the word or the phrase as a key
					  if (sentimentsMap.containsKey(word) || sentimentsMap.containsKey(phrase))
					  {
						  Integer sentiment = sentimentsMap.get(word); // Get the value/sentiment for the matching key/word
						  if (sentiment != null || prevWord != null)
						  {
							  if (prevWord != null)
							  {
								  sentiment = sentimentsMap.get(phrase); // Get the value/sentiment for the matching key/phrase
								  if (sentiment != null)
								  {
									  totalSentiment += sentiment; // For phrase
								  } // end of if statement
								  if (sentiment == null)
								  {
									  sentiment = sentimentsMap.get(word); // Reseting the sentiment for the single word
									  totalSentiment += sentiment; // For single word
								  } // end of if statement
							  } // end of if statement
						  } // end of if statement
					  } // end of if statement
					  
					  // Default: if the word isn't a key
					  if (!sentimentsMap.containsKey(word))
					  {
						  totalSentiment += 0;
					  } // end of if statement
		
					  prevWord = word; // Setting the current word to the previous word for next iteration
				} // end of enhanced for loop
				
				numWords = words.length - 1; // - 1 for the 'END'
				double average = (double)totalSentiment / numWords; // Average sentiment of the text
				average = ( Math.round ( average * 100 ) ) / 100.0; // For rounding
				System.out.println();
				System.out.println("Words: " + numWords);
				System.out.println("Sentiment: " + totalSentiment);
				System.out.println("Overall: " + average);
				if (totalSentiment > 0)
				{
					System.out.println("\u001B[32m" + "Positive sentiment analysis :)" + "\u001B[0m"); // Prints in green
				} // end of if statement
				else if (totalSentiment < 0)
				{
					System.out.println("\u001B[31m" + "Negative sentiment analysis :(" + "\u001B[0m"); // Prints in red
				} // end of if statement
				else if (totalSentiment == 0)
				{
					System.out.println("Neutral sentiment analysis :|"); // Prints in neutral color
				} // end of if statement
		          
				System.out.println();
				System.out.println("Do you want to enter another text? (Enter 'y' for yes and 'n' for no)");
				text = input.nextLine();
				if (text.equalsIgnoreCase("y"))
				{
					totalSentiment = 0; // Resets the total sentiment for the new text
					System.out.println();
					System.out.println("Enter text (type 'END' to finish text): ");
					text = input.nextLine();
				} // end of if statement
				else if (text.equalsIgnoreCase("n"))
				{
					System.out.println();
					System.out.println("Bye-bye " + "\u001B[33m" + "( ･ω･)ﾉ" + "\u001B[0m"); // Waving bye in yellow
					quit = true;
		        } // end of if statement
			} // end of if statement
		} // end of while loop
	} // end of sentimentAnalyzer
	
} // end of class SentimentAnalysisMenu
