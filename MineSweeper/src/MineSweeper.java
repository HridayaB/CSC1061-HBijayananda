import java.util.Scanner;

public class MineSweeper
{
	static Scanner input;
	public static void main( String[ ] args )
	{
		input = new Scanner (System.in);
		System.out.println ( "Welcome to the game of MineSweeper!" );
		int [ ] [ ] locationArray = new int [ 3 ] [ 9 ]; // the array with the locations in the board
		boolean gameOver = false; // to check if the game is over
		startingTestArray ( locationArray );
		char bombFlag; // marking the bombs with a flag
		while ( gameOver == false )
		{
			printBoard ( locationArray );
			int row; // the rows of the board
			int column; // the columns of the board
			System.out.println ( "Enter the row you are choosing from." );
			row = input.nextInt ( );
			while ( row > 2 || row < 0 )
			{
				System.out.println ( "Error, the number you entered is either too high or too low. Please try again." );
				row = input.nextInt ( );
			} // end of while loop
			System.out.println ( "Enter the column you are choosing from." );
			column = input.nextInt ( );
			while ( column > 8 && column < 0 )
			{
				System.out.println ( "Error, the number you entered is either too high or too low. Please try again." );
				column = input.nextInt ( );
			} // end of while loop
			System.out.println ( "You chose the spot in row " + row + " and column " + column );
			System.out.println ( "Will you mark this location as a bomb? (y/n)" );
			input.nextLine ( );
			bombFlag = input.nextLine().charAt ( 0 );
			gameOver = examineLocation ( locationArray, row, column, bombFlag );
			if ( gameOver == false )
			{
				gameOver = gameOverCheck ( locationArray );
			} // end of if statement
		} // end of while loop
		System.out.println ( "You have completed the game :)!!!");
		printBoard ( locationArray );
		input.close ( );
	} // end of main
	
	/*
	 * Description: prints the board
	 * Parameter: 
	 * int [ ] [ ] locationArray - the array with the locations in the board 
	 * return type void
	 */
	public static void printBoard ( int [ ] [ ] locationArray )
	{
		System.out.print ( "   " );
		for ( int column = 0; column < locationArray[0].length; column++)
		{
			System.out.printf ( "%3d", column);
		} // end of for loop
		System.out.println ( );
		//locationArray [ 2 ] [ 5 ] = 101;
		for ( int row = 0; row < locationArray.length; row++ )
		{
			System.out.printf ( "%3d", row );
			for ( int column = 0; column < locationArray[0].length; column++)
			{
				if ( locationArray [ row ] [ column ] > -1 && locationArray [ row ] [ column ] < 12 )
				{
					System.out.printf ( "  ." );
				} // end of if statement
				else if ( locationArray [ row ] [ column ] == - 11 )
				{
					System.out.print ( "   " );
				} // end of else if statement
				else if ( locationArray [ row ] [ column ] < 0 )
				{
					System.out.printf ( "%3d", - locationArray [ row ] [ column ] );
				} // end of else if statement
				else if ( locationArray [ row ] [ column ] > 99 )
				{
					System.out.print ( "  b" );
				} // end of else if statement		
			} // end of inner for loop
			System.out.println ( );
		} // end of outer for loop
	} // end of printBoard
	
	/*
	 * Description:
	 * Parameter:
	 * int [ ] [ ] locationArray - the array with the locations in the board
	 * return type boolean
	 */
	public static boolean gameOverCheck ( int [ ] [ ] locationArray )
	{
		int i; // LCV
		int j; // LCV
		for ( i = 0; i < locationArray.length; i ++ )
		{
			for ( j = 0; j < locationArray[0].length; j ++ )
			{
				if ( locationArray  [ i ] [ j ] == 10)
				{
					return false;
				} // end of if statement
				else if ( locationArray  [ i ] [ j ] > 99 && locationArray  [ i ] [ j ] < 110 )
				{
					return false;
				} // end of else if statement
			} // end of inner for loop
		} // end of outer for loop
		return true;
	} // end of gameOverCheck
	
