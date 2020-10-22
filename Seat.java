package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class Seat // Holds details for reserved/unreserved seat using protected objects & variables
{
	// Stuff for Seat Position
	protected int row;
	protected int column;
	protected boolean reserved;
	protected boolean firstClass;
	protected SeatPosition seatPosition;
	protected SeatType seatType;

	public Seat(int row, int col) // seatPosition filled with rows and columns
	{
		this.row = row;
		this.column = col;
		seatPosition = new SeatPosition(row, col);
	}

	public String toString() 
	{
		String representation = " ";
		String type = null;

		switch (seatType) 
		{
		case AISLE:
			type = "A";
			break;

		case MIDDLE:
			type = "M";
			break;
			
		case WINDOW:
			type = "W";
			break;
		}
		
		if (firstClass == true) 
		{
			type = type.toUpperCase();
		}

		if (reserved == true) 
		{
			representation = (" [" + type + " X]");
		}

		else 
		{
			representation = (" [" + type + "  ]");
		}

		return representation;
	}

	public String seatDesc() // Seat description
	{
		String output = " ";

		if (firstClass = true) 
		{
			output = ("First-Class Seat");
		}

		else 
		{
			output = ("Economy-Class Seat");
		}

		switch (seatType) 
		{
		case AISLE:
			output = ("Aisle Seat Location: ");
			break;
		case MIDDLE:
			output = ("Middle Seat Location: ");
			break;
		case WINDOW:
			output = ("Window Seat Location: ");
			break;
		}

		if (reserved == true) 
		{
			output = (output + seatPosition + " is currently Booked");
		} 
		
		else if (reserved == false)
		{
			output = (output + seatPosition + " is currently not Booked");
		}

		return output;
	}
}
