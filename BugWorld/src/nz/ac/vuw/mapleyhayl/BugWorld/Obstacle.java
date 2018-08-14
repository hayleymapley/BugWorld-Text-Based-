package nz.ac.vuw.mapleyhayl.BugWorld;

public class Obstacle implements WorldEntity {
	
	private static char symbol = '#';
	private int x;
	private int y;
	
	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public char getSymbol() {
		return symbol;
	}
	
	public String toString() {
		return "["+x+" "+y+"]";
	}
	
}
