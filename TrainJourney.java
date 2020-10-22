package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class TrainJourney // Stores Source/Dest. City, End Time, Departure time, Journey number, floorGrid object get and set methods
{
	protected String sourceCity; // Initialize default variables
	protected String destCity;
	protected String departureTime;
	protected String journeyNumber;
	protected FloorGrid seating; // Floor Grid Object

	public TrainJourney() // Construct
	{
		sourceCity = "";
		destCity = "";
		departureTime = "";
		journeyNumber = "";
	}

	public TrainJourney(String startcity, String endcity, String departuretime, String journeynumber) 
	{
		this.sourceCity = startcity;
		this.destCity = endcity;
		this.departureTime = departuretime;
		this.journeyNumber = journeynumber;
	}

	public String getStartCity() // Getters
	{
		return sourceCity;
	}

	public String getEndCity() 
	{
		return destCity;
	}

	public String getDeparturetime() 
	{
		return departureTime;
	}

	public String getJourneynumber() 
	{
		return journeyNumber;
	}

	public FloorGrid getFloorGrid() 
	{
		return this.seating;
	}

	public String toString() 
	{
		return journeyNumber + " from: " + sourceCity + " to: " + destCity + " at: " + departureTime;
	}
}
