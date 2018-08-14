package nz.ac.vuw.mapleyhayl.BugWorld;

public class Bumblebee extends Bug {

	private String species = "Bumblebee";
	private char symbol = '$';
	private int energy = 3;
	private boolean herbivorous = true;
	private int smellRange = 7;
	
	public Bumblebee() {
		super();
		this.setSpecies(species);
		this.setSymbol(symbol);
		this.setEnergy(energy);
		this.setHerbivorous(herbivorous);
		this.setSmellRange(smellRange);
	}

	public Bumblebee(String species, String name, char symbol, int x, int y, int energy) {
		super(species, name, symbol, x, y, energy);
	}
	
}
