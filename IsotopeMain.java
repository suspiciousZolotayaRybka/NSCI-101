package Discussion5_Radiation;




import java.util.Scanner;
public class IsotopeMain {

	
	public static Isotope[] isotopes = new Isotope[100];
	public static int numberIsotopes = 0;
	static Scanner scanstr = new Scanner(System.in);
	static Scanner scandouble = new Scanner(System.in);
	static Scanner scanint = new Scanner(System.in);
	
	public static void main(String[] args) {
		isotopes[0] = new Isotope("bishmuth-212" , 60.6 , "seconds");
		isotopes[1] = new Isotope("sodium-24" , 15.0 , "hours");
		isotopes[2] = new Isotope("radon-222" , 3.82 , "days");
		isotopes[3] = new Isotope("cobalt-60" , 5.27 , "years");
		numberIsotopes = 4;
		Isotope[] orderedIsotopes;
		int menuChoice;
		boolean programRunning = true;
		
		
		System.out.println("Assume the following when calculating half-lives:\n"
				+ "\ta. You have an unlimited amount of time to monitor counts per second using a radiation probe\n"
				+ "\tb. Counts per second for any radioactive material is initially measured at 10cm, with a cap at 100,000\n"
				+ "\tc. Probe distances are shown at 10cm, 20cm, and 40cm.\n");
		
		while (programRunning) {
			orderedIsotopes = printMenu();
			menuChoice = Try.getInt(1, 3, scanint);
			
			switch (menuChoice) {
				case (1) :
					addIsotope();
					break;
				case (2) :
					calculateHalfLives(orderedIsotopes);
				break;
			case (3) :
				programRunning = false;
			System.out.println("Thanks for using the isotope program.");
			}
				
				
		}
		
		
		
		
		
		
		
		
		scanstr.close();
		scanint.close();
		scandouble.close();
	}
	
	
	
	
	
	
	public static Isotope[] printMenu() {
		Isotope[] orderedIsotopes = orderIsotopes();
		System.out.println("╔═════════════════════════════════════════════════╗\n"
						 + "║                 ISOTOPE MENU                    ║\n"
						 + "╠═════════════════════════════════════════════════╣\n"
						 + "║ # - ISOTOPE-###    | HALF-LIFE                  ║");
		for (int i = 0; i < numberIsotopes; i++) {
			System.out.println("║                                                 ║");
			System.out.printf("║%2d - %-15s| %-27s║\n" 
					, i + 1 , orderedIsotopes[i].getIsotopeName() , orderedIsotopes[i].timeToString());
			
		}
		System.out.println("╚═════════════════════════════════════════════════╝");
		System.out.println("1 - Add Isotope\n"
				+ "2 - Calculate Half-Lives\n"
				+ "3 - Exit Program\n"
				+ "=>");
		return orderedIsotopes;
	}
	
	
	
	
	public static void addIsotope() {
		String name;
		int unitTime;
		String[] unitArray = {"seconds" , "hours" , "days" , "years"};
		double time;
		boolean enteringInfo = true;
		
		
		while (enteringInfo) {
			//Get isotope name
			System.out.print("Enter the isotope name\n"
					+ "=>");
			name = scanstr.nextLine();
			//get Isotope unit of time
			System.out.print("Enter the unit of time for " + name + "'s half-life\n"
					+ "1 - seconds\n"
					+ "2 - hours\n"
					+ "3 - days\n"
					+ "4 - years\n"
					+ "=>");
			unitTime = (Try.getInt(1 , 4 , scanint)) - 1;
			//get Isotope time
			System.out.println("Enter how many " + unitArray[unitTime] + " the half-life of " + name + " is\n"
					+ "=>");
			time = scandouble.nextDouble();
			
			System.out.println("Does this information look correct?\n"
					+ "Isotope: " + name + "\n"
					+ "Half-Life: " + time + " " + unitArray[unitTime] + "\n"
					+ "=>");
			enteringInfo = !Try.getBoolean(scanstr);
			if (enteringInfo) {
				System.out.println("Please re-enter your correct Isotope info.");
			} else {
				isotopes[numberIsotopes] = new Isotope(name , time , unitArray[unitTime]);
				numberIsotopes++;
				enteringInfo = false;
			}
		}
	}
	
	
	
	
	
