import java.util.ArrayList;

/**
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Account 
{

	private int accountId;
	protected double accountBalance;
	private double annualInterestRate;
	private java.util.Date dateCreated;
	private String customerName;
	private ArrayList < Transaction > transactions;
	
	public Account ( )
	{
		accountId = 0;
		accountBalance = 0.00;
		annualInterestRate = 0.0;
		dateCreated = new java.util.Date ( );
	} // end of default no arg-constructor
	
	public Account ( int accountId, double accountBalance )
	{
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	} // end of constructor with specified id and initial balance
	
	public Account ( String customerName, int accountId, double accountBalance )
	{
		this.customerName = customerName;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}

	// getters and setters
	public int getAccountId ( ) 
	{
		return accountId;
	}

	public void setAccountId ( int accountId ) 
	{
		this.accountId = accountId;
	}

	public double getAccountBalance ( ) 
	{
		return accountBalance;
	}

	public void setAccountBalance ( double accountBalance ) 
	{
		this.accountBalance = accountBalance;
	}

	public double getAnnualInterestRate ( ) 
	{
		return annualInterestRate / 100;
	}

	public void setAnnualInterestRate ( double annualInterestRate ) 
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	public java.util.Date getDateCreated ( ) 
	{
		return dateCreated;
	}
	
	public String getCustomerName ( ) 
	{
		return customerName;
	}

	public void setCustomerName ( String customerName ) 
	{
		this.customerName = customerName;
	}

	public double getMonthlyInterestRate ( )
	{
		double monthlyInterestRate = annualInterestRate / 12;
		return monthlyInterestRate;
	} // end of getMonthlyInterestRate
	
	public double getMonthlyInterest ( )
	{
		double monthlyInterest = accountBalance * ( getMonthlyInterestRate ( ) / 100 );
		return monthlyInterest;
	} // end of getMonthlyInterest
	// end of getters and setters
	
	public double withdraw ( double ammountWithdrawn )
	{
		accountBalance -= ammountWithdrawn;
		transactions = new ArrayList < > ( );
		transactions = new ArrayList < > ( );
		Transaction ta = new Transaction ( 'W', ammountWithdrawn, accountBalance );
		transactions.add( ta );
		if ( ta instanceof Transaction )
		{
			System.out.println ( ta.toString ( ) );
		} // end of if statement
		return accountBalance;
	} // end of withdraw
	
	public double deposit ( double ammountDeposited )
	{
		accountBalance += ammountDeposited;
		Transaction ta = new Transaction ( 'D', ammountDeposited, accountBalance);
		transactions.add( ta );
		if ( ta instanceof Transaction )
		{
			System.out.println ( ta.toString ( ) );
		} // end of if statement
		return accountBalance;
	} // end of deposit
	
	@Override
	public String toString ( ) 
	{
		return "Account: \n" + "AccountId: " + getAccountId ( ) + "\n" + "DateCreated: " + getDateCreated( ) + "\n" 
				+ "AccountBalance: $" + getAccountBalance ( ) + "\n" + "MonthlyInterest: $" + getMonthlyInterest ( );
	} // end of toString method
	
} // end of class Account
