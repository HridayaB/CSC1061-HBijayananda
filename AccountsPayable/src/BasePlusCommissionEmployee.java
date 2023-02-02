/**
 * 
 * Base Plus Commission Employee class
 * @author Hridaya Bijayananda
 *
 */
public class BasePlusCommissionEmployee extends CommissionEmployee
{

	private double basePay; // Base plus commission employee's base pay

	/**
	 * auto-generated constructor
	 * @param grossSales
	 * @param commissionRate
	 * @param basePay
	 */
	public BasePlusCommissionEmployee ( double grossSales, double commissionRate, double basePay ) 
	{
		super ( grossSales, commissionRate );
		this.basePay = basePay;
	} // end of auto-generated constructor
	
	/**
	 * Default constructor including data members from parent and grandparent
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param grossSales
	 * @param commissionRate
	 * @param basePay
	 */
	public BasePlusCommissionEmployee ( String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double basePay )
	{
		super ( firstName, lastName, socialSecurityNumber, grossSales, commissionRate );
		this.basePay = basePay;
	} // end of default constructor

	/**
	 * auto-generated getter and setter
	 * @return
	 */
	public double getBasePay ( ) 
	{
		return basePay;
	}

	public void setBasePay ( double basePay ) 
	{
		this.basePay = basePay;
	}
	
	// end of auto-generated getter and setter
	
	/**
	 * The payment for this employee will be their base salary + their commission
	 */
	@Override
	public double getPaymentAmount ( )
	{
		double commission = getGrossSales ( ) * getCommissionRate ( );
		double getPayment = basePay + commission;
		double payment = ( Math.round ( getPayment * 100 ) ) / 100.0; // rounding
		return payment;
	} // end of getPaymentAmount

	/**
	 * auto-generated toString method
	 */
	@Override
	public String toString ( ) 
	{
		return "BasePlusCommissionEmployee: \n" + "Base plus commission employee's first name = " + getFirstName ( ) + "\n" + "Base plus commission employee's last name = " + getLastName ( )
				+ "\n" + "Base plus commission employee's social security number = " + getSocialSecurityNumber ( ) + "\n" + "Base plus commission employee's base pay = " + getBasePay ( )  
				+ "\n" + "Base plus commission employee's gross sales = $" + getGrossSales ( ) + "\n" + "Base plus commission employee's commission rate = " + getCommissionRate ( ) + "%" + "\n" + "Base plus commission employee's payment = $" + getPaymentAmount ( );
	} // end of auto-generated toString method
	
} // end of class BasePlusCommissionEmployee