	public static void calculateHalfLives(Isotope[] orderedIsotopes) {
		int i;
		double halfLife;
		double euler = 2.718281828459045;
		double decayConstant;
		double cps;
		double cpsAtQuarter;
		double cpsAtHalf;
		double cpsAtThreeQuarters;
		double cpsAtHalfLife;
		System.out.println("Please enter the Isotope you would like to measure half-lives for\n"
				+ "=>");
		i = Try.getInt(1, numberIsotopes, scanint) - 1;
		String unitOfTime = orderedIsotopes[i].getUnitOfTime();
		System.out.println("Please enter the initial counts per second measurement when the probe distance is 10cm away\n"
				+ "=>");
		cps = Try.getDouble(1, 100000, scandouble);
		
		halfLife = orderedIsotopes[i - 1].getTime();
		decayConstant = .693 / halfLife;
		
		cpsAtQuarter = cps * (Math.pow(euler, (decayConstant * -(halfLife * .25))));
		cpsAtHalf = cps * (Math.pow(euler, (decayConstant * -(halfLife * .5))));
		cpsAtThreeQuarters = cps * (Math.pow(euler, -(decayConstant * (halfLife * .75))));
		cpsAtHalfLife = cps / 2;
		
		System.out.println("\n".repeat(50));
		System.out.print(orderedIsotopes[i].getIsotopeName() + "\n");
		System.out.printf("Probe 10cm Away: \n"
				+ "Initial Counts per Second: %.2f\n"
				+ "Counts Per Second at %.2f %s (1/4 half-life): \n%.2f\n"
				+ "Counts Per Second at %.2f %s (1/2 half-life): \n%.2f\n"
				+ "Counts Per Second at %.2f %s (3/4 half-life): \n%.2f\n"
				+ "Counts Per Second at %.2f %s (1 half-life): \n%.2f\n"
				+ "\n".repeat(2)
				
				+ "Probe 20cm Away: \n"
						+ "Initial Counts per Second: %.2f\n"
						+ "Counts Per Second at %.2f %s (1/4 half-life): \n%.2f\n"
						+ "Counts Per Second at %.2f %s (1/2 half-life): \n%.2f\n"
						+ "Counts Per Second at %.2f %s (3/4 half-life): \n%.2f\n"
						+ "Counts Per Second at %.2f %s (1 half-life): \n%.2f\n"
						+ "\n".repeat(2)
						
						+ "Probe 40cm Away: \n"
							+ "Initial Counts per Second: %.2f\n"
							+ "Counts Per Second at %.2f %s (1/4 half-life): \n%.2f\n"
							+ "Counts Per Second at %.2f %s (1/2 half-life): \n%.2f\n"
							+ "Counts Per Second at %.2f %s (3/4 half-life): \n%.2f\n"
							+ "Counts Per Second at %.2f %s (1 half-life): \n%.2f\n"
							+ "\n"
				
				, cps
				, orderedIsotopes[i].getTime() * .25 , unitOfTime , cpsAtQuarter
				, orderedIsotopes[i].getTime() * .5 , unitOfTime , cpsAtHalf
				, orderedIsotopes[i].getTime() * .75 , unitOfTime , cpsAtThreeQuarters
				, orderedIsotopes[i].getTime() , unitOfTime , cpsAtHalfLife
					
					, cps / 4
					, orderedIsotopes[i].getTime() * .25 , unitOfTime , cpsAtQuarter / 4
					, orderedIsotopes[i].getTime() * .5 , unitOfTime , cpsAtHalf / 4
					, orderedIsotopes[i].getTime() * .75 , unitOfTime , cpsAtThreeQuarters / 4
					, orderedIsotopes[i].getTime() , unitOfTime , cpsAtHalfLife / 4
					
						, cps / 16
						, orderedIsotopes[i].getTime() * .25 , unitOfTime , cpsAtQuarter / 16
						, orderedIsotopes[i].getTime() * .5 , unitOfTime , cpsAtHalf / 16
						, orderedIsotopes[i].getTime() * .75 , unitOfTime , cpsAtThreeQuarters / 16
						, orderedIsotopes[i].getTime() , unitOfTime , cpsAtHalfLife / 16);
		
		
		System.out.println("Press ENTER to continue...");
		scanstr.nextLine();
		System.out.print("\n".repeat(50));
		
	}
	
	
	
	
	
