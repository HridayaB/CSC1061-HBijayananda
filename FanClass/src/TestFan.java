
public class TestFan 
{

	public static void main ( String [ ] args ) 
	{
		// TODO Auto-generated method stub

		Fan fanSpeed = new Fan ( );
		Fan defaultFan = new Fan ( );
		System.out.println ( "Default Fan: " );
		System.out.println ( defaultFan.toString ( ) );
		
		Fan fan1 = new Fan ( fanSpeed.FAST, true, 10.0, "yellow" );
		System.out.println ( "Fan object 1: " );
		System.out.println ( fan1.toString ( ) );
		
		Fan fan2 = new Fan ( fanSpeed.MEDIUM, false, 5.0, "blue" );
		System.out.println ( "Fan object 2: " ); 
		System.out.println ( fan2.toString ( ) );
		
	} // end of main

} // end of TestFan
