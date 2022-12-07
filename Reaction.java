package Discussion7_AcidsAndBases;

public class Reaction {

	//Reaction Attributes
	private String[] acidNames = {"HCl" , "NHO3"};
	private String acidName;
	private double[] acidVolumeAt7 = new double[2]; //first index is in mL, second is in L
	private double acidConcentration;
	private double acidpH;
	
	
	private String[] baseNames = 		  {"NaOH" , "KOH"};
	private String baseName;
	private double[] baseConcentrations = {.114   , .171};
	private double baseConcentration;
	private double molesOfBase;
	private double[] baseVolume = new double[2]; //first index is in mL, second is in L
	
	
	
	
	
	//Empty constructor to prevent NullPointerException
	public Reaction() {
		this.acidConcentration = 0;
		this.acidpH = 0;
		this.molesOfBase = 0;
		for (int i = 0; i < this.acidVolumeAt7.length; i++) {
			this.acidVolumeAt7[i] = 0;
			this.baseVolume[i] = 0;
		}
	}
	
	
	
	
	//Constructor and solutions
	public Reaction(int acidName , double acidVolumeAt7 , int baseName , double baseVolume) {
		
		this.acidName = this.acidNames[acidName];
		this.acidVolumeAt7[0] = acidVolumeAt7; //mL
		this.acidVolumeAt7[1] = acidVolumeAt7 / 1000; //L
		
		this.baseName = baseNames[baseName];
		this.baseVolume[0] = baseVolume; //mL
		this.baseVolume[1] = baseVolume / 1000; //L
		
		this.baseConcentration = baseConcentrations[baseName];
		this.molesOfBase = this.baseVolume[1] * this.baseConcentration;
		this.acidConcentration = this.molesOfBase / this.acidVolumeAt7[1];
		this.acidpH = Math.log10(acidConcentration) * -1;
		
	}
	
	
	
	
	
	public String getAcid() {
		return this.acidName;
	}
	public String getBase() {
		return this.baseName;
	}
	public double getAcidVolume() {
		return this.acidVolumeAt7[0];
	}
	public double getBaseVolume() {
		return this.baseVolume[0];
	}
	public double getMoles() {
		return this.molesOfBase;
	}
	public double getAcidConcentration() {
		return this.acidConcentration; 
	}
	public double getBaseConcentration() {
		return this.baseConcentration;
	}
	public double getAcidpH() {
		return this.acidpH;
	}
	
	
	
	
	
	
	//toString method
	public String toString() {
		return String.format("%s reacting with %s"
				+ "\n\n\n"
				+ "%.2f mL of acid %s at 7pH\n"
				+ "----------------------------------\n"
				+ "Moles of Acid: %.6fmol\n"
				+ "Acid Concentration: %.3fmol/L\n"
				+ "Acid pH: %.3f"
				+ "\n\n==================================\n\n"
				+ "%.2f mL of base %s as starting volume\n"
				+ "----------------------------------\n"
				+ "Moles of Base: %.6fmol\n"
				+ "Base Concentration: %.3fmol/L\n"
				, this.acidName , this.baseName
				, this.acidVolumeAt7[0] ,  this.acidName
				, this.molesOfBase
				, this.acidConcentration
				, this.acidpH
				, this.baseVolume[0] , this.baseName
				, this.molesOfBase
				, this.baseConcentration);
	}
	
	
	
	
	
	public boolean greaterThan(Reaction that) {
		if (this.baseVolume[0] > that.baseVolume[0]) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	public static Reaction[] sortBaseVolumes(Reaction[] reactions) {
		boolean swapped = true;
		int j = 0;
		Reaction temp = new Reaction();
		
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < reactions.length - j; i++) {
				if (reactions[i].greaterThan(reactions[i+1])) {
					temp = reactions[i];
					reactions[i] = reactions[i + 1];
					reactions[i + 1] = temp;
					swapped = true;
				}
			}
		}
		return reactions;
	}
	
	
	
	
	
	
}