	public static Isotope[] orderIsotopes() {
		//Setting up the index that will be returned at the end of the method
		Isotope[] orderedIsotopes = new Isotope[numberIsotopes];
		
		//Finding the size of each unit of time index
		int secondIndex = 0;
		int hourIndex = 0;
		int dayIndex = 0;
		int yearIndex = 0;
		
		for (int i = 0; i < numberIsotopes; i++) {
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("seconds")) {
				secondIndex++;
			}
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("hours")) {
				hourIndex++;
			}
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("days")) {
				dayIndex++;
			}
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("years")) {
				yearIndex++;
			}
		}
		
		Isotope[] secondDecays = new Isotope[secondIndex];
		Isotope[] hourDecays = new Isotope[hourIndex];
		Isotope[] dayDecays = new Isotope[dayIndex];
		Isotope[] yearDecays = new Isotope[yearIndex];
		
		
		
		
		
		//Filling up each individual array
		secondIndex = 0;
		hourIndex = 0;
		dayIndex = 0;
		yearIndex = 0;
		
		for (int i = 0; i < numberIsotopes; i++) {
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("seconds")) {
				secondDecays[secondIndex] = new Isotope(isotopes[i].getIsotopeName() , isotopes[i].getTime() , isotopes[i].getUnitOfTime());
				secondIndex++;
			}
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("hours")) {
				hourDecays[hourIndex] = new Isotope(isotopes[i].getIsotopeName() , isotopes[i].getTime() , isotopes[i].getUnitOfTime());
				hourIndex++;
			}
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("days")) {
				dayDecays[dayIndex] = new Isotope(isotopes[i].getIsotopeName() , isotopes[i].getTime() , isotopes[i].getUnitOfTime());
				dayIndex++;
			}
			if (isotopes[i].getUnitOfTime().equalsIgnoreCase("years")) {
				yearDecays[yearIndex] = new Isotope(isotopes[i].getIsotopeName() , isotopes[i].getTime() , isotopes[i].getUnitOfTime());
				yearIndex++;
			}
		}
		
		
		
		secondDecays = Isotope.sortTime(secondDecays);
		hourDecays = Isotope.sortTime(hourDecays);
		dayDecays = Isotope.sortTime(dayDecays);
		yearDecays = Isotope.sortTime(yearDecays);
		
		
		
		
		

		numberIsotopes = 0;
		for (int i = 0; i < secondDecays.length; i++) {
			orderedIsotopes[numberIsotopes] = secondDecays[i];
			numberIsotopes++;
		}
		for (int i = 0; i < hourDecays.length; i++) {
			orderedIsotopes[numberIsotopes] = hourDecays[i];
			numberIsotopes++;
		}
		for (int i = 0; i < dayDecays.length; i++) {
			orderedIsotopes[numberIsotopes] = dayDecays[i];
			numberIsotopes++;
		}
		for (int i = 0; i < yearDecays.length; i++) {
			orderedIsotopes[numberIsotopes] = yearDecays[i];
			numberIsotopes++;
		}
		
		
		return orderedIsotopes;
	}

}
