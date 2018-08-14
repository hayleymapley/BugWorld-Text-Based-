package nz.ac.vuw.mapleyhayl.BugWorld;

public class Butterfly extends Bug {

	private String species = "Butterfly";
	private char symbol = '%';
	private int energy = 4;
	private boolean herbivorous = true;
	private int smellRange = 6;
	
	public Butterfly() {
		super();
		this.setSpecies(species);
		this.setSymbol(symbol);
		this.setEnergy(energy);
		this.setHerbivorous(herbivorous);
		this.setSmellRange(smellRange);
	}
	
	public Butterfly(String species, String name, char symbol, int x, int y, int energy) {
		super(species, name, symbol, x, y, energy);
	}

}