	/*
	 * Description: examining the location chosen
	 * Parameters: 
	 * int [ ] [ ] locationArray - the array with the locations in the board
	 * int row - the rows in the board
	 * int column - the columns in the board
	 * char bombFlag - marking the bombs with a flag
	 * return type boolean 
	 */
	public static boolean examineLocation ( int [ ] [ ] locationArray, int row, int column, char bombFlag )
	{
		if ( row < locationArray.length && row > -1 && column > -1 && column < locationArray [ 0 ].length && locationArray [ row ] [ column ] >= 0)
		{
			if ( bombFlag == 'y' )
			{
				locationArray [ row ] [ column ] = locationArray [ row ] [ column ] + 100;
			} // end of if statement
			else if ( locationArray [ row ] [ column ] == 10 )
			{
				System.out.println ( "*" );
				System.out.println ( "Game Over :(" );
				return true;
			} // end of else if statement
			else if ( locationArray [ row ] [ column ] == 11 )
			{
				locationArray [ row ] [column] = - locationArray [ row ] [column];
				// all the "tricky code" / recursive calls below
				examineLocation ( locationArray, row - 1, column - 1, bombFlag );
				examineLocation ( locationArray, row - 1, column, bombFlag );
				examineLocation ( locationArray, row - 1, column + 1, bombFlag );
				examineLocation ( locationArray, row, column + 1, bombFlag );
				examineLocation ( locationArray, row + 1, column + 1, bombFlag );
				examineLocation ( locationArray, row + 1, column, bombFlag );
				examineLocation ( locationArray, row + 1, column - 1, bombFlag );
				examineLocation ( locationArray, row, column - 1, bombFlag );	
			} // end of else if statement 
			else if ( locationArray [ row ] [ column ] < 10)
			{
				locationArray [ row ] [column] = - locationArray [ row ] [column];
			} // end of else if statement
		} // end of if statement
		else { ; }	
		return false;
	} // end of examineLocation
	
	/*
	 * Description: used for testing the locationArray
	 * Parameter:
	 * int [ ] [ ] locationArray - the array with the locations in the board
	 * return type void
	 */
	public static void startingTestArray ( int [ ] [ ] locationArray )
	{
		locationArray [ 0 ] [ 0 ] = 1; // a space with a 1
		locationArray [ 0 ] [ 1 ] = 1;
		locationArray [ 0 ] [ 2 ] = 1;
		locationArray [ 0 ] [ 3 ] = 11;
		locationArray [ 0 ] [ 4 ] = 11;
		locationArray [ 0 ] [ 5 ] = 11;
		locationArray [ 0 ] [ 6 ] = 11;
		locationArray [ 0 ] [ 7 ] = 11;
		locationArray [ 0 ] [ 8 ] = 11;
		locationArray [ 1 ] [ 0 ] = 1;
		locationArray [ 1 ] [ 1 ] = 10; // bomb
		locationArray [ 1 ] [ 2 ] = 2;
		locationArray [ 1 ] [ 3 ] = 1;
		locationArray [ 1 ] [ 4 ] = 1;
		locationArray [ 1 ] [ 5 ] = 11;
		locationArray [ 1 ] [ 6 ] = 11; // empty space
		locationArray [ 1 ] [ 7 ] = 11;
		locationArray [ 1 ] [ 8 ] = 11;
		locationArray [ 2 ] [ 0 ] = 1;
		locationArray [ 2 ] [ 1 ] = 1;
		locationArray [ 2 ] [ 2 ] = 2;
		locationArray [ 2 ] [ 3 ] = 10;
		locationArray [ 2 ] [ 4 ] = 1;
		locationArray [ 2 ] [ 5 ] = 11;
		locationArray [ 2 ] [ 6 ] = 11;
		locationArray [ 2 ] [ 7 ] = 11;
		locationArray [ 2 ] [ 8 ] = 11;
	} // end of startingTestArray
	
} // end of class MineSweeperHB

/*
 * Problems: 
 * I didn't need a board
 * It was my first time coding 2ns dimensional arrays, so I had trouble figuring it out
 * I had trouble to make it run through the for loops in the method examineLocation properly
 * For some reason, I couldn't get the values I set on startingTestArray to translate on examineLocation
 */
