import java.util.Scanner;

public class AirlineReservations {
	
	//create a static scanner object for the class
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//create an integer to store the seat assignment
		int seatAssignment = 0;
		
		//create the count to loop through the seats in the plane while prompting the user
		int count = 0;
		
		//create the boolean array to represent the seating chart of the plane, all elements are
		//equal to false by default, once an element is set to true, the seat is no longer available
		boolean[] seatChart = new boolean[11];
	
		
		while(count < seatChart.length)
		{
			//prompt the user to enter 1 or 2 and read the input
			System.out.print("Please type 1 for First Class, or please type 2 for Economy: ");
			int seatType = input.nextInt();
			
			//if user types 1, first class. Else if user types 2, economy
			if(seatType == 1)
			{	
				firstClass(seatChart);				
			}
			else if(seatType == 2)
			{
				economyClass(seatChart);
			}
			
	
			//increment count
			count++;
			
			//print two blank line for readability
			System.out.println();
			System.out.println();
			
		}	//end while
		
	}	//end main
	
	
	//create firstClass method
	public static void firstClass(boolean[] seatingChart) {
		
		for(int counter = 1; counter <= seatingChart.length - 5; counter++)
		{
			if(seatingChart[counter] == false)
			{
				seatingChart[counter] = true;
				displayBoardingPass(counter);
				break;
			}
			else if(seatingChart[5] == true)
			{
				if(seatingChart[10] == true)
				{
					System.out.printf("%n%s", "Next flight leaves in 3 hours...");
					System.exit(0);
				}
				else
				{
					System.out.print("\nFirst Class is booked. Would you like to sit in Economy? (1 for yes, 2 for no): ");
					int answer = input.nextInt();
					
					//if yes, call the economy method
					if(answer == 1)
					{
						economyClass(seatingChart);
						break;
					}
					else
					{
						System.out.printf("%n%s", "Next flight leaves in 3 hours...");
						System.exit(0);
					}
					
					//if no, break out the loop, and display a message "Next flight leaves in 3 hours".
					
				}	
			}
		}
		
		
	}
	
	//create economy method
	public static void economyClass(boolean[] seatingChart) {
		
		for(int counter = 6; counter < seatingChart.length; counter++)
		{
			if(seatingChart[counter] == false)
			{
				seatingChart[counter] = true;
				displayBoardingPass(counter);
				break;
			}
			else if(seatingChart[10] == true)
			{
				if(seatingChart[5] == true)
				{
					System.out.printf("%n%s", "Next flight leaves in 3 hours...");
					System.exit(0);
				}
				else
				{
					System.out.print("Economy is booked. Would you like to sit in first class? (1 for yes, 2 for no): ");
					int answer = input.nextInt();
					
					//if yes, call the firstClass method
					if(answer == 1)
					{
						firstClass(seatingChart);
						//break;
					}
					else
					{
						System.out.printf("%n%s", "Next flight leaves in 3 hours...");
						System.exit(0);	
					}
					//if no, break out the loop, and display a message "Next flight leaves in 3 hours".
					
				}
			}
		}
		
		
	}
	
	
	public static void displayBoardingPass(int seatNum)
	{
		//display the boarding pass header
		System.out.printf("%n%s%n", "Boarding Pass:");
		
		if(seatNum >= 1 && seatNum <=5)
		{
			System.out.printf("%18s%n%20s%d", "First Class", "Seat Number: ", seatNum);
		}
		else if(seatNum >= 6 && seatNum <= 10)
		{
			System.out.printf("%4s%n%4s%d", "Economy", "Seat Number: ", seatNum);
		}
		
	}	//end method displayBoardingPass

	
}	//end class AirlineReservations
