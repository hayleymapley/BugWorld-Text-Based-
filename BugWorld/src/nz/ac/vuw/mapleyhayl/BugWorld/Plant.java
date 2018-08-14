package nz.ac.vuw.mapleyhayl.BugWorld;

public class Plant implements WorldEntity {

	private int x;
	private int y;
	private int growth;
	
	public Plant(int x, int y, int growth) {
		this.x = x;
		this.y = y;
		this.growth = growth;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getSymbol() {
		String growthStr = Integer.toString(growth);
		char symbol = growthStr.charAt(0);
		return symbol;
	}

}
