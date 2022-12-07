/* CMIS 141/6981 
 * Date: 11/13/2022
 * A class that takes user input and determines if it fits the type of scan and range allowed
 * @author fineh
 */
package Discussion5_Radiation;
import java.util.Scanner;
public class Try {


	public static int getInt(int min , int max , Scanner scanint) {
		boolean errorCatching = true;
		int number = 0;
		while (errorCatching) {
			while (!scanint.hasNextInt()) {
				String error = scanint.next();
				System.err.printf(error + " is not an integer between %d - %d.\n" , min , max);
				System.out.printf("Please enter an integer between %d - %d.\n" , min , max);
			} number = scanint.nextInt();
			scanint.nextLine(); //Prevent the crash that occurs when scanning a String directly after scanning an int
			
			if (number < min || number > max) {
				System.err.printf(number + " is not an integer between %d - %d.\n" , min , max);
				System.out.printf("Please enter an integer between %d - %d.\n" , min , max);
			} else {
				errorCatching = false;
			}
		}
		return number;
	}
	
	
	
	
	
	public static double getDouble(int min , int max , Scanner scandouble) {
		boolean errorCatching = true;
		double number = 0;
		while (errorCatching) {
			while (!scandouble.hasNextDouble()) {
				String error = scandouble.next();
				System.err.printf(error + " is not an integer between %d - %d.\n" , min , max);
				System.out.printf("Please enter an integer between %d - %d.\n" , min , max);
			} number = scandouble.nextDouble();
			scandouble.nextLine(); //Prevent the crash that occurs when scanning a String directly after scanning a double
			
			if (number < min || number > max) {
				System.err.printf(number + " is not an integer between %d - %d.\n" , min , max);
				System.out.printf("Please enter an integer between %d - %d.\n" , min , max);
			} else {
				errorCatching = false;
			}
		}
		return number;
	}
	
	
	
	
	
	public static boolean getBoolean(Scanner scanstr) {
		String userChoice;
		userChoice = scanstr.nextLine().toLowerCase();
		while ( (!((userChoice.charAt(0)) == 'y')) && (!((userChoice.charAt(0) ) == 'n')))  {
			System.err.print(userChoice + " is not a yes or no answer\n");
			System.out.println("Please enter a yes or no answer");
			userChoice = scanstr.nextLine().toLowerCase();
		}
		if (userChoice.charAt(0) == 'y') {
			return true;
		}
		return false;
	}

}
