package edu.frcc.csc1061j.ArrayAndLinkedLists;

import java.util.Arrays;
import java.util.List;

public class TestList 
{

	public static void main ( String [ ] args ) 
	{
		MyDoubleLinkedList < Integer > myList = new MyDoubleLinkedList < Integer > ( );
		myList.add ( 1 );
		myList.add ( 2 );
		myList.add ( 3 );
		myList.add ( 4 );
		myList.add ( 5 );
		myList.add ( 6 );
		System.out.println ( Arrays.toString ( myList.toArray ( ) ) + " " + "Size: " + myList.size ( ) );

		myList.reverse();
		System.out.println ( Arrays.toString ( myList.toArray ( ) ) + " " + "Size: " + myList.size ( ) );

		myList.remove ( 3 );
		System.out.println ( Arrays.toString ( myList.toArray ( ) ) + " " + "Size: " + myList.size ( ) );

		for ( int num : myList )
		{
			System.out.println (num);
		}
		
	} // end of main

} // end of class TestList
