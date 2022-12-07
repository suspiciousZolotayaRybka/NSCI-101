package Discussion5_Radiation;

public class Isotope {

	//Isotope attributes
	private String isotopeName;
	private double time;
	private String unitOfTime;
	
	//getters
	public String getIsotopeName() {
		return this.isotopeName;
	}
	public double getTime() {
		return this.time;
	}
	public String getUnitOfTime() {
		return this.unitOfTime;
	}
	
	//setters
	public void setIsotopeName(String name) {
		this.isotopeName = name;
	}
	public void setIsotopeTime(double time) {
		this.time = time;
	}
	
	//constructor
	public Isotope() {
		this.isotopeName = "noName";
		this.time = 0;
		this.unitOfTime = "noUnitOfTime";
	}
	public Isotope(String name , double time , String unit) {
		isotopeName = name;
		this.time = time;
		unitOfTime = unit;
	}
	
	
	
	
	public String timeToString() {
		return String.format("%.2f %s"
				, this.time , this.unitOfTime);
	}
	
	
	
	
	
	
	public boolean greaterThan(Isotope that) {
		if (this.time > that.time) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	public static Isotope[] sortTime(Isotope[] isotopes) {
		boolean swapped = true;
		int j = 0;
		Isotope temp = new Isotope();
		
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < isotopes.length - j; i++) {
				if(isotopes[i].time > isotopes[i + 1].time) {
					temp = isotopes[i];
					isotopes[i] = isotopes[i + 1];
					isotopes[i + 1] = temp;
					swapped = true;
				}
			}
		}
		return isotopes;
	}
	
}
