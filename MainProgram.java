/*
 * Author: 
 * Date: 27 November 2022
 * Class: NSCI 101 / 7380
 * A program that allows the calculates an endothermic or exothermic reaction for a user,
 * after they enter the volume of Reactant B and their final temp
 */
package Discussion6_HeatOfReaction;
import java.util.Scanner;

import FinehoutIsaac_Discussion7_AcidsAndBases.Try;
public class MainProgram {
	//declaring program variables
	static Scanner scandouble = new Scanner(System.in);
	static Scanner scanstr = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		double volumeReactantB;
		double finalTemp;
		boolean programRunning = true;
		
		System.out.println("Isaac Finehout \t NSCI 101 7380 \t 27 November 2022");
		System.out.println("Welcome to the Heat of Reaction Program.\n");
		
		while (programRunning) {
			System.out.println("Enter the volume of Reactant B as a double under 15mL\n"
					+ "=>");
			volumeReactantB = Try.getDouble(0, 15, scandouble);
			System.out.println("|\n"
					+ "|\n"
					+ "Enter the final temperature of the solution\n"
					+ "=>");
			finalTemp = Try.getDouble(0, 1000, scandouble);
			System.out.println("|\n"
					+ "|\n"
					+ "Press ENTER to generate your results...\n");
			Reaction newReaction = new Reaction("placeholder", "placeholder", "placeholder", 
					volumeReactantB, finalTemp, 0, 0, 0);
			if (newReaction.getChangeTemp() < 0) {
				newReaction = new EndothermicReaction(volumeReactantB, finalTemp);
			} else {
				newReaction = new ExothermicReaction(volumeReactantB, finalTemp);
			}
			
			System.out.println(newReaction);
			System.out.println("\n".repeat(5) + "Enter another reaction?\n"
					+ "=>");
			programRunning = Try.getBoolean(scanstr);
			System.out.println("\n".repeat(50));
		}
		
		System.out.println("Thank you for using the Heat of Reaction Program!");
		scandouble.close();
		scanstr.close();
	}
}
