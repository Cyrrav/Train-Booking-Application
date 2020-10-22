package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class GrandeFloorGrid extends FloorGrid // Extends floor grid, forms first train grid; Predefined variables for Rows, Columns, First class rows
{

	// Holds instance variables; Uses a for loop to instantiate seat objects, fills every seat
	public GrandeFloorGrid() 
	{
		this.numberOfRows = 12; // Hard-Coded
		this.numberOfColumns = 9;
		this.firstClassRow = 6;

		this.seats = new Seat[numberOfRows][numberOfColumns];

		for (int xcount = 0; xcount < numberOfRows; xcount++) 
		{
			for (int ycount = 0; ycount < numberOfColumns; ycount++) 
			{
				seats[xcount][ycount] = new Seat(xcount, ycount);
			}
		}
		initialiseFloorGrid();
	}

	// Populates 2D Array, determines if class is first or economy class
	
	public void initialiseFloorGrid() 
	{
		for (int xcount = 0; xcount < numberOfRows; xcount++) 
		{
			for (int ycount = 0; ycount < numberOfColumns; ycount++) 
			{
				if (xcount < firstClassRow) 
				{
					this.seats[xcount][ycount].firstClass = true;
				}

				else 
				{
					this.seats[xcount][ycount].firstClass = false;
				}

				if ((ycount == 0) || (ycount == 8))
				{
					this.seats[xcount][ycount].seatType = SeatType.WINDOW;
				} 
				
				else if ((ycount == 2) || (ycount == 3) || (ycount == 5) || (ycount == 6))
				{
					this.seats[xcount][ycount].seatType = SeatType.AISLE;
				} 
				
				else if ((ycount == 1) || (ycount == 4) || (ycount == 7))
				{
					this.seats[xcount][ycount].seatType = SeatType.MIDDLE;
				}
			}
		}
	}

	public String toString() 
	{
		return ("   A      B      C      D      E      F      G      H      I\n" + super.toString());
	}
}
