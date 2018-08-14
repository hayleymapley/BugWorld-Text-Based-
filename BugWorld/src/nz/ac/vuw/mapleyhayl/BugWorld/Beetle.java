package nz.ac.vuw.mapleyhayl.BugWorld;

public class Beetle extends Bug {

	private String species = "Beetle";
	private char symbol = '@';
	private int energy = 2;
	private boolean herbivorous = true;
	private int smellRange = 5;
	
	public Beetle() {
		super();
		this.setSpecies(species);
		this.setSymbol(symbol);
		this.setEnergy(energy);
		this.setHerbivorous(herbivorous);
		this.setSmellRange(smellRange);
	}
	
	public Beetle(String species, String name, char symbol, int x, int y, int energy) {
		super(species, name, symbol, x, y, energy);
	}

}
