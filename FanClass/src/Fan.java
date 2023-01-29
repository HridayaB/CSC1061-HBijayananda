
public class Fan 
{
	
	public final int SLOW = 1; // fan speed
	public final int MEDIUM = 2; // fan speed
	public final int FAST = 3; // fan speed
	
	private int speed;
	private boolean on; // fan status
	private double radius; // fan radius
	public String color; // fan color
	private int id; // fan id
	private static int nextId = 0; // the id for the next fan
	
	public Fan (int speed, boolean on, double radius, String color ) 
	{
		super ( );
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
		id = nextId++;
	}
	
	// default no arg constructor
	public Fan ( )
	{
		speed = SLOW;
		on = false;
		radius = 5.0;
		color = "blue";
		id = nextId++;
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
		if ( on ) // testing if the fan is on or off
		{
			return "Fan: [ speed = " + getSpeed ( ) + ", on = " +isOn ( ) + ", radius = " + getRadius ( ) + ", color = " + getColor ( ) + ", id = " + getId ( )
			+ " ]";
		}
		else 
		{
			return "Fan: [ fan is off " + ", radius = " + getRadius ( ) + ", color = " + getColor ( ) + ", id = " + getId ( )
			+ " ]";
		}
	} // end of toString method
	
} // end of class Fan
