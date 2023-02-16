import java.util.Arrays;

/**
 * 
 * Faculty class
 * Inherits from Employee, employee's involved in academics, professors and teachers. It has the faculty employee's rank and their office hours as data members
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Faculty extends Employee
{
	
	private String [ ] RANK = { "Junior", "Senior" }; // Types of ranks
	private String officeHours; // The office hours for faculty employee
	private String rank; // The faculty employee's rank
	
	/**
	 * Default constructor method including parent's and grandparent's data members
	 * 
	 * @param name The faculty employee's name
	 * @param address The faculty employee's address
	 * @param phoneNumber The faculty employee's phone number
	 * @param emailAddress The faculty employee's email address
	 * @param office The faculty employee's office
	 * @param officeHours The faculty employee's office hours
	 * @param rank The faculty employee's rank
	 * @param salary The faculty employee's salary
	 * @param dateHired The date the faculty employee was hired
	 */
	public Faculty ( String name, String address, String phoneNumber, String emailAddress, String office, String officeHours, String rank, double salary, String dateHired )
	{
		super ( name, address, phoneNumber, emailAddress, office, salary, dateHired );
		this.officeHours = officeHours;
		this.rank = rank;
	} // end of default constructor method

	/**
	 * Auto-generated constructor method
	 * 
	 * @param office The faculty employee's office
	 * @param officeHours The faculty employee's office hours
	 * @param rank The faculty employee's rank
	 * @param salary The faculty employee's salary
	 * @param dateHired The date the faculty employee was hired
	 */
	public Faculty ( String office, String officeHours, String rank, double salary, String dateHired )
	{
		super ( office, salary, dateHired );
		this.officeHours = officeHours;
		this.rank = rank;
	} // end of auto-generated constructor method

	/**
	 * Auto-generated office hours getter method
	 * 
	 * @return The faculty employee's office hours
	 */
	public String getOfficeHours ( ) 
	{
		return officeHours;
	}

	/**
	 * Auto-generated office hours setter method
	 * 
	 * @param officeHours The faculty employee's office hours
	 */
	public void setOfficeHours ( String officeHours ) 
	{
		this.officeHours = officeHours;
	}

	/**
	 * Auto-generated rank getter method
	 * 
	 * @return The faculty employee's rank
	 */
	public String getRank ( ) 
	{
		return rank;
	}

	/**
	 * Auto-generated rank setter method
	 * 
	 * @param rank The faculty employee's rank
	 */
	public void setRank ( String rank ) 
	{
		this.rank = rank;
	}
	// end of auto-generated getter and setter methods

	/**
	 * Customized toString method
	 * 
	 * @return A string with the faculty employee's information in a new line
	 */
	@Override
	public String toString ( ) 
	{
		return "Faculty: \n" + "Rank: " + Arrays.toString ( RANK ) + "\n" + "Name:" + getName ( ) + "\n" + "Address:" + getAddress ( ) + "\n"
				+ "Phone Number:" + getPhoneNumber ( ) + "\n" + "Email Address:" + getEmailAddress ( ) + "\n" + "Office:" + getOffice ( ) + "\n" 
				+ "Office Hours:" + getOfficeHours ( ) + "\n" + "Rank:" + getRank ( ) + "\n" + "Salary: $" + getSalary ( ) + "\n" + "Date Hired:" + getDateHired ( ) + "\n";
	} // end of customized toString method
	
} // end of class Faculty
