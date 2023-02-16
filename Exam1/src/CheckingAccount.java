import java.util.ArrayList;

/**
 * 
 * @author Hridaya Bijayananda
 *
 */
public class CheckingAccount extends Account
{

	private double overdraftLimit;
	private ArrayList < Transaction > transactions;

	
	public CheckingAccount ( )
	{
		overdraftLimit = 200.00;
	} // end of no-arg constructor
	
	public CheckingAccount ( double overdraftLimit )
	{
		this.overdraftLimit = overdraftLimit;
	} // end of constructor
	
	// getters and setters
	public double getOverdraftLimit ( ) 
	{
		return overdraftLimit;
	}

	public void setOverdraftLimit ( double overdraftLimit ) 
	{
		this.overdraftLimit = overdraftLimit;
	}
	// end of getters and setters
	
	@Override
	public double withdraw ( double ammountWithdrawn )
	{
		accountBalance -= ammountWithdrawn;
		if ( accountBalance < -getOverdraftLimit ( ) )
		{
			System.out.println ( "You cannot withdraw past the overdraft limit." );
			System.out.println ( "Withdrawl unsuccessful" );
		} // end of if statement
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
		transactions = new ArrayList < > ( );
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
		return "CheckingAccount: \n" + "AccountId: " + getAccountId ( ) + "\n" + "DateCreated: " + getDateCreated( ) + "\n" 
				+ "AccountBalance: $" + getAccountBalance ( ) + "\n" + "MonthlyInterest: $" + getMonthlyInterest ( ) + "\n" + "OverdraftLimit: $" + getOverdraftLimit ( );
	}
	
} // end of class CheckingAccount
