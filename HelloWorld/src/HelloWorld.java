

public class HelloWorld 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		System.out.println ( "Hello World!" );
		DateAndTime dateAndTimeNow = new DateAndTime ();
		System.out.println ( dateAndTimeNow.getDateCreated());
		System.out.println (dateAndTimeNow.getTimeCreated());
		System.out.println ( dateAndTimeNow.getDate());
		
		int x = 0;
		for (int i=0;i<10;i++)
		{
			x+=1;
		}
		System.out.println ( x );
		
	}

}
