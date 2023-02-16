/**
 * 
 * Employee class
 * Inherits from Person, is the parent for Faculty and Staff. It has office, salary, and dateHired as data members
 *  
 * @author Hridaya Bijayananda
 *
 */
public class Employee extends Person
{
	
	private String office; // The office the employee works in
	private double salary; // The employee's salary
	private String dateHired; // The date the employee was hired
	
	/**
	 * Default constructor method including parent's data members
	 * 
	 * @param name Employee's name
	 * @param address Employee's address
	 * @param phoneNumber Employee's phone number
	 * @param emailAddress Employee's email address
	 * @param office Employee's office
	 * @param salary Employee's salary
	 * @param dateHired The date the employee was hired
	 */
	public Employee ( String name, String address, String phoneNumber, String emailAddress, String office, double salary, String dateHired )
	{
		super ( name, address, phoneNumber, emailAddress );
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	} // end of default constructor method

	/**
	 * Auto-generated constructor method
	 * 
	 * @param office Employee's office
	 * @param salary Employee's salary
	 * @param dateHired The date the employee was hired
	 */
	public Employee ( String office, double salary, String dateHired ) 
	{
		super ( );
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	} // end of auto-generated constructor method

	/**
	 * Auto-generated office getter method
	 * 
	 * @return Employee's office
	 */
	public String getOffice ( ) 
	{
		return office;
	}

	/**
	 * Auto-generated office setter method
	 * 
	 * @param office Employee's office
	 */
	public void setOffice ( String office ) 
	{
		this.office = office;
	}

	/**
	 * Auto-generated salary getter method
	 * 
	 * @return Employee's salary
	 */
	public double getSalary ( ) 
	{
		return salary;
	}

	/**
	 * Auto-generated salary setter method
	 * 
	 * @param salary Employee's salary
	 */
	public void setSalary ( double salary ) 
	{
		this.salary = salary;
	}

	/**
	 * Auto-generated dateHired getter method
	 * 
	 * @return The date the employee got hired
	 */
	public String getDateHired ( ) 
	{
		return dateHired;
	}

	/**
	 * Auto-generated dateHired setter method
	 * 
	 * @param dateHired The date the employee got hired
	 */
	public void setDateHired ( String dateHired ) 
	{
		this.dateHired = dateHired;
	}
	// end of auto-generated getter and setter methods

	/**
	 * Customized toString method
	 * 
	 * @return A string of the employee's information in a new line
	 */
	@Override
	public String toString ( ) 
	{
		return "Employee: \n" + "Name:" + getName ( ) + "\n" + "Address:" + getAddress ( ) + "\n" + "Phone Number:" + getPhoneNumber ( ) + "\n" 
				+ "Email Address:" + getEmailAddress ( ) + "\n" + "Office:" + getOffice ( ) + "\n" + "Salary: $" + getSalary ( ) + "\n" + "Date Hired:" + getDateHired ( ) + "\n";
	} // end of customized toString
	
} // end of class Employee
