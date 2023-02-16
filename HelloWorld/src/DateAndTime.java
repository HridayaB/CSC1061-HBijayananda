import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTime 
{
	private LocalDate dateCreated;
	private LocalTime timeCreated;
	private java.util.Date date;
	
	
	public DateAndTime ( )

	{
		dateCreated = LocalDate.now ( );
		timeCreated = LocalTime.now ( );
		date = new java.util.Date ( );
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalTime getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(LocalTime timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	

}
