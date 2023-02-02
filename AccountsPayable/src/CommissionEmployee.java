/**
 * 
 * Commission Employee class
 * @author Hridaya Bijayananda
 *
 */
public class CommissionEmployee extends Employee
{
	
	private double grossSales; // Commission employee's gross sales
	private double commissionRate; // Commission employee's commission rates
	
	/**
	 * auto-generated constructor
	 * @param grossSales
	 * @param commissionRate
	 */
	public CommissionEmployee ( double grossSales, double commissionRate ) 
	{
		super ( );
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	} // end of auto-generated constructor

	/**
	 * default constructor including data members from parent
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param grossSales
	 * @param commissionRate
	 */
	public CommissionEmployee ( String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate )
	{
		super ( firstName, lastName, socialSecurityNumber );
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	} // end of default constructor
	
	/**
	 * auto-generated getters and setters
	 * @return
	 */
	public double getGrossSales ( ) 
	{
		return grossSales;
	}

	public void setGrossSales ( double grossSales ) 
	{
		this.grossSales = grossSales;
	}

	public double getCommissionRate ( ) 
	{
		return commissionRate;
	}

	public void setCommissionRate ( double commissionRate ) 
	{
		this.commissionRate = commissionRate;
	}
	
	// end of auto-generated getters and setters
	
	/**
	 * The payment for this employee will be their gross sales multiplied by their commission rate
	 */
	@Override
	public double getPaymentAmount ( )
	{
		double getPayment = grossSales * commissionRate;
		double payment = ( Math.round ( getPayment * 100 ) ) / 100.0; // rounding
		return payment;
	} // end of getPaymentAmount

	/**
	 * auto-generated toString method
	 */
	@Override
	public String toString ( ) 
	{
		return "Commission Employee: \n" + "Commission employee's first name = " + getFirstName ( ) + "\n" + "Commission employee's last name = " 
				+ getLastName ( ) + "\n" + "Commission employee's social security number = " + getSocialSecurityNumber ( ) +  "\n" 
				+ "Commission employee's gross sales = $" + getGrossSales ( ) + "\n" + "Commission employee's commission rate = " + getCommissionRate ( ) + "%" + "\n" + "Commission employee's payment = $" + getPaymentAmount ( );
	} // end of auto-generated toString method
	
} // end of class CommissionEmployee
