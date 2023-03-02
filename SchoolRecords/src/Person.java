/**
 * 
 * Person class
 * Parent for Student and Employee, grandparent for Faculty and Staff. It has name, address, phone number and email address as data members
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Person 
{

	private String name; // Person's name
	private String address; // Person's address
	private String phoneNumber; // Person's phone address
	private String emailAddress; // Person's email address
	
	/**
	 * Default constructor method
	 * 
	 */
	public Person ( )
	{
		name = "John Smith";
		address = "2849 Willow Creek Dr.";
		phoneNumber = "(970) 852-1253";
		emailAddress = "JSmith@gmail.com";
	} // end of default constructor method

	/**
	 * Auto-generated constructor method
	 * 
	 * @param name Person's name
	 * @param address Person's address
	 * @param phoneNumber Person's phone number
	 * @param emailAddress Person's email address
	 */
	public Person ( String name, String address, String phoneNumber, String emailAddress ) 
	{
		super ( );
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	} // end of auto-generated constructor method

	/**
	 * Auto-generated name getter method
	 * 
	 * @return Person's name
	 */
	
	public String getName ( ) 
	{
		return name;
	}

	/**
	 * Auto-generated name setter method
	 * 
	 * @param name Person's name
	 */
	public void setName ( String name ) 
	{
		this.name = name;
	}

	/**
	 * Auto-generated address getter method
	 * 
	 * @return Person's address
	 */
	public String getAddress ( ) 
	{
		return address;
	}

	/**
	 * Auto-generated address setter method
	 * 
	 * @param address Person's address
	 */
	public void setAddress ( String address ) 
	{
		this.address = address;
	}

	/**
	 * Auto-generated phone number getter method
	 * 
	 * @return Person's phone number
	 */
	public String getPhoneNumber ( ) 
	{
		return phoneNumber;
	}

	/**
	 * Auto-generated phone number setter method
	 * 
	 * @param phoneNumber Person's phone number
	 */
	public void setPhoneNumber ( String phoneNumber ) 
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Auto-generated email address getter method
	 * 
	 * @return Person's email address
	 */
	public String getEmailAddress ( ) 
	{
		return emailAddress;
	}

	/**
	 * Auto=generated email address setter method
	 * 
	 * @param emailAddress Person's email address
	 */
	public void setEmailAddress ( String emailAddress ) 
	{
		this.emailAddress = emailAddress;
	}
	// end of auto-generated getter and setter methods

	/**
	 * Customized toString method
	 * 
	 * @return A string with the person's information in a new line
	 */
	@Override
	public String toString ( ) 
	{
		return "Person: \n" + "Name: " + getName ( ) + "\n" +"Address: " + getAddress ( ) + "\n" 
				+ "Phone Number: " + getPhoneNumber ( ) + "\n" + "Email Address: " + getEmailAddress ( );
	} // end of customized toString method
	
	/**
	 * Customized toString method for the Database class
	 * 
	 * @return A string with the person's information separated by a comma
	 */
	public String dbToString ( )
	{
		return getClass ( ) + ": " + ", " + getName ( ) + ", " + getAddress ( ) + ", " + getPhoneNumber ( )
				+ ", " + getEmailAddress ( ) + "\n";
	} // end of dbToString
	
} // end of class Person
