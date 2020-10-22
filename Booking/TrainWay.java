package Booking;

/**
 * 
 * @author Dale Morrell
 *
 */

public class TrainWay extends TrainOperator // TrainOp subclass; Reserve seating arrangement for TrainWay booking system
{
	public TrainWay() // TrainWay super call
	{
		super("TrainWay");
	}

	// Books seat in First class; Finds seat matching user request; 
	// If not, books Window Economy seat. If no seat found booking can't be done.
	public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType) 
	{
		Seat attemptBooking = aJourney.seating.queryAvailableFirstClass(aType);

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

			// Books Window seat in Economy class
			Seat findSeat;
			Seat returnSeat;

			for (int xcount = aJourney.seating.firstClassRow; xcount < aJourney.seating.numberOfRows; xcount++) 
			{
				for (int ycount = 0; ycount < aJourney.seating.numberOfColumns; xcount++) 
				{
					findSeat = aJourney.seating.seats[xcount][ycount];

					if ((findSeat.seatType == SeatType.WINDOW) && (findSeat.reserved == false))
					{
						returnSeat = findSeat;
						returnSeat.reserved = true;
						return returnSeat;
					}
				}
			}
		}
		return null;
	}

	// Books seat in Economy class; Finds Seat matching request: if no seat found, book any window seat in first Class
	// If no seats at all then return null
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

		// Book A Window Seat In First Class
		Seat findSeat;
		Seat returnSeat;
		for (int xcount = aJourney.seating.firstClassRow; xcount < aJourney.seating.numberOfRows; xcount++) 
		{
			for (int ycount = 0; ycount < aJourney.seating.numberOfColumns; xcount++) 
			{
				findSeat = aJourney.seating.seats[xcount][ycount];

				if (findSeat.seatType == SeatType.WINDOW && findSeat.firstClass == false) 
				{
					returnSeat = findSeat;
					returnSeat.firstClass = true;
					return returnSeat;
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
