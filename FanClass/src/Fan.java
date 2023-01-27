
public class Fan 
{
	
	public final int SLOW = 1; // fan speed
	public final int MEDIUM = 2; // fan speed
	public final int FAST = 3; // fan speed
	
	private int speed;
	private boolean on; // fan status
	private double radius; // fan radius
	public String color; // fan color
	private static int id = 0; // fan id
	
	public Fan (int speed, boolean on, double radius, String color ) 
	{
		super ( );
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
		id++;
	}
	
	// default no arg constructor
	public Fan ( )
	{
		speed = SLOW;
		on = false;
		radius = 5.0;
		color = "blue";
		id = 1;
	} // end of default no arg constructor

	// getters and setters
	public int getSpeed ( ) 
	{
		return speed;
	}

	public void setSpeed ( int speed ) 
	{
		this.speed = speed;
	}

	public boolean isOn ( ) 
	{
		return on;
	}

	public void setOn ( boolean on ) 
	{
		this.on = on;
	}

	public double getRadius ( ) 
	{
		return radius;
	}

	public void setRadius ( double radius ) 
	{
		this.radius = radius;
	}

	public String getColor ( ) 
	{
		return color;
	}

	public void setColor ( String color ) 
	{
		this.color = color;
	}
	
	public int getId ( )
	{
		return id;
	}
	
	// end of getters and setters
	
	// toString method
	@Override
	public String toString ( ) 
	{
		return "Fan: [ speed = " + getSpeed ( ) + ", on = " +isOn ( ) + ", radius = " + getRadius ( ) + ", color = " + getColor ( ) + ", id = " + getId ( )
				+ " ]";
	} // end of toString method
	
} // end of class Fan
