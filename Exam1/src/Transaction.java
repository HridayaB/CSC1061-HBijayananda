/**
 * 
 * @author Hridaya Bijayananda
 *
 */
public class Transaction 
{
	private java.util.Date transactionDate;
	private char transactionType;
	private double transactionAmount;
	private double newBalance;
	
	public Transaction ( )
	{
		transactionDate = new java.util.Date ( );
		transactionType = 'W';
		transactionAmount = 0;
		newBalance = 0;
	} // end of constructor
	
	public Transaction ( char transactionType, double transactionAmount, double newBalance )
	{
		transactionDate = new java.util.Date ( );
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.newBalance = newBalance;
	} // end of constructor

	// getters and setters
	public java.util.Date getTransactionDate ( ) 
	{
		return transactionDate;
	}

	public void setTransactionDate ( java.util.Date transactionDate ) 
	{
		this.transactionDate = transactionDate;
	}

	public char getTransactionType ( ) 
	{
		return transactionType;
	}

	public void setTransactionType ( char transactionType ) 
	{
		this.transactionType = transactionType;
	}

	public double getTransactionAmount ( ) 
	{
		return transactionAmount;
	}

	public void setTransactionAmount ( double transactionAmount ) 
	{
		this.transactionAmount = transactionAmount;
	}

	public double getNewBalance ( ) 
	{
		return newBalance;
	}

	public void setNewBalance ( double newBalance ) 
	{
		this.newBalance = newBalance;
	}
	// end of getters and setters
	
	@Override
    public String toString ( ) 
	{
        return "Transaction: " + "Date Transacted: " + getTransactionDate ( ) + ", TransactionType: " + getTransactionType ( )
                + ", Transaction Amount: $" + getTransactionAmount ( ) + ", New Balance: $" + getNewBalance ( );
    } // end of toString method
	
} // end of class Transaction
