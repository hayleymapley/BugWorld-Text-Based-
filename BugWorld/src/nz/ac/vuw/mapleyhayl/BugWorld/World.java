package nz.ac.vuw.mapleyhayl.BugWorld;

import java.util.*;

public class World {

	private ArrayList<Bug> bugsInWorld = new ArrayList<Bug>();
	private ArrayList<Obstacle> obstaclesInWorld = new ArrayList<Obstacle>();
	private ArrayList<Plant> plantsInWorld = new ArrayList<Plant>();
	private ArrayList<WorldEntity> allWorldEntities = new ArrayList<WorldEntity>();
	private  int height = 20;
	private int width = 50;

	public World(ArrayList<Bug> bugsInWorld) {
		this.bugsInWorld = bugsInWorld;
	}

	public void drawWorld() {
		for (int i=0; i<=height; i++) {
			System.out.print("|");
			for (int j=0; j<width; j++) {
				if (i==0 || i==height) {
					System.out.print("-");
				} else {
					//prints result of method that checks all bugs x and y coordinates, return symbol if matches, else prints " "
					System.out.print(checkCoords(j+1, i+1));
				}
			}
			System.out.println("|");
		}
	}

	public void updateWorld() {
		//update positions of each bug
		for (int i=0; i<bugsInWorld.size(); i++) {
			Bug movingBug = bugsInWorld.get(i);
			int currentX = movingBug.getX();
			int currentY = movingBug.getY();
			int direction = (int) Math.ceil(Math.random()*4); //1=N, 2=S, 3=E, 4=W
			int distance = 1;
			for (int j=0; j<movingBug.getEnergy(); j++) {
				switch (direction) {
				case 1 : //north
					int newUpY = movingBug.getY()-distance;
					if (newUpY >= 2 && newUpY <= height-1 && !isEntityPresent(currentX, newUpY)) {
						movingBug.setY(newUpY);
					}
					break;
				case 2 : //south
					int newDownY = movingBug.getY()+distance;
					if (newDownY >= 2 && newDownY <= height-1 && !isEntityPresent(currentX, newDownY)) {
						movingBug.setY(newDownY);
					}
					break;
				case 3 : //east
					int newRightX = movingBug.getX()+distance;
					if (newRightX >= 2 && newRightX <= width-1 && !isEntityPresent(newRightX, currentY)) {
						movingBug.setX(newRightX);
					}
					break;
				case 4 : //west
					int newLeftX = movingBug.getX()-distance;
					if (newLeftX >= 2 && newLeftX <= width-1 && !isEntityPresent(newLeftX, currentY)) {
						movingBug.setX(newLeftX);
					}
					break;
				}
				//shows each bugs individual movement
				try {
					Thread.sleep(75);
				} catch (Exception e) {};
				this.drawWorld();
			}
		}
	}

	public boolean isEntityPresent(int x, int y) {
		for (WorldEntity w : allWorldEntities) {
			if (w.getX()==x && w.getY()==y) {
				return true;
			}
		}
		return false;
	}
	
	public char checkCoords(int x, int y) {
		for (WorldEntity w : allWorldEntities) {
			if (w.getX()==x && w.getY()==y) {
				return w.getSymbol();
			}
		}		
		return ' ';
	}

	public void setBugsInWorld(ArrayList<Bug> bugsInWorld) {
		this.bugsInWorld = bugsInWorld;
	}
	
	public void setObstaclesInWorld(ArrayList<Obstacle> obstaclesInWorld) {
		this.obstaclesInWorld = obstaclesInWorld;
	}
	
	public void setPlantsInWorld(ArrayList<Plant> plantsInWorld) {
		this.plantsInWorld = plantsInWorld;
	}
	
	public void setAllWorldEntities(ArrayList<WorldEntity> allWorldEntities) {
		this.allWorldEntities = allWorldEntities;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
