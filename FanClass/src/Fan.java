
public class Fan 
{
	
	public final int SLOW = 1;
	public final int MEDIUM = 2;
	public final int FAST = 3;
	
	private int speed;
	private boolean on;
	private double radius;
	public String color;
	private static int id = 0;
	
	public Fan (int speed, boolean on, double radius, String color ) 
	{
		super();
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
	
	// end of getters and setters
	
//	public int idField ( int fanNum )
//	{
//		int idCounter = 0;
//		for ( int i = 0; i < fanNum; i++ )
//			idCounter++; 
//		this.id = idCounter;
//		return id;
//	} // end of idField
	
	public int getId ( )
	{
		return id;
	}
	
	// toString method
	@Override
	public String toString ( ) 
	{
		return "Fan: [speed = " + getSpeed ( ) + ", on = " +isOn ( ) + ", radius = " + getRadius ( ) + ", color = " + getColor ( ) + ", id = " + getId ( )
				+ "]";
	} // end of toString method
	
} // end of class Fan
