package nz.ac.vuw.mapleyhayl.BugWorld;

public class Bug implements WorldEntity {
	
	private String species = "Bug";
	private String name = "Unknown";
	private char symbol = '?';
	protected boolean herbivorous = true;
	protected int smellRange = 5;
	protected int x;
	protected int y;
	protected int energy = 3;
	protected int uniqueID = 1;
	protected static int countID = 1;
	
	public Bug() {
		uniqueID = countID;
		countID++;
	}
	
	public Bug(String species, String name, char symbol, int x, int y, int energy) {
		this.species = species;
		this.name = name;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.energy = energy;
		this.uniqueID = countID;
		countID++;
	}
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public boolean getHerbivorous() {
		return herbivorous;
	}
	public void setHerbivorous(boolean herbivorous) {
		this.herbivorous = herbivorous;
	}
	
	public int getSmellRange() {
		return smellRange;
	}
	public void setSmellRange(int smellRange) {
		this.smellRange = smellRange;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public String toString() {
		return "["+uniqueID+"] " + "Species: " + species + "\n\tName:  " + name + "\n" +
				"\tSymbol: " + symbol + "\n\tHerbivore: " + herbivorous + "\n\tEnergy: " + 
				energy;
	}
	
	public String toText() {
		return "["+uniqueID+"] " + species + "\n" + name + "\n" + symbol +
				"\n" + x + " " + y + "\n" + energy + "\n" + "Herbivore=" + herbivorous + "\n";
	}
}
