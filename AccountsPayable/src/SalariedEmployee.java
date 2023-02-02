/**
 *
 * Salaried Employee class
 * @author Hridaya Bijayananda
 *
 */
public class SalariedEmployee extends Employee
{
	
	private double weeklySalary; // Salaried employee's weekly salary

	/**
	 * auto-generated constructor
	 * @param weeklySalary
	 */
	public SalariedEmployee ( double weeklySalary ) 
	{
		super ( );
		this.weeklySalary = weeklySalary;
	} // end of auto-generated constructor
	
	/**
	 * default constructor including data members from parent
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param weeklySalary
	 */
	public SalariedEmployee ( String firstName, String lastName, String socialSecurityNumber, double weeklySalary )
	{
		super ( firstName, lastName, socialSecurityNumber );
		this.weeklySalary = weeklySalary;
	} // end of default constructor
	
	/**
	 * auto-generated getter and setter
	 * @return
	 */
	public double getWeeklySalary ( ) 
	{
		return weeklySalary;
	}

	public void setWeeklySalary ( double weeklySalary ) 
	{
		this.weeklySalary = weeklySalary;
	}
	
	// end of auto-generated getter and setter
	
	/**
	 * The payment amount for this employee will be their weekly salary
	 */
	@Override
	public double getPaymentAmount ( )
	{
		return weeklySalary;
	} // end of getPaymentAmount

	/**
	 * auto-generated toString method
	 */
	@Override
	public String toString() {
		return "Salaried Employee: \n" + "Salaried employee's first name = " + getFirstName ( ) + "\n" + "Salaried employee's last name = " + getLastName ( )
			 	+ "\n" + "Salaried employee's social security number = " + getSocialSecurityNumber ( ) + "\n" + "Salaried employee's weekly salary = $" + getWeeklySalary ( ) + "\n" 
				+ "Salaried employee's payment = $" + getPaymentAmount ( );
	} // end of auto-generated toString method
	
} // end of class SalariedEmployee
