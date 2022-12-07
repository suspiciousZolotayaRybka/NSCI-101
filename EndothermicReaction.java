package Discussion6_HeatOfReaction;

public class EndothermicReaction extends Reaction{

	public EndothermicReaction(double volumeB, 
			double finalTemp) {
		super("hydrochloric acid (HCl) + sodium bicarbonate (NaHCO3)", "sodium chloride (NaCl) + water (H20) + carbon dioxide (CO2)" , "endothermic"
				, volumeB, finalTemp, 1.15, 7.00, 2.93);
	}
}
