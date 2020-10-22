package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class TrainSmart extends TrainOperator // TrainOp subclass: Reserve seating arrangement for TrainSmart booking system
{
	public TrainSmart() // Calls "TrainSmart" super
	{
		super("TrainSmart");
	}
	
	// Finds seat matching request; If no first class seat with the same type matches, book entire economy row.
	// If no seats can be booked, null returned.
	public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType) 
	{
		Seat attemptBooking = aJourney.seating.queryAvailableFirstClass(aType);
		Seat findSeat;
		Seat left;
		Seat right;
		Seat returnedSeat;
		
		if (attemptBooking != null) 
		{
			return attemptBooking;
		}

		for (int xcount = aJourney.seating.firstClassRow; xcount < aJourney.seating.numberOfRows; xcount++) 
		{
			for (int ycount = 0; ycount < aJourney.seating.numberOfColumns; ycount++) 
			{
				findSeat = aJourney.seating.seats[xcount][ycount];
				
				if ((findSeat.seatType == SeatType.MIDDLE) && (findSeat.reserved == false)) 
				{
					if (aJourney.seating.getLeft(findSeat) != null) // Left Side
					{
						left = aJourney.seating.getLeft(findSeat);
						returnedSeat = findSeat;
						left.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}
					
					if (aJourney.seating.getRight(findSeat) != null) // Right Side
					{
						right = aJourney.seating.getRight(findSeat);
						returnedSeat = findSeat;
						right.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}
				}
				
				if ((findSeat.seatType == SeatType.WINDOW) && (findSeat.reserved == false))
				{
					if (aJourney.seating.getLeft(findSeat) != null) // Left Side
					{
						left = aJourney.seating.getLeft(findSeat);
						returnedSeat = findSeat;
						left.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}

					if (aJourney.seating.getRight(findSeat) != null) // Right Side
					{
						right = aJourney.seating.getRight(findSeat);
						returnedSeat = findSeat;
						right.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}
				}

				if ((findSeat.seatType == SeatType.AISLE) && (findSeat.reserved == false))
				{
					if (aJourney.seating.getLeft(findSeat) != null) // Left Side
					{
						left = aJourney.seating.getLeft(findSeat);
						returnedSeat = findSeat;
						left.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}

					if (aJourney.seating.getRight(findSeat) != null) // Right Side
					{
						right = aJourney.seating.getRight(findSeat);
						returnedSeat = findSeat;
						right.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}
				}
			}
		}
		return null;
	}
	
	// Books Economy Seat; If no seats match request requirements, booking can't be made
	public Seat reserveEconomyClass(TrainJourney aJourney, SeatType aType)
	{
		Seat attemptBooking = aJourney.seating.queryAvailableEconomyClass(aType);

		if (attemptBooking != null) 
		{
			return attemptBooking;
		}

		else 
		{
			for (int xcount = aJourney.seating.firstClassRow; xcount < aJourney.seating.numberOfRows; xcount++) 
			{
				for (int ycount = 0; ycount < aJourney.seating.numberOfColumns; ycount++) 
				{
					if (aJourney.seating.seats[xcount][ycount].reserved == false) 
					{
						return aJourney.seating.seats[xcount][ycount];
					}
				}
			}
		}
		return null;
	}

	public String toString() 
	{
		return super.toString();
	}
}
