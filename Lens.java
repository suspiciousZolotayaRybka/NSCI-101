package Discussion4_LensesAndMirrors;

public class Lens {

	//Initialize variables
	private double focalPoint;
	private double distanceObject;
	private double distanceScreen;
	
	
	
	
	
	
	//Provide constructor
	public Lens(double value) {
		this.focalPoint = value;
		this.distanceObject = focalPoint * 2;
		this.distanceScreen = focalPoint * 2;
	}
	
	
	
	
	
	public String toString() {
		double secondLargeDistance = this.focalPoint * 3;
		double secondSmallDistance = (this.focalPoint * 2) - (.5 * this.focalPoint) ;//(Math.pow(this.distanceObject , 2) / this.focalPoint -
				  //                          Math.pow(this.distanceObject , 2) / this.distanceScreen);
		return String.format("Lens with a focal point of %.1f centimeters\n"
						   + "===========================================\n"
						   + "No magnification\n"
						   + "----------------\n"
						   + "Object Distance: %.1fcm\n"
						   + "Screen Distance (behind Lens): %.1fcm\n"
						   + "\n"
						   + "Positive magnification (larger image)\n"
						   + "------------------------------------\n"
						   + "Object Distance: %.1fcm\n"
						   + "Screen Distance (behind Lens): %.1fcm\n"
						   + "\n"
						   + "Negative magnification (smaller image)\n"
						   + "-------------------------------------\n"
						   + "Object Distance: %.1fcm\n"
						   + "Screen Distance (behind Lens): %.1fcm\n"
						   + "\n"
						   , this.focalPoint , this.distanceObject , this.distanceScreen
						   , secondLargeDistance , secondSmallDistance
						   , secondSmallDistance , secondLargeDistance);
	}
}
