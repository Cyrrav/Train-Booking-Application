package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public abstract class TrainOperator // Abstract class: Stores Train Operator details, contains bookFirstClass & bookEconomyClass public abstract objects
{
	protected String trainOperatorName; // Variable

	public String getTrainOperatorName() // Getter and Setter
	{
		return trainOperatorName;
	}

	public void setTrainOperatorName(String trainOperatorName) 
	{
		this.trainOperatorName = trainOperatorName;
	}

	public TrainOperator(String trainOperatorName) 
	{
		setTrainOperatorName(trainOperatorName);
	}

	public abstract Seat reserveFirstClass(TrainJourney aJourney, SeatType aType); // More abstract
	public abstract Seat reserveEconomyClass(TrainJourney aJourney, SeatType aType);

	public String toString() 
	{
		String description;
		description = ("Welcome to the " + trainOperatorName + " Booking System; Which journey would you like to book a trip on?");
		return description;
	}
}
