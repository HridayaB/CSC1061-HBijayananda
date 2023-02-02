/**
 * 
 * Hourly Employee class
 * @author Hridaya Bijayananda
 *
 */
public class HourlyEmployee extends Employee
{

	private double hourlyWage; // Hourly employee's hourly wage
	private double hours; // Hourly employee's number of hours worked
	
	/**
	 * auto-generated constructor
	 * @param hourlyWage
	 * @param hours
	 */
	public HourlyEmployee ( double hourlyWage, double hours ) 
	{
		super ( );
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	} // end of auto-generated constructor
	
	/**
	 * Default constructor including data members from parent
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param hourlyWage
	 * @param hours
	 */
	public HourlyEmployee ( String firstName, String lastName, String socialSecurityNumber, double hourlyWage, double hours )
	{
		super ( firstName, lastName, socialSecurityNumber );
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	} // end of default constructor

	/**
	 * auto-generated getters and setters
	 * @return
	 */
	public double getHourlyWage ( ) 
	{
		return hourlyWage;
	}

	public void setHourlyWage ( double hourlyWage ) 
	{
		this.hourlyWage = hourlyWage;
	}

	public double getHours ( ) 
	{
		return hours;
	}

	public void setHours ( double hours ) 
	{
		this.hours = hours;
	}
	
	// end of auto-generated getters and setters
	
	/**
	 * The payment for this employee will be their hourly wage multiplied by the number of hours they worked
	 */
	@Override
	public double getPaymentAmount ( )
	{
		double getPayment = hourlyWage * hours;
		double payment = ( Math.round ( getPayment * 100 ) ) / 100.0; // rounding
		return payment;
	} // end of getPaymentAmount

	/**
	 * auto-generated toString method
	 */
	@Override
	public String toString() {
		return "Hourly Employee: \n" + "Hourly employee's first name = " + getFirstName ( ) + "\n" + "Hourly employee's last name = " + getLastName ( )
				+ "\n" + "Hourly employee's social security number = " + getSocialSecurityNumber ( ) + "\n" + "Hourly employee's hourly wage = " + getHourlyWage ( ) 
				+ "\n" + "Hourly employee's number of hours worked = " + getHours ( ) + "\n" + "Hourly employee's payment = $" + getPaymentAmount ( );
	} // end of auto-generated method 
	
} // end of class HourlyEmployee
