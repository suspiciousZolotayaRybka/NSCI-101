package Discussion6_HeatOfReaction;

public class ExothermicReaction extends Reaction{

	public ExothermicReaction (double volumeB,
			double finalTemp) {
		super("silver nitrate (AgNO3) + sodium chloride (NaCl)", "sodium nitrate (NaNO3) + silver chloride (AgCl)", "Exothermic"
				, volumeB, finalTemp, 1.45, 6.00, 3.35);
	}

}
