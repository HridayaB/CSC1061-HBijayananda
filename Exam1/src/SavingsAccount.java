import java.util.ArrayList;

/**
 * 
 * @author Hridaya Bijayananda
 *
 */
public class SavingsAccount extends Account
{
	
	private double overdrawn;
	private ArrayList < Transaction > transactions;

	
	public SavingsAccount ( )
	{
		overdrawn = 0.00;
	}
	
	public SavingsAccount ( double overdrawn)
	{
		this.overdrawn = overdrawn;
	}// end of constructor

	// getter and setter
	public double getOverdrawn ( ) 
	{
		return overdrawn;
	}

	public void setOverdrawn ( double overdrawn ) 
	{
		this.overdrawn = overdrawn;
	}
	// getter and setter
	
	@Override
	public double withdraw ( double ammountWithdrawn )
	{
		accountBalance -= ammountWithdrawn;	
		transactions = new ArrayList < > ( );
		Transaction ta = new Transaction ( 'W', ammountWithdrawn, accountBalance );
		transactions.add( ta );
		if ( ta instanceof Transaction )
		{
			System.out.println ( ta.toString ( ) );
		} // end of if statement
		return accountBalance;
	} // end of withdraw
	
	@Override
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
		return "SavingsAccount: \n" + "AccountId: " + getAccountId ( ) + "\n" + "DateCreated: " + getDateCreated( ) + "\n" 
				+ "AccountBalance: $" + getAccountBalance ( ) + "\n" + "MonthlyInterest: $" + getMonthlyInterest ( );
	}
} // end of class SavingAccount
