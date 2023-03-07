/*
 * Copyright (c) 2023 Hridaya Bijayananda
 */

package edu.frcc.csc1061j.PlaylistManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import edu.frcc.csc1061j.ArrayAndLinkedLists.MyDoubleLinkedList;


/**
 * 
 * Driver class for Playlist Manager, the menu where all the commands can be used
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Menu 
{
	static Scanner input;
	
	/**
	 * Main method for the playlist
	 * 
	 * @param args Command line arguments
	 * @throws FileNotFoundException In case file is not found
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		input = new Scanner(System.in);

		System.out.println("*** Playlist Manager! ***");
		System.out.println("Commands: ");
		System.out.println("add" + "\n" + "remove" + "\n" + "count" + "\n" + "play" + "\n" + "shuffle" + "\n" 
							+ "reverse" + "\n" + "save" + "\n" + "load" + "\n" + "quit" + "\n");
		
		menuCommands();
		input.close();
	} // end of main
	
	/**
	 * Defines what each of the commands does in the menu
	 * 
	 * @throws FileNotFoundException In case file is not found
	 */
	public static void menuCommands() throws FileNotFoundException
	{
		MyDoubleLinkedList <Song> songList = new MyDoubleLinkedList<>(); // A list of songs
		File myFile = new File("PlaylistManager.csv"); // The file with the saved playlist
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(myFile.getName(), false));
		
		boolean quit = false; // to quit the menu
		
		while (quit != true)
		{
			System.out.print("Enter command: ");
			String userInput = input.nextLine();
			
			switch (userInput)
			{
				case "add": // Prompts the user and adds a song to the list, if a song is repeated, then user is prompted on whether they want to add it to the list
				case "Add":
					System.out.print("Enter artist name: ");
				    String artistName = input.nextLine();
				    System.out.print("Enter song title: ");
				    String songTitle = input.nextLine();

				    boolean added = false;
				   // In case of duplicate songs
				    for (Song song : songList) 
				    {
				        if (song.getArtistName().equals(artistName) && song.getSongTitle().equals(songTitle)) 
				        {
				            System.out.println("Song: " + "\u001B[31m" + song + "\u001B[0m" + " is already in this playlist. Want to add it again?"); // prints song in red
				            userInput = input.nextLine();
				            if (userInput.equalsIgnoreCase("y")) 
				            {
				                Song newSong = new Song(artistName, songTitle);
				                songList.add(newSong);
				                System.out.println("Added song: " + "\u001B[32m" + newSong + "\u001B[0m"); // Prints newSong in green
				                added = true;
				            } // end of if statement
				            else if (userInput.equalsIgnoreCase("n"))
				            {
				            	added = true;
				            }
				            break;
				        } // end of if statement
				    } // end of for loop
				    
				    if (!added) 
				    {
				        Song newSong = new Song(artistName, songTitle);
				        songList.add(newSong);
				        System.out.println("Added song: " + "\u001B[32m" + newSong + "\u001B[0m"); // Prints newSong in green
				    } // end of if statement
				    System.out.println();
					break;
				
				case "remove": // Prompts the user for artist name and song title to remove said song from list
				case "Remove":
					System.out.print("Enter artist name: ");
					artistName = input.nextLine();
					System.out.print("Enter song title: ");
					songTitle = input.nextLine();
				
					boolean removed = false;
					
					for (Song song : songList)
					{
						if (song.getArtistName().equals(artistName) && song.getSongTitle().equals(songTitle))
						{
							songList.remove(song);
							System.out.println("Removed song: " + "\u001B[31m" + song + "\u001B[0m"); // Prints songSearch in red
							removed = true;
							break;
						} // end of if statement
					} // end of for loop
					
					if (!removed)
					{
						System.err.println("Song: " + artistName + " - " + songTitle + " not found");
					} // end of if statement
					System.out.println();
					break;
				
				case "count": // Prints out the number of songs in the playlist
				case "Count":
					System.out.println(songList.size() + "\n" );
					break;
				
				case "shuffle": // Shuffles the songs in the playlist
				case "Shuffle":
					shuffle(songList);
					System.out.println();
					break;
				
				case "reverse": // Reverses the order of the songs in the playlist
				case "Reverse":
					songList.reverse();
					System.out.println();
					break;
					
				case "play": // Plays/prints out the songs in the playlist
				case "Play":
					for (Song song : songList)
					{
						System.out.println("\u001B[32m" + song + "\u001B[0m"); // prints the playlist out in green
					} // end of for loop
					System.out.println();
					break;
				
				case "save": // Saves the current state of the playlist to a csv file and prints the contents to the file
				case "Save":
					try
					{
						if (!myFile.exists())
						{
							if (myFile.createNewFile())
							{
								printWriter.println("New file: " + myFile.getName());
							} // end of if statement
						} // end of if statement
					} // end of try statement
					catch(IOException e)
					{
						e.getMessage();
						System.exit(-1);
					} // end of catch statement
					 
					for (Song song : songList) 
					{
					        printWriter.println(song.getArtistName() + "," + song.getSongTitle());
					} // end of for loop 
					printWriter.close();
					System.out.println("\u001B[32mSave successful! \u001B[0m");
					System.out.println();
					break;
					
				case "load": // Loads the information from a csv file
				case "Load":
					try 
					{
						BufferedReader reader = new BufferedReader(new FileReader(myFile));
				        String line = reader.readLine(); // reading the first line (header line
						while ((line = reader.readLine()) != null) 
				        {
							String[] trav = line.split(",");
				            artistName = trav[0];
				            songTitle = trav[1];
				        } // end of while loop
				        reader.close();
					} // end of try statement
					catch (IOException e) 
					{
						e.getMessage();
						System.exit(-1);
					} // end of catch statement
					for (Song song : songList)
					{
						System.out.println("\u001B[32m" + song + "\u001B[0m"); // prints the playlist out in green
					} // end of for loop
					System.out.println();
					break;
				
				case "quit": // Quits the menu
				case "Quit":
					quit = true;
					break;
				
				default: // If command doesn't match what is specified
					System.err.println("Invalid command, try again");
					System.out.println();
					break;
			} // end of switch statement
		} // end of while loop
	} // end of menu
	
	/**
	 * Shuffles the songs in the playlist using random
	 * 
	 * @param songList List of songs
	 */
	public static void shuffle(MyDoubleLinkedList <Song> songList)
	{
		Random rand = new Random();
		for (int i = songList.size() - 1; i > 0; i--) 
		{
	        int j = rand.nextInt(i + 1);
	        Song temp = songList.get(i);
	        songList.set(i, songList.get(j));
	        songList.set(j, temp);
	    } // end of for loop
	} // end of shuffle

} // end of class Menu
