/*  CSCI 101 / 7380
 *  November 13, 2022
 *  A program that allows a user to create new lenses and mirrors
 * 
 */
package Discussion4_LensesAndMirrors;
import java.util.Scanner;
public class MainProgram {

	public static void main(String[] args) {
		Scanner scanint = new Scanner(System.in);
		Scanner scanstr = new Scanner(System.in);
		Scanner scandouble = new Scanner(System.in);
		boolean programRunning = true;
		int menuOption;
		int indexChoice;
		double focalPointChoice;
		boolean addingFocalPoint;
		boolean[] mirrorHasData = new boolean[100];
		boolean[] lensHasData = new boolean[100];
		double[] mirrorData = new double[100];
		double[] lensData = new double[100];
		Mirror[] mirrorsData = new Mirror[100];
		Lens[] lensesData = new Lens[100];
		
		
		while (programRunning) {
			printMenu();
			menuOption = Generate.getInt(1 , 5 , scanint);
			switch (menuOption) {
			
			
			
			
			
			case 1:
				System.out.println("You can create 100 mirrors.\n"
						+ "Please enter the mirror number you would like to change.\n"
						+ "=>");
				indexChoice = (Generate.getInt(1, 100, scanint)) - 1;
				addingFocalPoint = checkIfData(scanstr , mirrorHasData , mirrorData , indexChoice , "mirror");
				if (mirrorHasData[indexChoice]) {
					//If mirrorHasData[indexChoice] is true and the user decides to change it
					if(addingFocalPoint) {
						System.out.printf("Please enter the focal point for mirror #%d as a double between 1 - 100\n"
								+ "=>" 
								, indexChoice + 1);
						focalPointChoice = Generate.getDouble(1, 100, scandouble);
						mirrorData[indexChoice] = focalPointChoice;
						mirrorsData[indexChoice] = new Mirror(focalPointChoice);
					//if mirrorHasData[indexChoice] is true and the user decides to keep it the same
					} else {
						System.out.printf("You chose not to add new focal point for mirror #%d" , indexChoice);
					}
					//If mirrorHasData[indexChoice] is not yet true
				} else {
					System.out.printf("Please enter the focal point for mirror #%d as a double between 1 - 100\n"
							+ "=>" 
							, indexChoice + 1);
					focalPointChoice = Generate.getDouble(1, 100, scandouble);
					mirrorHasData[indexChoice] = true;
					mirrorData[indexChoice] = focalPointChoice;
					mirrorsData[indexChoice] = new Mirror(focalPointChoice);
				}
				break;
			
			
			
			
			
			case 2:
				System.out.println("You can create 100 lenses.\n"
						+ "Please enter the lens number you would like to change.\n"
						+ "=>");
				indexChoice = (Generate.getInt(1, 100, scanint)) - 1;
				addingFocalPoint = checkIfData(scanstr , lensHasData , lensData , indexChoice , "mirror");
				if (lensHasData[indexChoice]) {
					//If lensHasData[indexChoice] is true and the user decides to change it
					if(addingFocalPoint) {
						System.out.printf("Please enter the focal point for lens #%d as a double between 1 - 100\n"
								+ "=>" 
								, indexChoice + 1);
						focalPointChoice = Generate.getDouble(1, 100, scandouble);
						lensData[indexChoice] = focalPointChoice;
						lensesData[indexChoice] = new Lens(focalPointChoice);
					//if lensHasData[indexChoice] is true and the user decides to keep it the same
					} else {
						System.out.printf("You chose not to add new focal point for lens #%d" , indexChoice);
					}
					//If lensHasData[indexChoice] is not yet true
				} else {
					System.out.printf("Please enter the focal point for lens #%d as a double between 1 - 100\n"
							+ "=>" 
							, indexChoice + 1);
					focalPointChoice = Generate.getDouble(1, 100, scandouble);
					lensHasData[indexChoice] = true;
					lensData[indexChoice] = focalPointChoice;
					lensesData[indexChoice] = new Lens(focalPointChoice);
				}
				break;
			
			
			
			
			
			case 3:
				viewAllData(mirrorHasData , lensHasData , mirrorData , lensData);
				break;
			
			
			
			
			
			case 4:
				System.out.println("Would you like to view data for a mirror or lens?\n"
						+ "1 - Mirror\n"
						+ "2 - Lens\n"
						+ "=>");
				menuOption = Generate.getInt(1 , 2 , scanint);
				if (menuOption == 1) {
					viewSpecificData(mirrorHasData , mirrorData , scanint , "Mirror");
				} else {
					viewSpecificData(lensHasData , lensData , scanint , "Lens");
				}
				break;
			
			
			
			
			
			case 5:
				System.out.println("Are you sure you want to exit? You will lose all current progress");
				programRunning = !Generate.getBoolean(scanstr);
			}
			
			
		}
		System.out.println("Thank you for using the focal point program");
		scanint.close();
		scanstr.close();
		scandouble.close();

	}
	
	
	
	
	public static void printMenu() {
		System.out.println("Please enter your option: \n"
				+ "1 - Enter a mirror focal point\n"
				+ "2 - Enter a lens focal point\n"
				+ "3 - View all data\n"
				+ "4 - View data for a specific lens or mirror\n"
				+ "5 - Exit the program\n"
				+ "=> ");
	}
	
	
	
	
	
