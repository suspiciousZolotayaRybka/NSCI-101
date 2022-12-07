/**Author:
 * NSCI 101 / 7380
 * Date: 10/23/2022
 * A program that calculates the dynamic equilibrium for two cars in a head-on car crash,
 * with a max speed of 100kph and a max weight of 1800kg
 * 
 */
import java.util.Scanner;
public class Discussion1_DynamicEquilibrium {

	public static void main(String[] args) {
		
		//Declaring Variables
		int menuOption;
		double weight1 = 0;
		double weight2 = 0;
		double velocity1 = 0;
		double velocity2 = 0;
		
		Scanner scanint = new Scanner(System.in);
		Scanner scandouble = new Scanner(System.in);
		
		System.out.println("***** ********/t/t/t NSCI 101 / 7380\t\t\t23 October 2022\n\n\n\n\nAll values are approximate to the nearest hundredth\n");
		
		boolean programRunning = true;
		boolean errorCatching;
		
		
		
		
		//Menu option
		while (programRunning) {
			System.out.println("Choose a value to enter, or quit the program.\n"
					+ "1 - Mass (converted to weight in kg on Earth)\n"
					+ "2 - Velocity\n"
					+ "3 - Quit\n"
					+ "=> ");
			
			while (!scanint.hasNextInt()) {
				String error = scanint.next();
				System.err.println(error + " is not an integer between 1-3");
				System.out.println("Choose a value to enter, or quit the program.\n"
						+ "1 - Mass (converted to weight in kg on Earth)\n"
						+ "2 - Velocity\n"
						+ "3 - Quit\n"
						+ "=> ");
			} menuOption = scanint.nextInt();
		
		
		
		
		
			//Solving for Velocity
			if (menuOption == 1) {
				System.out.print("Enter weight one in kilograms on Earth:\n"
						+ "=>");
				
				//Weight 1
				errorCatching = true;
				while (errorCatching) {
					while (!scandouble.hasNextDouble()) {
						String error = scandouble.next();
						System.err.println(error + " is not a weight between 900 - 1800 kg.");
						System.out.print("Enter weight 1 one in kilograms on Earth:\n"
								+ "=>");
					} weight1 = scandouble.nextDouble();
					
					if (weight1 < 900 || weight1 > 1800) {
						System.err.println(weight1 + " is not a weight between 900 - 1800 kg.");
						System.out.print("Enter weight one in kilograms on Earth:\n"
								+ "=>");
					} else {
						errorCatching = false;
					}
				}
				
				//Weight 2
				System.out.print("Enter weight two in kilograms on Earth:\n"
						+ "=> ");
				errorCatching = true;
				while (errorCatching) {
					while (!scandouble.hasNextDouble()) {
						String error = scandouble.next();
						System.err.println(error + " is not a weight between 900 - 1800 kg.");
						System.out.print("Enter weight two in kilograms on Earth:\n"
								+ "=>");
					} weight2 = scandouble.nextDouble();
					
					if (weight2 < 900 || weight2 > 1800) {
						System.err.println(weight2 + " is not a weight between 900 - 1800 kg.");
						System.out.print("Enter weight two in kilograms on Earth:\n"
								+ "=>");
					} else {
						errorCatching = false;
					}
				}
				
				//Solving for velocity
				double totalWeight = weight1 + weight2;
				velocity1 = (weight2 / totalWeight) * 100;
				velocity2 = (weight1 / totalWeight) * 100;
				
			}
			
			
			
			
			//Solving for weight
			if (menuOption == 2) {
				
				//Velocity 1
				System.out.println("Enter velocity one as kilometers per hour:\n"
						+ "=> ");
				errorCatching = true;
				while (errorCatching) {
					while (!scandouble.hasNextDouble()) {
						String error = scandouble.next();
						System.err.println(error + " is not a velocity between 33 - 100 kph.");
						System.out.print("Enter velocity one as kilometers per hour:\n"
								+ "=> ");
					} velocity1 = scandouble.nextDouble();
					
					if (velocity1 < 33 || velocity1 > 100) {
						System.err.println(velocity1 + " is not a velocity between 33 - 100 kph.\n");
						System.out.print("Enter velocity one as kilometers per hour:\n"
								+ "=> ");
					} else {
						errorCatching = false;
					}
				}
				
				//Velocity 2
				System.out.println("Enter velocity two as kilometers per hour: "
						+ "=> ");
				
				errorCatching = true;
				while (errorCatching) {
					while (!scandouble.hasNextDouble()) {
						String error = scandouble.next();
						System.err.println(error + " is not a velocity between 33 - 100 kph.");
						System.out.print("Enter velocity two as kilometers per hour:\n"
								+ "=> ");
					} velocity2 = scandouble.nextDouble();
					
					if (velocity2 < 33 || velocity2 > 100) {
						System.err.println(velocity2 + " is not a velocity between 33 - 100 kph.\n");
						System.out.print("Enter velocity two as kilometers per hour:\n"
								+ "=> ");
					} else {
						errorCatching = false;
					}
				}
				
				//Solving for weight
				double totalVelocity = velocity1 + velocity2;
				weight1 = (velocity2 / totalVelocity) * 1800;
				weight2 = (velocity1 / totalVelocity) * 1800;
				
				
				
			}
			
			
			
			
			
			//Outputting results
			if (menuOption != 3) {
				System.out.printf("The required masses and velocities in order to reach dynamic equilibrium of momentum in a car crash are listed below:\n"
					+ "Car 1 Weight/Velocity:%.2fkg/%.2fkph\n"
						
					+ "Car 2 Weight/Velocity:%.2fkg/%.2fkph\n"
					
					+ "\n".repeat(5)
					, weight1 , velocity1 , weight2 , velocity2);
			}
			
			
			
			//Quit Program option
			if (menuOption == 3) {
				programRunning = false;
			}
			
		}
		
		System.out.println("Thank you for using the momentum dynamic equilibrium calculator");

		scanint.close();
		scandouble.close();
	}

}
