import java.util.Arrays;

/**
 * 
 * Student class
 * Inherits from Person and has a data member for a Student's status in thier school
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Student extends Person
{
	
	private String [ ] STATUS = { "Freshman", "Sophomore", "Junior", "Senior" }; // Types of statuses for students
	private String status; // Student's status can be Freshman, Sophomore, Junior, or Senior
	
	/**
	 * Default constructor method including parent's data members
	 * 
	 * @param name Student's name
	 * @param address Student's address
	 * @param phoneNumber Student's phone number
	 * @param emailAddress Student's email address
	 * @param status Student's status
	 */
	public Student ( String name, String address, String phoneNumber, String emailAddress, String status )
	{
		super ( name, address, phoneNumber, emailAddress );
		this.status = status;
	} // end of default constructor method

	/**
	 * Auto-generated constructor method
	 * 
	 * @param status Student's status
	 */
	public Student ( String status ) 
	{
		super ( );
		this.status = status;
	} // end of auto-generated constructor method	
	
	/**
	 * Auto-generated getter method
	 * 
	 * @return Student's status
	 */
	public String getStatus ( ) 
	{
		return status;
	}

	/**
	 * Auto-generated status setter method
	 * 
	 * @param status Student's status
	 */
	public void setStatus ( String status ) 
	{
		this.status = status;
	}
	// end of getter and setter methods

	/**
	 * Customized toString method
	 * 
	 * @return A string with the student's information in a new line
	 */
	@Override
	public String toString ( ) 
	{
		return "Student: \n" + "Status: " + Arrays.toString ( STATUS ) + "\n" + "Name:" + getName ( ) + "\n" + "Address:" + getAddress ( ) + "\n" + "Phone Number:" + getPhoneNumber ( ) + "\n"
				+ "Email Address:" + getEmailAddress ( ) + "\n" + "Status:" + getStatus ( ) + "\n";
	} // end of customized toString method
	
	/**
	 * Customized toString method for the Database class
	 * 
	 * @return A string with the person's information separated by a comma
	 */
	@Override
	public String dbToString ( )
	{
		return getClass ( ) + ": " + ", " + getName ( ) + ", " + getAddress ( ) + ", " + getPhoneNumber ( )
				+ ", " + getEmailAddress ( ) + ", " + getStatus ( ) + "\n";
	} // end of dbToString
	
} // end of class Student
