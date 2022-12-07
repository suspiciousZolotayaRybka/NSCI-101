/* Name: 
 * Class: NSCI 101 / 7380
 * 4 December 2022
 * A program that carries out the calculations for Labratory #7 using an ordered integer system and 4 inherited classes from Reaction
 * 
 */

package Discussion7_AcidsAndBases;

import java.util.Scanner;

public class AcidsAndBases_MainProgram {
	
	static Reaction[] reactions = new Reaction[100];
	static int numReactions = 0;
	
	static Scanner scanstr = new Scanner(System.in);
	static Scanner scandouble = new Scanner(System.in);
	static Scanner scanint = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean programRunning = true;
		int menuChoice;
		
		while (programRunning) {
			printMenu();
			menuChoice = Try.getInt(1, 5, scanint);
			
			switch(menuChoice) {
			case 1:
				addReactions();
				break;
			case 2:
				viewAllData();
				break;
			case 3:
				viewSpecificData();
				break;
			case 4:
				viewSingleReactionData();
				break;
			case 5:
				programRunning = false;
				break;
			}
			
			
			}
		
		System.out.println("thank you for using the Acid and Base Reaction Program");
		scanstr.close();
		scandouble.close();
		scanint.close();
	}
	
	
	
	
	
	public static void printMenu() {
		if (numReactions == 0) {
			System.out.println("1 - Add New Reaction\n"
					+ "2 - Quit Program\n"
					+ "=>");
		} else {
			Reaction[] orderedReactions = orderReactions();
			System.out.println("┌─────────────────────────────────────────────┐\n"
							 + "│              Reactions Menu                 │\n"
							 + "├────┬────────────────────┬───────────────────┤\n"
							 + "│    │                    │                   │");
			for (int i = 0; i < numReactions; i++) {
				System.out.printf("│%4d│%-20s│%-5.2f%-14s│\n"
						     + "│    │                    │                   │\n"
						         , i + 1 , orderedReactions[i].getAcid() + " + " + orderedReactions[i].getBase() 
						         , orderedReactions[i].getBaseVolume() , "mL " + orderedReactions[i].getBase());
				}
			System.out.println("└────┴────────────────────────────────────────┘");
			System.out.println("1 - Add New reaction\n"
					+ "2 - View All Data\n"
					+ "3 - View Specific Variable Data\n"
					+ "4 - View Single Reaction Data\n"
					+ "5 - Quit Program\n"
					+ "=>");
		}
		
	}
	
	
	
	
	
	public static void addReactions() {
		boolean addingReactions = true;
		int reactionChoice;
		String base;
		while (addingReactions) {
			System.out.println("Which reaction would you like to add?\n"
					+ "1 - HCl + NaOH\n"
					+ "2 - HCl + KOH\n"
					+ "3 - NHO3 + NaOH\n"
					+ "4 - NHO3 + KOH\n"
					+ "=>");
			reactionChoice = Try.getInt(1, 4, scanint);
			if (reactionChoice == 1 || reactionChoice ==3) {
				base = "NaOH";
			} else {
				base = "KOH";
			}
			System.out.printf("What is your base volume (mL of %s)?\n"
					+ "=>"
					, base);
			double baseVolume = Try.getDouble(12, 16, scandouble);
			switch (reactionChoice) {
			case 1:
				reactions[numReactions] = new HClReaction1(baseVolume);
				numReactions++;
				break;
			case 2:
				reactions[numReactions] = new HClReaction2(baseVolume);
				numReactions++;
				break;
			case 3:
				reactions[numReactions] = new HNO3Reaction1(baseVolume);
				numReactions++;
				break;
			case 4:
				reactions[numReactions] = new HNO3Reaction2(baseVolume);
				numReactions++;
				break;
			}
			System.out.println("Enter another reaction? y/n\n"
					+ "=>");
			addingReactions = Try.getBoolean(scanstr);
		}
		System.out.println("\n".repeat(49));
	}
	
	
	
	
	
	public static void viewAllData() {
		Reaction[] orderedReactions = orderReactions();
		for (int i = 0; i < numReactions; i++) {
			System.out.print(orderedReactions[i]);
			System.out.println("\n".repeat(5));
		}
		
		System.out.println("Press ENTER to continue...");
		scanstr.nextLine();
		System.out.println("\n".repeat(49));
	}
	
	
	
	
	
	public static void viewSpecificData() {
		System.out.println("Please select which specific data you would like to view and compare\n"
				+ "1 - Volumes\n"
				+ "2 - Concentrations\n"
				+ "3 - Moles\n"
				+ "4 - Acid pH\n");
		int userChoice = Try.getInt(1 , 4 , scanint);
		compareData(userChoice);
		System.out.println("Press ENTER to continue...");
		scanstr.nextLine();
		System.out.println("\n".repeat(49));
	}
	
	
	
	
	
	public static void viewSingleReactionData() {
		System.out.println("Please enter the menu choice of the reaction's data you would like to view\n"
				+ "=>");
		int userChoice = (Try.getInt(1, numReactions + 1, scanint)) - 1;
		Reaction[] orderedReactions = orderReactions();
		System.out.print(orderedReactions[userChoice]);
		System.out.println("Press ENTER to continue...");
		scanstr.nextLine();
		System.out.println("\n".repeat(49));
	}
	
	
	
	
	
	public static Reaction[] orderReactions() {
		Reaction[] orderedReactions = new Reaction[numReactions];
		
		//Initializing the different reaction arrays
		int numReactions1 = 0;
		int numReactions2 = 0;
		int numReactions3 = 0;
		int numReactions4 = 0;
		
		for (int i = 0; i < numReactions; i++) {
			if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("HClNaOH")) {
				numReactions1++;
			} else if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("HClKOH")) {
				numReactions2++;
			} else if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("NHO3NaOH")) {
				numReactions3++;
			} else if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("NHO3KOH")) {
				numReactions4++;
			}
		}
		
		Reaction[] reactions1 = new Reaction[numReactions1];
		Reaction[] reactions2 = new Reaction[numReactions2];
		Reaction[] reactions3 = new Reaction[numReactions3];
		Reaction[] reactions4 = new Reaction[numReactions4];
		
		//Filling the different reaction arrays
		numReactions1 = 0;
		numReactions2 = 0;
		numReactions3 = 0;
		numReactions4 = 0;
		
		for (int i = 0; i < numReactions; i++) {
			if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("HClNaOH")) {
				reactions1[numReactions1] = new HClReaction1(reactions[i].getBaseVolume());
				numReactions1++;
			} else if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("HClKOH")) {
				reactions2[numReactions2] = new HClReaction2(reactions[i].getBaseVolume());
				numReactions2++;
			} else if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("NHO3NaOH")) {
				reactions3[numReactions3] = new HNO3Reaction1(reactions[i].getBaseVolume());
				numReactions3++;
			} else if ( (reactions[i].getAcid()+reactions[i].getBase()) .equals("NHO3KOH")) {
				reactions4[numReactions4] = new HNO3Reaction2(reactions[i].getBaseVolume());
				numReactions4++;
			} 
		}
		
		//Ordering the reaction arrays based on Base Volume in mL
		reactions1 = Reaction.sortBaseVolumes(reactions1);
		reactions2 = Reaction.sortBaseVolumes(reactions2);
		reactions3 = Reaction.sortBaseVolumes(reactions3);
		reactions4 = Reaction.sortBaseVolumes(reactions4);
		
		//Filling orderedReactions
		numReactions = 0;
		
		for (int i = 0; i < numReactions1; i++) {
				orderedReactions[numReactions] = reactions1[i];
				numReactions++;
		}
		for (int i = 0; i < numReactions2; i++) {
			orderedReactions[numReactions] = reactions2[i];
			numReactions++;
		}
		for (int i = 0; i < numReactions3; i++) {
			orderedReactions[numReactions] = reactions3[i];
			numReactions++;
		}
		for (int i = 0; i < numReactions4; i++) {
			orderedReactions[numReactions] = reactions4[i];
			numReactions++;
		}
		
		return orderedReactions;
	}
	
	
	
	
	
	public static void compareData(int userChoice) {
		
		switch (userChoice) {
		case 1:
			
			Reaction[] orderedReactions = orderReactions();
			System.out.println("┌──────────────────────┐\n"
							 + "│   Comparing Volumes  │\n"
							 + "├────┬────────┬────────┤\n"
							 + "│    │        │        │");
			for (int i = 0; i < numReactions; i++) {
				System.out.printf("│%4d│%-8s│%-8s│\n"
								+ "│    │%-8s│%-8s│\n"		
						        + "│    │        │        │\n"
						         , i + 1 , orderedReactions[i].getAcid() , orderedReactions[i].getBase()
						         , String.format("%.2f%s" , orderedReactions[i].getAcidVolume() , "mL") 
						         , String.format("%.2f%s" , orderedReactions[i].getBaseVolume() , "mL"));
				}
			System.out.println("└────┴────────┴────────┘");
			
			break;
		case 2:
			
			Reaction[] orderedReactions1 = orderReactions();
			System.out.println("┌────────────────────┐\n"
							 + "│   Concentrations   │\n"
							 + "├────┬───────┬───────┤\n"
							 + "│    │       │       │");
			for (int i = 0; i < numReactions; i++) {
				System.out.printf("│%4d│%-7s│%-7s│\n"
								+ "│    │%-7s│%-7s│\n"		
						        + "│    │       │       │\n"
						         , i + 1 , orderedReactions1[i].getAcid() , orderedReactions1[i].getBase()
						         , String.format("%.3f%s" , orderedReactions1[i].getAcidConcentration() , "M")
						         , String.format("%.3f%s" , orderedReactions1[i].getBaseConcentration() , "M"));
				}
			System.out.println("└────┴───────┴───────┘");
			
			break;
		case 3: 
			
			Reaction[] orderedReactions2 = orderReactions();
			System.out.println("┌────────────────────────────┐\n"
							 + "│     Moles (Always same)    │\n"
							 + "├────┬───────────┬───────────┤\n"
							 + "│    │           │           │");
			for (int i = 0; i < numReactions; i++) {
				System.out.printf("│%4d│%-11s│%11s│\n"
								+ "│    │%-11s│%-11s│\n"		
						        + "│    │           │           │\n"
						         , i + 1 , orderedReactions2[i].getAcid() , orderedReactions2[i].getBase()
						         , String.format("%.6f%s" , orderedReactions2[i].getMoles() , "mol")
						         , String.format("%.6f%s" , orderedReactions2[i].getMoles() , "mol"));
				}
			System.out.println("└────┴───────────┴───────────┘");
			
			break;
		case 4: 
			
			Reaction[] orderedReactions3 = orderReactions();
			System.out.println("┌───────────┐\n"
							 + "│  Acid pH  │\n"
							 + "├────┬──────┤\n"
							 + "│    │      │");
			for (int i = 0; i < numReactions; i++) {
				System.out.printf("│%4d│%-6s│\n"
								+ "│    │%-6.3f│\n"		
						        + "│    │      │\n"
						         , i + 1 , orderedReactions3[i].getAcid()
						         , orderedReactions3[i].getAcidpH() , 0);
				}
			System.out.println("└────┴──────┘");
			
			break;
		}
	}

}










