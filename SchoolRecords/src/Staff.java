import java.util.Arrays;

/**
 * 
 * Staff class
 * Inherits from Employee, employee's working in placed like administration, It has a title for the employee as a data member
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Staff extends Employee
{
	
	private String title; // The staff employee's status
	
	/**
	 * Default constructor method including parent's and grandparent's data members
	 * 
	 * @param name The staff employee's name
	 * @param address The staff employee's address
	 * @param phoneNumber The staff employee's phone number
	 * @param emailAddress The staff employee's email address
	 * @param office The staff employee's office
	 * @param title The staff employee's title
	 * @param salary The staff employee's salary
	 * @param dateHired The date the staff employee's were hired
	 */
	public Staff ( String name, String address, String phoneNumber, String emailAddress, String office, String title, double salary, String dateHired )
	{
		super ( name, address, phoneNumber, emailAddress, office, salary, dateHired );
		this.title = title;
	} // end of default constructor method

	/**
	 * Auto-generated constructor method
	 * 
	 * @param office The staff employee's office
	 * @param title The staff employee's title
	 * @param salary The staff employee's salary
	 * @param dateHired The date the staff employee's were hired
	 */
	public Staff ( String office, String title , double salary, String dateHired ) 
	{
		super ( office, salary, dateHired );
		this.title = title;
	} // end of auto-generated constructor method

	/**
	 * Auto-generated getter method
	 * 
	 * @return The staff employee's title
	 */
	public String getTitle ( ) 
	{
		return title;
	}

	/**
	 * Auto-generated setter method
	 * 
	 * @param title The staff employee's title
	 */
	public void setTitle ( String title ) 
	{
		this.title = title;
	}
	// end of auto-generated getter and setter methods
	
	/**
	 * Customized toString method
	 * 
	 * @return A string with the Staff employee's information in a new line
	 */
	@Override
	public String toString ( ) 
	{
		return "Staff: \n" + "Name:" + getName ( ) + "\n" + "Address:" + getAddress ( ) + "\n" + "Phone Number:" + getPhoneNumber ( ) + "\n" 
				+ "Email Address:" + getEmailAddress ( ) + "\n" + "Office:" + getOffice ( ) + "\n" + "Title:" + getTitle ( ) + "\n" 
				+ "Salary: $" + getSalary ( ) + "\n" + "Date Hired:" + getDateHired ( ) + "\n";
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
				+ ", " + getEmailAddress ( ) + ", " + getOffice ( ) + ", " + getTitle ( ) + ", " + getSalary ( )
				+ ", " + getDateHired ( )+ "\n";
	} // end of dbToString
	
} // end of class Staff
