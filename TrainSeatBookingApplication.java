package Booking;
import java.util.Scanner;

/**
 * 
 * @author Dale Morrell
 *
 */

// Application for two difference Train Services' Seat Booking System
// Contains main method with user interaction, outputs FloorGrid, Seat and Journey details
public class TrainSeatBookingApplication 
{
	public static void printSeating() // Prints seating map; Queries user for seat selection
	{
		System.out.println("Which Seat Type?");
		System.out.println("1.) Aisle Seat");
		System.out.println("2.) Middle Seat");
		System.out.println("3.) Window Seat");
	}

	public static void printMenu() // Prints booking menu for each seating class, Displays Floor Grid or Exits program
	{
		System.out.println("1.) Book First Class");
		System.out.println("2.) Book Economy Class");
		System.out.println("3.) Show Floor Grid");
		System.out.println("4.) Exit Program");
	}

	public static void main(String[] args) // Main Method, interaction between program and user
	{
		String choiceOne = "1"; // Hard-coded Initialize
		String choiceTwo = "2";
		String choiceThree = "3";
		String choiceFour = "4";

		TrainOperator actualJourney = null;
		FloorGrid seatingGrid = null;
		boolean quitProgram = false;

		TrainJourney newJourney = new TrainJourney(); // Initialize Journeys
		TrainJourney journeyOne = new TrainJourney("Otemachi, Tokyo Central", "Ueno, Tokyo East", "16:00", "ZTS08, Shinkansen Transit");
		TrainJourney journeyTwo = new TrainJourney("Berlin, Germany", "Paris, France", "20:00", "EURO73, Central European Line");
		
		System.out.println("Which Train Service Operator would you like to book a trip with?"); // Query
		String userInput = " ";
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1.) TrainWay");
		System.out.println("2.) TrainSmart");
		userInput = keyboard.nextLine();

		if (userInput.equals(choiceOne)) 
		{
			actualJourney = new TrainWay();
			System.out.println("Menu Item: 1.) Selected");
		}

		if (userInput.equals(choiceTwo)) 
		{
			actualJourney = new TrainSmart();
			System.out.println("Menu Item: 2.) Selected");
		}

		System.out.println(actualJourney);
		System.out.println("1.) " + journeyOne);
		System.out.println("2.) " + journeyTwo);
		userInput = keyboard.nextLine();

		if (userInput.equals(choiceOne)) 
		{
			System.out.println("Menu Item: 1.) Selected");
			newJourney = journeyOne;
			seatingGrid = new GrandeFloorGrid();
		}

		if (userInput.equals(choiceTwo)) 
		{
			newJourney = journeyTwo;
			seatingGrid = new PetiteFloorGrid();
		}
		System.out.println(newJourney + "\n");
		System.out.println(seatingGrid);

		newJourney.seating = seatingGrid;

		while (quitProgram == false) // Loop
		{
			SeatType type = SeatType.AISLE;
			printMenu();
			userInput = keyboard.nextLine();
			String userChoice = null;

			if (userInput.equals(choiceOne)) // String Compare
			{
				userChoice = userInput;
			}

			else if (userInput.equals(choiceTwo)) // String Compare
			{
				userChoice = userInput;
			}

			else if (userInput.equals(choiceThree)) // String Compare
			{
				userChoice = userInput;
				System.out.println(newJourney.seating);
			}

			else if (userInput.equals(choiceFour)) // String Compare
			{
				System.exit(0);
			}

			if (userChoice.equals(choiceThree) == false) 
			{
				printSeating();
				userInput = keyboard.nextLine();

				if (userInput.equals(choiceOne)) 
				{
					type = SeatType.AISLE;
				}

				else if (userInput.equals(choiceTwo)) // String Compare
				{
					type = SeatType.MIDDLE;
				}

				else if (userInput.equals(choiceThree)) // String Compare
				{
					type = SeatType.WINDOW;
				}

				if (userChoice.equals(choiceOne)) // String Compare
				{
					Seat bookSeat = actualJourney.reserveFirstClass(newJourney, type);
					System.out.println(newJourney.seating);
					System.out.println(bookSeat.seatDesc());
				}

				else if (userChoice.equals(choiceTwo)) // String Compare
				{
					Seat bookSeat = actualJourney.reserveEconomyClass(newJourney, type);
					System.out.println(newJourney.seating);
					System.out.println(bookSeat.seatDesc());
				}

				else if (userChoice.equals(choiceThree)) // String Compare
				{
					System.out.println(newJourney.seating);
				}

				else if (userChoice.equals(choiceFour)) // String Compare
				{
					System.exit(0); // Quit
				}
			}
		}
	}
}
