package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

// Methods contained in class: Left Seat, Right Seat, Last Row, Last Column
// Class also contains: two dimensional Seating Array
public abstract class FloorGrid 
{
	// INitialize Number Of Rows
	// Initialize Matrix
	protected int numberOfRows;
	protected int numberOfColumns;
	protected int firstClassRow;

	// 2D Array for Seats/Seating OBjects
	protected Seat[][] seats;

	// Abstract
	abstract void initialiseFloorGrid();

	// Get number of rows
	public int getLastRow() 
	{
		return numberOfRows;
	}

	// returns Last Column in Seating Positions
	public char getLastCol() 
	{
		SeatPosition lastSeat = new SeatPosition(numberOfRows - 1, numberOfColumns - 1);
		char lastColumn;
		lastColumn = lastSeat.getCol();
		return lastColumn;
	}

	// Seat Select
	public Seat getSeat(int row, char column) 
	{
		Seat seat = new Seat(row, column);
		return seat;
	}

	public Seat getLeft(Seat seatPosition) 
	{
		if (seatPosition.column > 0) 
		{
			Seat leftSeat = seats[seatPosition.row][seatPosition.column - 1];

			if ((leftSeat.reserved == true) || (leftSeat.column == 0))
			{
				return null;
			} 
			else 
			{
				return leftSeat;
			}
		} 
		
		else 
		{
			return null;
		}
	}

	public Seat getRight(Seat seatPosition) 
	{
		if (seatPosition.column < numberOfRows - 1) 
		{
			Seat rightSeat = seats[seatPosition.row][seatPosition.column + 1];

			if ((rightSeat.reserved == true) || (rightSeat.column == numberOfColumns - 1))
			{
				return null;
			}

			else 
			{
				return rightSeat;
			}
		} 
		
		else 
		{
			return null;
		}
	}
	
	// Gets Seat (2D) Array, Iterates through entire 2D array, Returns a Seat Location
	// THen queries Economy Class; If Seat doesn't match, pick random/any economy seat if all other seats are booked
	// then the method returns null
	
	public Seat queryAvailableEconomyClass(SeatType type) 
	{
		for (int xcount = firstClassRow; xcount < numberOfRows; xcount++) 
		{
			for (int ycount = 0; ycount < numberOfColumns; ycount++) 
			{
				if ((this.seats[xcount][ycount].seatType == type) && (this.seats[xcount][ycount].firstClass == false) && (this.seats[xcount][ycount].reserved == false)) 
				{
					this.seats[xcount][ycount].reserved = true;
					return this.seats[xcount][ycount];
				}
			}
		}

		for (int xcount = firstClassRow; xcount < numberOfRows; xcount++) 
		{
			for (int ycount = 0; ycount < numberOfColumns; ycount++) 
			{
				if ((this.seats[xcount][ycount].firstClass == false) && (this.seats[xcount][ycount].reserved == false)) 
				{
					this.seats[xcount][ycount].reserved = true;
					return this.seats[xcount][ycount];
				}
			}
		}
		return null;
	}

	// Grabs and iterates through a 2D array where the method will return a seat location
	// Query the first class, if seat doesn't match: randomly pick any economy-class seat
	// If all seats booked, return null

	public Seat queryAvailableFirstClass(SeatType type) 
	{
		for (int xcounter = 0; xcounter < firstClassRow; xcounter++) 
		{
			for (int ycounter = 0; ycounter < numberOfColumns; ycounter++) 
			{
				if ((this.seats[xcounter][ycounter].seatType == type) && (this.seats[xcounter][ycounter].firstClass == true) && (this.seats[xcounter][ycounter].reserved == false))
				{
					this.seats[xcounter][ycounter].reserved = true;
					return this.seats[xcounter][ycounter];
				}
			}
		}

		for (int xcounter = 0; xcounter < firstClassRow; xcounter++) 
		{
			for (int ycounter = 0; ycounter < numberOfColumns; ycounter++) 
			{
				if ((this.seats[xcounter][ycounter].firstClass == true) && (this.seats[xcounter][ycounter].reserved == false))
				{
					this.seats[xcounter][ycounter].reserved = true;
					return this.seats[xcounter][ycounter];
				}
			}
		}
		return null;
	}

	// toString returning seating results
	
	public String toString() 
	{
		{
			String results = "";
			for (Seat[] rows : seats) 
			{
				for (Seat s : rows) 
				{
					results += s + " ";
				}
				
				results += "\n";
			}
			
			return results;
		}
	}
}
