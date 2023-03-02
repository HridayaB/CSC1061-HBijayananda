/*
 * Copyright (c) 2023 Hridaya Bijayananda
 */


import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * School Records Assignment
 * School Records driver class
 *
 * @author Hridaya Bijayananda
 *
 */
public class TestSchoolRecords 
{

	/**
	 * Creates 6 persons, 2 students, 2 faculty, and 2 staff. Uses Database class to write to and read from file
	 * 
	 * @param args Command line arguments
	 * @throws IOException For database
	 */
	public static void main ( String [ ] args ) throws IOException 
	{
		Database database = new Database ( );	
		
		Student student = new Student ( "Carbon Dioxide", "68 Chemistry St.", "(789) 456-1230", "hexaocto@gmail.com", "Freshman" );
		Student student2 = new Student ( "Pi e", "314 Math St.", "(123) 456-7890", "314@gmail.com", "Senior" );

		Faculty faculty = new Faculty ( "Adam Jenkins", "5364 Atom Dr.", "(582) 153-2580", "periodictable@gmail.com", "Chemistry", "10:00 A.M. - 3:00 P.M.", "Junior", 76900.98, "09/15/12" );
		Faculty faculty2 = new Faculty ( "Aurora Skew", "3141 Pi Dr.", "(822) 794-6123", "pascalstriangle@gmail.com", "Calculus", "11:00 A.M. - 5:00 P.M.", "Senior", 82442.66, "04/17/04" );
		
		Staff staff = new Staff ( "Gwen Stacy", "2578 Studious St.", "(524) 391-5697", "Ms.Dean@gmail.com", "Administration", "Dean", 186500.28, "02/21/14" );
		Staff staff2 = new Staff ( "Josh Hidgens", "7530 Burning Houses Dr.", "(712) 954-1236", "freefall@gmail.com", "Security", "Head of Security", 76540.67, "11/22/19" );
		
		database.writePerson ( student );
		database.writePerson ( student2 );
		database.writePerson ( faculty );
		database.writePerson ( faculty2 );
		database.writePerson ( staff );
		database.writePerson ( staff2 );
		
		for ( Person person : database.readPerson ( ) )
		{
			System.out.println ( person.toString ( ) );
		} // end of for loop
		
		database.close ( );
	} // end of main

} // end of driver class TestSchoolRecords
