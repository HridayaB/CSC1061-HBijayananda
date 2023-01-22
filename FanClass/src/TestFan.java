
public class TestFan 
{

	public static void main ( String [ ] args ) 
	{
		// TODO Auto-generated method stub

		Fan defaultFan = new Fan ( );
		System.out.println ( "Default Fan: " );
		System.out.println ( defaultFan.toString ( ) );
		
		Fan fan1 = new Fan ( );
		fan1.setSpeed ( 3 );
		fan1.setRadius ( 10.0 );
		fan1.setColor ( "yellow" );
		fan1.setOn ( true );
		fan1.idField ( 1 );
		System.out.println ( "Fan object 1: " );
		System.out.println ( fan1.toString ( ) );
		
		Fan fan2 = new Fan ( );
		fan2.setSpeed ( 2 );
		fan2.idField ( 2 );
		System.out.println ( "Fan object 2: " );
		System.out.println ( fan2.toString ( ) );
		
		
	} // end of main

} // end of TestFan
