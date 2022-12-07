/*  CSCI 101 / 7380
 *  November 6 2022
 *  
 *  A program that asks for the users weight, and the size of the bathtub they wish to bathe in.
 *  Assuming the user is bathing in a vacuum, the program then tells them the equivalent number of calories in carrots
 *  that they must eat to reach have the water reach thermal equilibrium with their body temperature.
 * 
 */
import java.util.Scanner;
public class FinehoutIsaac_Discussion3_HeatTransfer {
	
	public static void main(String[] args) {
		Scanner scandouble = new Scanner(System.in);
		Scanner scanstr = new Scanner(System.in);
		boolean programRunning = true;
		boolean errorCatching = true;
		double weight;
		double[] joulesCaloriesCarrots = new double[3];

		

		
		
		printDisclaimer();
		while (programRunning) {
			System.out.println("How many kg of water is your bath?\n");
			weight = getWeight(errorCatching , scandouble);
			joulesCaloriesCarrots = getJoulesCaloriesCarrots(weight);
			System.out.printf("It would take %.2f joules, %.2f calories, or %.2f carrots to raise %.2f kg of water 6.6 C.\n"
					, joulesCaloriesCarrots[0] , joulesCaloriesCarrots[1] , joulesCaloriesCarrots[2] , weight);
			System.out.println("Enter another weight? (y/n)");
			programRunning = getMenuOption(errorCatching , programRunning , scanstr);
			
		}
		scanstr.close();
		scandouble.close();

	}
	
	
	
	
	
	public static void printDisclaimer() {
		
		System.out.println("The following values are used to calculate the amount of carrots one must consume for their cold bath to\n"
				+ "reach thermal equilibrium with their body temperature:\n"
				+ "Specific heat of water:                2931 J/(kg * C)\n"
				+ "Average temperature of the human body: 36.61 C\n"
				+ "Temperature of a cold bath:            30.00 C\n"
				+ "Amount of Joules required to raise bath water temperature to human body temperature: \n"
				+ "Q = userInput * 2931 J/(kg * C) * 6.61 C\n"
				+ "Convert Q to calories:\n"
				+ "C = Q / 4180\n"
				+ "Convert from calories to carrots:\n"
				+ "Carrots = C / 25\n\n");
	}
	
	
	
	
	
	
	public static double getWeight(boolean errorCatching , Scanner scandouble) {
		double weight = 0;
		
		while (errorCatching) {

			while(!scandouble.hasNextDouble()) {
				String error = scandouble.next();
				System.err.println(error + " is not a weight between 30kg - 100kg");
				System.out.println("Please enter a weight between 30kg - 100kg");
			} weight = scandouble.nextDouble();
			
			if (weight < 30 || weight > 100) {
				System.err.println(weight + " is not a weight between 30kg - 100kg");
				System.out.println("Please enter a weight between 30kg - 100kg");
			} else {
				errorCatching = false;
			}
			
		}
		return weight;
	}
	
	
	
	
	
	public static double[] getJoulesCaloriesCarrots(double weight) {
		double[] joulesCaloriesCarrots = new double[3];
		double Qwater;
		double calories;
		double carrots;
		
		
		Qwater = weight * 2931 * 6.61;
		calories = Qwater / 4180;
		carrots = calories / 25;
		
		joulesCaloriesCarrots[0] = Qwater;
		joulesCaloriesCarrots[1] = calories;
		joulesCaloriesCarrots[2] = carrots;
		
		return joulesCaloriesCarrots;
	}
	
	
	
	
	
	public static boolean getMenuOption(boolean errorCatching , boolean programRunning , Scanner scanstr) {
		String menuOption;
		menuOption = scanstr.nextLine().toLowerCase();
		
		while ((!(menuOption.charAt(0) == 'y')) && (!(menuOption.charAt(0) == 'n'))) {
			System.err.println(menuOption + " is not a yes or no answer.");
			System.out.println("Please enter a yes or no answer");
			menuOption = scanstr.nextLine();
		}
		
		if (menuOption.charAt(0) == 'n') {
			programRunning = false;
		}
		
		return programRunning;
	}

}
