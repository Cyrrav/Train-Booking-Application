package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class PetiteFloorGrid extends FloorGrid // Forms second train grid, extending floor grid; Predefined variables for Rows, Columns, FirstClass rows.
{
	public PetiteFloorGrid() // Holds Instance Variables; Uses a for loop to instantiate seat object, filling every seat
	{
		this.numberOfRows = 10; // Hard-coded
		this.numberOfColumns = 7;
		this.firstClassRow = 4;
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

	public void initialiseFloorGrid() // Populates 2D array; First or not-first class determiner
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

				if ((ycount == 0) || (ycount == 6))
				{
					this.seats[xcount][ycount].seatType = SeatType.WINDOW;
				} 
				
				else if ((ycount == 1) || (ycount == 2) || (ycount == 4) || (ycount == 5))
				{
					this.seats[xcount][ycount].seatType = SeatType.AISLE;
				} 
				
				else if (ycount == 3) 
				{
					this.seats[xcount][ycount].seatType = SeatType.MIDDLE;
				}
			}
		}
	}

	public String toString() 
	{
		return ("   A      B      C      D      E      F      G\n" + super.toString());
	}
}