	public static boolean checkIfData(Scanner scanstr 
			, boolean[] hasData , double[] data
			, int indexChoice
			, String test) {
		if (hasData[indexChoice]) {
			System.out.printf("You have already entered %.1f for %s #%d.\n"
					+ "Would you like to override this value with a new value?\n"
					+ "=>"
					, data[indexChoice] , test , indexChoice);
			boolean overrideData = Generate.getBoolean(scanstr);
			if (overrideData) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	
	
	
	
	
	
	public static void viewAllData(boolean[] mirrorHasData , boolean[] lensHasData
			, double[] mirrorData , double[] lensData) {
		
		boolean hasNoData = true;
		for (int index = 0; index < 100; index++) {
			if (mirrorHasData[index] || lensHasData[index]) {
				hasNoData = false;
			}
		}
		if (hasNoData) {
			System.err.println("You have not entered any data.\n"
					+ "Please enter a focal point for a mirror or lens and return to this menu.");
		} else {
			for (int index = 0; index < 100; index++) {
				if (mirrorHasData[index]) {
					Mirror mirror = new Mirror(mirrorData[index]);
					System.out.printf("Mirror #%d data:\n" , index + 1);
					System.out.println(mirror);
				
				}
				if (lensHasData[index]) {
					Lens lens = new Lens(lensData[index]);
					System.out.printf("Lens #%d data:\n" , index + 1);
					System.out.print(lens);
				}
			}
		}
	}
	
	
	
	
	
	
	public static void viewSpecificData(boolean[] hasData , double[] data , Scanner scanint , String choice) {
		int count = 1;
		int menuOption;
		for (int index = 0; index < 100; index++) {
			if (hasData[index]) {
				count++;
			}
		}
		if (count == 1) {
			System.err.printf("You have not entered any data for %s. Please enter data and return to this menu\n" , choice);
		} else {
			System.out.printf("Please choose which %s you would like to view data for:\n" , choice);
			count = 1;
			for (int index = 0; index < 100; index++) {
				if (hasData[index]) {
					System.out.printf("%d - %s #%d\n" , count , choice , index + 1);
					count++;
				}
			}
			menuOption = Generate.getInt(1, count , scanint);
			count = 1;
			for (int index = 0; index < 100; index++) {
				if (count - 1 == menuOption) {
					System.out.printf("%s #%d Data: \n" , choice , index);
					if (choice == "Mirror") {
						Mirror mirror = new Mirror(data[index - 1]);
						System.out.println(mirror);
						return;
					} else {
						Lens lens = new Lens(data[index - 1]);
						System.out.print(lens);
						return;
					}
				}
				if (hasData[index]) {
					count++;
				}
			}
		}
		

	}
	

}
