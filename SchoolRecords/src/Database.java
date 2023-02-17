import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Database class
 * A class to create a .txt or .csv file if one does not exist, used to write to the file and read from the file
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Database
{
	
	Person person = new Person ( ); 
	File file = new File ( "PersonDatabase.csv" ); // New file
	PrintWriter printWriter = new PrintWriter ( new FileOutputStream ( file.getName ( ), false ) ); // Making sure print writer works
	Scanner input;
	
	/**
	 * Default constructor method
	 * 
	 * @throws IOException For the file
	 */
	public Database ( ) throws IOException
	{
		file = new File ( "PersonDatabase.csv" );
		// see if file exist, if not create one and catch IO exceptions
		try
		{
			if ( !file.exists ( ) )
			{
				if ( file.createNewFile ( ) )
				{
					printWriter.println ( "New file: " + file.getName ( ) );
				} // end of if statement
			} // end of if statement
		} // end of try statement
		catch ( IOException e )
		{
			e.getMessage ( );
			System.exit ( -1 );
		} // end of catch statement
	} // end of default constructor method
		
	/**
	 * Writes the name of the class for the object and all the information for the object to the file
	 * 
	 * @param person The type of person that is being passed into writePerson
	 */
	public void writePerson ( Person person )
	{
		printWriter.print ( person.getClass ( ) + ": " + ", " );
		printWriter.print ( person.getName ( ) + ", " );
		printWriter.print ( person.getAddress ( ) + ", " );
		printWriter.print ( person.getPhoneNumber ( ) + ", " );
		printWriter.print ( person.getEmailAddress ( ) + ", " );
		if ( person instanceof Student )
		{
			printWriter.print ( ( ( Student ) person ).getStatus ( ) + "\n" );
		} // end of if statement
		else if ( person instanceof Faculty )
		{
			printWriter.print ( ( ( Faculty ) person ).getOffice ( ) + ", " );
			printWriter.print ( ( ( Faculty ) person ).getOfficeHours ( ) + ", " );
			printWriter.print ( ( ( Faculty ) person ).getRank ( ) + ", " );
			printWriter.print ( ( ( Faculty ) person ).getSalary ( ) + ", " );
			printWriter.print ( ( ( Faculty ) person ).getDateHired ( ) + "\n" );

		} // end of if statement
		else if ( person instanceof Staff )
		{
			printWriter.print ( ( ( Staff ) person ).getOffice ( ) + ", " );
			printWriter.print ( ( ( Staff ) person ).getTitle ( ) + ", " );
			printWriter.print ( ( ( Staff ) person ).getSalary ( ) + ", " );
			printWriter.print ( ( ( Staff ) person ).getDateHired ( ) + "\n" );
		} // end of if statement
		printWriter.flush ( );
	} // end of writePerson
	
	/**
	 * Reads all the information from the .csv file and puts it in an ArrayList
	 * 
	 * @return All the information of the person from the file as an ArrayList
	 * @throws FileNotFoundException Making sure we find the file needed
	 */
	public ArrayList < Person > readPerson ( ) throws FileNotFoundException
	{
		ArrayList < Person > listOfPerson = new ArrayList < > ( );
		input = new Scanner ( file );
		while ( input.hasNextLine ( ) )
		{
			String [ ] trav = input.nextLine ( ).split( "," );
			String className = trav [ 0 ];
			String name = trav [ 1 ];
			String address = trav [ 2 ];
			String emailAddress = trav [ 3 ];
			String phoneNumber = trav [ 4 ];
			if ( trav [ 0 ].equals ( "class Student: " ) )
			{
				String status = trav [ 5 ];
				Student student = new Student ( name, address, emailAddress, phoneNumber, status );	
				listOfPerson.add ( student );
			} // end of if statement
			else if ( className.equals ( "class Faculty: " ) )
			{
				String office = trav [ 5 ];
				String officeHours = trav [ 6 ];
				String rank = trav [ 7 ];
				Double salary = Double.parseDouble ( trav [ 8 ] );
				String dateHired = trav [ 9 ];
				Faculty faculty = new Faculty ( name, address, emailAddress, phoneNumber, office, officeHours, rank, salary, dateHired );
				listOfPerson.add ( faculty );
			} // end of else if statement
			else if ( className.equals ( "class Staff: ") )
			{
				String office = trav [ 5 ];
				String title = trav [ 6 ];
				Double salary = Double.parseDouble ( trav [ 7 ] );
				String dateHired = trav [ 8 ];
				Staff staff = new Staff ( name, address, emailAddress, phoneNumber, office, title, salary, dateHired );
				listOfPerson.add ( staff );
			} // end of else if statement
		} // end of while loop
		input.close ( );
		printWriter.close ( );
		return listOfPerson;
	} // end of readPerson

	
} // end of class Database
