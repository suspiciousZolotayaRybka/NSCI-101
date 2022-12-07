/**Author: 
 * NSCI 101 / 7380
 * Date: 10/30/2022
 * A program that determines a 10kg ball's PE and KE based on a planet input and height input
 * by the user.
 * 
 */
import java.util.Scanner;
public class Discussion2_ConservationofEnergy {

	public static void main(String[] args) {
		Scanner scanint = new Scanner(System.in);
		Scanner scandouble = new Scanner (System.in);
		int planetChoice;
		boolean errorChecking = true;
		boolean programRunning = true;
		double g = 0;
		double height = 0;
		double calculationHeight = 0;
		double PE;
		double KE = 0;
		double E; 
		double heightCoefficient;
		String strPlanetChoice = "placeholder";
		
		double test = scandouble.nextDouble();
		
		System.out.print(test);
		
		
		while (programRunning) {
			
			printPlanetMenu();
			System.out.println("");
			planetChoice = getPlanetChoice(scanint , errorChecking);
			
			switch (planetChoice) {
				case 1:
					g = 8.87;
					strPlanetChoice = "Venus";
					break;
				case 2:
					g = 9.81;
					strPlanetChoice = "Earth";
					break;
				case 3:
					g = 1.62;
					strPlanetChoice = "the Moon";
					break;
				case 4:
					g = 3.77;
					strPlanetChoice = "Mars";
					break;
				case 5:
					g = 25.95;
					strPlanetChoice = "Jupiter";
					break;
				case 6:
					g = 275;
					strPlanetChoice = "the Sun";
					break;
				case 7:
					programRunning = false;
					break;
			}
			
			if (programRunning) {
				height = getHeight(errorChecking , scandouble , strPlanetChoice);
				calculationHeight = getCalculationHeight(errorChecking , scandouble , height);
				
				PE = 10 * g * height;
				
				if (height == calculationHeight) {
					KE = 0;
				} else if (calculationHeight == 0) {
					KE = PE;
					PE = 0;
				} else if (height != calculationHeight) {
					E = PE;
					heightCoefficient = (height - calculationHeight) / height;
					KE = E * heightCoefficient;
					PE = E - KE;		
				}
				
				System.out.printf("Planet: %s\n"
						+ "Height ball dropped: %f m\n"
						+ "Potential and kinetic energy calculated at: %f m\n"
						+ "PE: %f J\n"
						+ "KE: %f J\n"
						+ "\n".repeat(5)
						, strPlanetChoice , height , calculationHeight , PE , KE);
			}

		}
	scanint.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void printPlanetMenu() {
		System.out.println("+----------+---------+----------------------------+\n"
				+ "| Option # | Planet  | Acceleration due to Gravity |\n"
				+ "+----------+---------+-----------------------------+\n"
				+ "|        1 | Venus   | 8.87 m/s^2                  |\n"
				+ "|        2 | Earth   | 9.81 m/s^2                  |\n"
				+ "|        3 | Moon    | 1.62 m/s^2                  |\n"
				+ "|        4 | Mars    | 3.77 m/s^2                  |\n"
				+ "|        5 | Jupiter | 25.95 m/s^2                 |\n"
				+ "|        6 | Sun     | 275 m/s^2                   |\n"
				+ "|        7 | Quit    |                             |\n"
				+ "+----------+---------+-----------------------------+\n");
	}
	
	
	
	
	
	public static int getPlanetChoice(Scanner scanint , boolean errorChecking) {
		int planetChoice = 0;
		askForPlanetChoice();
		
		while (errorChecking) {
			while (!scanint.hasNextInt()) {
			String error = scanint.next();
			System.err.println(error + " is not an int.");
			askForPlanetChoice();
			} planetChoice = scanint.nextInt();
			
			if (planetChoice < 1 || planetChoice > 7) {
				System.err.println(planetChoice + " is not between 1-7.");
				askForPlanetChoice();
			} else if (planetChoice >= 1 && planetChoice <= 7) {
				errorChecking = false;
			}
		}
		return planetChoice;
	}
	
	public static void askForPlanetChoice() {
		System.out.println("Enter 1-6 for planet, or 7 to quit\n"
				+ "=> ");
	}
	
	
	
	
	public static double getHeight(Boolean errorChecking , Scanner scandouble , String strPlanetChoice) {
		double height = 0;
		askForHeight(strPlanetChoice);
		
		while (errorChecking) {
			while (!scandouble.hasNextDouble()) {
				String error = scandouble.next();
				System.err.println(error + " is not a double.");
				askForHeight(strPlanetChoice);
			} height = scandouble.nextDouble();
			
			if (height <= 0) {
				System.err.println("Height cannot be 0 m or a negative number.");
				askForHeight(strPlanetChoice);
			} else if (height > 0) {
				errorChecking = false;
			}
		}
		return height;
	}
	public static void askForHeight(String strPlanetChoice) {
		System.out.println("Enter the height in meters from which to drop your 10kg ball on " + strPlanetChoice + "\n"
				+ "=> ");
	}
	
	
	
	
	public static double getCalculationHeight(Boolean errorChecking , Scanner scandouble , double height) {
		double calculationHeight = 0;
		askForCalculationHeight(height);
		
		while (errorChecking) {
		
			while (!scandouble.hasNextDouble()) {
				String error = scandouble.next();
				System.err.println(error + " is not a double.");
				askForCalculationHeight(height);
			} calculationHeight = scandouble.nextDouble();
			if (calculationHeight < 0 || calculationHeight > height) {
				System.err.println(calculationHeight + " cannot be less than 0 m or greater than " + height + " m.");
				askForCalculationHeight(height);
			} else if (calculationHeight >= 0 && calculationHeight <= height) {
				errorChecking = false;
			}
		}
		return calculationHeight;
	}
	public static void askForCalculationHeight(double height) {
		System.out.println("Enter the height between 0 m - " + height + " m at which you would like to calculate KE and PE \n"
				+ "=> ");
	}
}
