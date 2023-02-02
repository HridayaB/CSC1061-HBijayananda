/**
 * 
 * Employee class
 * @author Hridaya Bijayananda
 *
 */
public class Employee 
{
	
	private String firstName; // Employee's first name
	private String lastName; // Employee's last name
	private String socialSecurityNumber; // Employee's social security number
	
	/**
	 * default constructor
	 */
	public Employee ( )
	{
		firstName = "John";
		lastName = "Smith";
		socialSecurityNumber = "123-45-6789";	
	} // end of default constructor
	
	/**
	 * auto-generated constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 */
	public Employee( String firstName, String lastName, String socialSecurityNumber ) 
	{
		super ( );
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	} // end of auto-generated constructor
	
	/**
	 * auto-generated getters and setters
	 * @return
	 */
	public String getFirstName ( ) 
	{
		return firstName;
	}

	public void setFirstName ( String firstName ) 
	{
		this.firstName = firstName;
	}

	public String getLastName ( ) 
	{
		return lastName;
	}

	public void setLastName ( String lastName ) 
	{
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber ( ) 
	{
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber ( String socialSecurityNumber ) 
	{
		this.socialSecurityNumber = socialSecurityNumber;
	}

	// end of auto-generated getters and setters
	
	/**
	 * this method returns the employee's payment
	 * @param employeePay
	 * @return
	 */
	public double getPaymentAmount ( )
	{
		double employeePay = 0.00;
		return employeePay;
	} // end of getPaymentAmount

	/**
	 * auto-generated toString method
	 * @return
	 */
	@Override
	public String toString ( ) 
	{
		return "Employee: \n" + "Employee first name = " + getFirstName ( ) + "\n" + "Employee last name = " + getLastName ( ) + "\n" + "Employee social security number = "
				+ getSocialSecurityNumber ( );
	} // end of auto-generated toString method
	
} // end of class Employee
