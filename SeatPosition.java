package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class SeatPosition //Stores seatPosition & where the seat is located; Switch gives grid char text location
{
	private int row;
	private char col;

	public SeatPosition(int row, int col) 
	{
		setRow(row);
		setCol(col);
	}

	public int getRow() // Get and Set
	{
		return this.row;
	}

	public void setRow(int row) 
	{
		this.row = row + 1;
	}

	public char getCol() 
	{
		return this.col;
	}

	public void setCol(int col) // Column set using char-based identification
	{
		switch (col) 
		{
		case 0:
			this.col = 'A';
			break;
		case 1:
			this.col = 'B';
			break;
		case 2:
			this.col = 'C';
			break;
		case 3:
			this.col = 'D';
			break;
		case 4:
			this.col = 'E';
			break;
		case 5:
			this.col = 'F';
			break;
		case 6:
			this.col = 'G';
		}
	}

	public String toString() 
	{
		return "" + row + col;
	}
}
