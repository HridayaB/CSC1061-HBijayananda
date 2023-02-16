import java.util.ArrayList;

/**
 * 
 * Tests the classes and prints the information
 * @author Hridaya Bijayananda
 *
 */
public class AccountDriver 
{

	public static void main ( String [ ] args ) 
	{
		// TODO Auto-generated method stub
		ArrayList < Transaction > transactions = new ArrayList < > ( );
		Account account = new Account ( );
		account.setAccountId ( 1122 );
		account.setAccountBalance( 20000.00 );
		account.setAnnualInterestRate ( 4.5 );
		
		account.withdraw ( 2500.00 );
		account.deposit ( 3000.00 );
		
		System.out.println ( account.toString ( ) + "\n" );
		
		CheckingAccount cAccount = new CheckingAccount ( );
		cAccount.setAccountId ( 2621 );
		cAccount.setAccountBalance( 800.00 );
		cAccount.setAnnualInterestRate ( 3.5 );
		cAccount.setOverdraftLimit ( 300.00 );
		
		cAccount.withdraw ( 1101.00 );
		cAccount.deposit ( 3000.00 );
		
		System.out.println ( cAccount.toString ( ) + "\n" );
		
		SavingsAccount sAccount = new SavingsAccount ( );
		sAccount.setAccountId ( 267 );
		sAccount.setAccountBalance( 30000.00 );
		sAccount.setAnnualInterestRate ( 5.5 );
		
		sAccount.withdraw ( 45500.00 );
		sAccount.deposit ( 300000.00 );
		
		System.out.println ( sAccount.toString ( ) + "\n" );
		
		CheckingAccount cAccount2 = new CheckingAccount ( );
		cAccount2.setAccountId ( 1122 );
		cAccount2.setAccountBalance( 1000.00 );
		cAccount2.setAnnualInterestRate ( 3.5 );
		cAccount2.setCustomerName ( "George" );
		cAccount2.setOverdraftLimit ( 300.00 );
		
		cAccount2.deposit ( 30.00 );
		cAccount2.deposit ( 40.00 );
		cAccount2.deposit ( 50.00 );
		cAccount2.withdraw ( 5.00 );
		cAccount2.withdraw ( 4.00 );
		cAccount2.withdraw ( 2.00 );

		System.out.println ( cAccount.toString ( ) + "\n" );
	} // end of main

} // end of driver class AccountDriver
