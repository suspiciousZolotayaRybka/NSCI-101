package Discussion6_HeatOfReaction;

public class Reaction {

	//Reaction attributes
	private String reactants;
	private String products;
	private String reactionType;
	private double volumeA = 15.00;
	private double volumeB;
	private double volumeTotal;
	private double initialTemp = 20.00;
	private double finalTemp;
	private double changeTemp;
	private double density;
	private double massGrams;
	private double concentration;
	private double molesOfReactantB;
	private double specificHeat;
	private double heatTransfer;
	private double heatOfReactionPerMole;
	
	
	
	
	
	//Empty constructor to prevent null point exception error
	public Reaction() {
		reactants = "null";
		products = "null";
		reactionType = "null";
		volumeB = 0;
		volumeTotal = 0;
		finalTemp = 0;
		changeTemp = 0;
		density = 0;
		massGrams = 0;
		concentration = 0;
		molesOfReactantB = 0;
		specificHeat = 0;
		heatTransfer = 0;
		heatOfReactionPerMole = 0;
		
	}
	
	public Reaction(String reactants, String products, String reactionType, 
			double volumeB, 
			double finalTemp,
			double density,
			double concentration,
			double specificHeat) {
		this.reactants = reactants;
		this.products = products;
		this.reactionType = reactionType;
		this.volumeB = volumeB;
		//finding volumeTotal
		this.volumeTotal = this.volumeA + this.volumeB;
		this.finalTemp = finalTemp;
		//fining change in temperature
		this.changeTemp = this.finalTemp - this.initialTemp;
		this.density = density;
		//finding mass of substance in grams
		this.massGrams = this.density * this.volumeTotal;
		this.concentration = concentration;
		//finding moles of Reactant B (.001 times volume to change from mL)
		this.molesOfReactantB = this.concentration * ( (.001) * (this.volumeB) );
		this.specificHeat = specificHeat;
		//Finding heat transfer of the liquid (reactant is negative of liquid), have to convert grams to kG
		this.heatTransfer = ( (.001) * (this.massGrams) ) * this.specificHeat * this.changeTemp;
		//finding heatOfReactionPerMole, must take it times negative one since the heatTransfer value is for the liquid and not the reactant
		this.heatOfReactionPerMole = -1 * (this.heatTransfer / this.molesOfReactantB);	
	}
	
	
	
	
	public double getChangeTemp () {
		return this.changeTemp;
	}
	
	
	
	
	public String toString() {
		return String.format("Constants\n"
				+ "---------\n"
				+ "Volume of Reactant A: 15.00mL\n"
				+ "Initial Temperature: 20.00°C\n"
				+ "=========\n\n"
				+ "User Input\n"
				+ "----------\n"
				+ "Volume of Reactant B: %.2fmL\n"
				+ "Final Temperature: %.2f°C\n"
				+ "==========\n\n"
				+ "Type of Reaction\n"
				+ "----------------\n"
				+ "%s\n"
				+ "%s = %s\n"
				+ "Density: %.2fg/mL\n"
				+ "Concentration: %.2fmol/L\n"
				+ "Specific Heat: %.2fkJ/kg°C\n"
				+ "===============\n\n"
				+ "Program Output\n"
				+ "--------------\n"
				+ "Total Volume: %.2fmL\n"
				+ "Change in Temperature: %.2f°C\n"
				+ "Mass of Solution: %.2fg\n"
				+ "Moles of Reactant B: %.3fmol\n"
				+ "Heat Transfer of Liquid: %.2fkJ\n"
				+ "Heat of Reaction Per Mole: %.2fkJ/mol\n"
				, this.volumeB, this.finalTemp, 
				this.reactionType, this.reactants, this.products, this.density, this.concentration, this.specificHeat, 
				this.volumeTotal, this.changeTemp, this.massGrams, this.molesOfReactantB, this.heatTransfer, this.heatOfReactionPerMole);
	}
	
}
