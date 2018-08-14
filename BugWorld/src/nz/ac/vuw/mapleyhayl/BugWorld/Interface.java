package nz.ac.vuw.mapleyhayl.BugWorld;

import java.util.*;

public class Interface {

	private ArrayList<Bug> allBugs = new ArrayList<Bug>();
	private ArrayList<Obstacle> allObstacles = new ArrayList<Obstacle>();
	private ArrayList<Plant> allPlants = new ArrayList<Plant>();
	private ArrayList<WorldEntity> allEntities = new ArrayList<WorldEntity>();
	Scanner in = new Scanner(System.in);
	World currentWorld = new World(allBugs);

	public Interface() {
		this.tasks();
	}

	//prints options menu
	public void tasks() {
		int ans;
		System.out.println("\n---- MENU ----\n");
		System.out.println("[1] Add a bug");
		System.out.println("[2] Add an obstacle");
		System.out.println("[3] Add a plant");
		System.out.println("[4] Display all bugs");
		System.out.println("[5] View all bugs' attributes");
		System.out.println("[6] Move bug");
		System.out.println("[7] Randomly move bug");
		System.out.println("[8] Display world");
		System.out.println("[9] Update world");
		System.out.println("[10] Populate world");
		ans = in.nextInt();
		if (ans == 1) {
			this.addBug();
		} else if (ans == 2) {
			this.addObstacle();
		} else if (ans == 3) {
			this.addPlant();
		} else if (ans == 4) {
			this.displayBugs();
		} else if (ans == 5) {
			this.viewBugAttributes();
		} else if (ans == 6) {
			this.moveBug();
		} else if (ans == 7) {
			this.randomMoveBug();
		} else if (ans == 8) {
			this.displayWorld();
		} else if (ans == 9) {
			this.updateWorld();
		} else if (ans == 10) {
			this.populateWorld();
		} else {
			System.out.println("Please enter a valid option: ");
			this.tasks();
		}
		in.close();
	}

	//adds obstacle to allObstacles and allEntities array lists
	public void addObstacle() {
		System.out.println("How many obstacles would you like to add?");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			int randomX = randomiseX();
			int randomY = randomiseY();
			while (currentWorld.isEntityPresent(randomX, randomY)) {
				randomX = randomiseX();
				randomY = randomiseY();
			}
			Obstacle newO = new Obstacle(randomX, randomY);
			allObstacles.add(newO);
			allEntities.add(newO);
		}
		this.displayWorld();
		this.tasks();
	}
	
	//adds bug to allBugs and allEntities array lists - options to add default or custom bug
	public void addBug() {
		int ans = 0;
		System.out.println("----------------------\n");
		System.out.println("Do you want to add a default bug or a custom bug?");
		System.out.println("[1] Add a default bug");
		System.out.println("[2] Add a custom bug");
		System.out.println(": ");
		ans = in.nextInt();
		in.nextLine();
		if (ans == 1) {
			System.out.println("Choose default bug type: ");
			System.out.println("[1] Bug");
			System.out.println("[2] Beetle");
			System.out.println("[3] Bumblebee");
			System.out.println("[4] Butterfly");
			int res = in.nextInt();
			if (res == 1) {
				Bug defaultBug = new Bug();
				int randomX = randomiseX();
				int randomY = randomiseY();
				while (currentWorld.isEntityPresent(randomX, randomY)) {
					randomX = randomiseX();
					randomY = randomiseY();
				}
				defaultBug.setX(randomX);
				defaultBug.setY(randomY);
				allBugs.add(defaultBug);
				allEntities.add(defaultBug);
				this.displayWorld();
			} else if (res == 2) {
				Beetle defaultBeetle = new Beetle();
				int randomX = randomiseX();
				int randomY = randomiseY();
				while (currentWorld.isEntityPresent(randomX, randomY)) {
					randomX = randomiseX();
					randomY = randomiseY();
				}				
				defaultBeetle.setX(randomiseX());
				defaultBeetle.setY(randomiseY());
				allBugs.add(defaultBeetle);
				allEntities.add(defaultBeetle);
				this.displayWorld();
			} else if (res == 3) {
				Bumblebee defaultBumblebee = new Bumblebee();
				int randomX = randomiseX();
				int randomY = randomiseY();
				while (currentWorld.isEntityPresent(randomX, randomY)) {
					randomX = randomiseX();
					randomY = randomiseY();
				}
				defaultBumblebee.setX(randomiseX());
				defaultBumblebee.setY(randomiseY());
				allBugs.add(defaultBumblebee);
				allEntities.add(defaultBumblebee);
				this.displayWorld();
			} else if (res == 4) {
				Butterfly defaultButterfly = new Butterfly();
				int randomX = randomiseX();
				int randomY = randomiseY();
				while (currentWorld.isEntityPresent(randomX, randomY)) {
					randomX = randomiseX();
					randomY = randomiseY();
				}
				defaultButterfly.setX(randomiseX());
				defaultButterfly.setY(randomiseY());
				allBugs.add(defaultButterfly);
				allEntities.add(defaultButterfly);
				this.displayWorld();
			}
		} else if (ans == 2) {
			//prompt for attributes
			System.out.println("Please enter the species of the new bug: ");
			System.out.println("[1] Beetle");
			System.out.println("[2] Bumblebee");
			System.out.println("[3] Butterfly");
			int species = in.nextInt();
			in.nextLine();
			System.out.println("Please enter the name of the new bug: ");
			String name = in.nextLine();
			System.out.println("Please enter the symbol of the new bug: ");
			char symbol = in.next().charAt(0);
			int randomX = randomiseX();
			int randomY = randomiseY();
			while (currentWorld.isEntityPresent(randomX, randomY)) {
				randomX = randomiseX();
				randomY = randomiseY();
			}		
			System.out.println("Please enter the energy level of the new bug: ");
			int energy = in.nextInt();
			//create bug
			if (species == 1) {
				String speciesStr = "Beetle";
				Beetle newBeetle = new Beetle(speciesStr, name, symbol, randomX, randomY, energy);
				//add bug to list
				allBugs.add(newBeetle);
				allEntities.add(newBeetle);
			} else if (species == 2) {
				String speciesStr = "Bumblebee";
				Bumblebee newBumblebee = new Bumblebee(speciesStr, name, symbol, randomX, randomY, energy);
				allBugs.add(newBumblebee);
				allEntities.add(newBumblebee);
			} else if (species == 3) {
				String speciesStr = "Butterfly";
				Butterfly newButterfly = new Butterfly(speciesStr, name, symbol, randomX, randomY, energy);
				allBugs.add(newButterfly);
				allEntities.add(newButterfly);
			}
			this.displayWorld();
		} else {
			System.out.println("Please enter a valid option: ");
			this.addBug();
		}
		this.tasks();
	}

	//adds plants to allPlants and allEntities array lists - prompts for number to add
	public void addPlant() {
		System.out.println("How many plants would you like to add?");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			int randomX = randomiseX();
			int randomY = randomiseY();
			while (currentWorld.isEntityPresent(randomX, randomY)) {
				randomX = randomiseX();
				randomY = randomiseY();
			}
			int growth = (int) Math.floor(Math.random()*9);
			Plant newP = new Plant(randomX, randomY, growth);
			allPlants.add(newP);
			allEntities.add(newP);
		}
		this.displayWorld();
		this.tasks();
	}
	
	//asks user for ID of bug and then moves the bug according to the direction and distance specified by the user
	public void moveBug() {
		System.out.println("Please enter the ID of the bug you wish to move: ");
		int ans = in.nextInt();
		if (allBugs.size() >= ans) {
			Bug movingBug = allBugs.get(ans-1);
			System.out.println("Please enter how far you wish to move the bug: ");
			int distance = in.nextInt();
			in.nextLine();
			System.out.println("Please enter the direction you wish the bug to move: (N, S, E, W)");
			String direction = in.nextLine().toLowerCase();
			switch (direction) {
			case "n" :
				movingBug.setY(movingBug.getY()-distance);
				break;
			case "s" :
				movingBug.setY(movingBug.getY()+distance);
				break;
			case "e" :
				movingBug.setX(movingBug.getX()+distance);
				break;
			case "w" :
				movingBug.setX(movingBug.getX()-distance);
				break;
			}
		} else {
			System.out.println("No such bug exists!");
		}
		this.displayWorld();
		this.tasks();
	}

	//asks user for ID of bug and then moves the bug in a random direction 50 times
	public void randomMoveBug() {
		System.out.println("Please enter the ID of the bug you wish to move: ");
		int ans = in.nextInt();
		if (allBugs.size() >= ans) {
			Bug movingBug = allBugs.get(ans-1);
			int currentX = movingBug.getX();
			int currentY = movingBug.getY();
			for (int i=0; i<50; i++) {
				int direction = (int) Math.ceil(Math.random()*4); //1=N, 2=S, 3=E, 4=W
				int distance = 1;
				switch (direction) {
				case 1 : //north
					int newUpY = movingBug.getY()-distance;
					if (newUpY >= 2 && newUpY <= currentWorld.getHeight()-1 && !currentWorld.isEntityPresent(currentX, newUpY)) {
						movingBug.setY(newUpY);
					}
					break;
				case 2 : //south
					int newDownY = movingBug.getY()+distance;
					if (newDownY >= 2 && newDownY <= currentWorld.getHeight()-1 && !currentWorld.isEntityPresent(currentX, newDownY)) {
						movingBug.setY(newDownY);
					}
					break;
				case 3 : //east
					int newRightX = movingBug.getX()+distance;
					if (newRightX >= 2 && newRightX <= currentWorld.getHeight()-1 && !currentWorld.isEntityPresent(newRightX, currentY)) {
						movingBug.setX(newRightX);
					}
					break;
				case 4 : //west
					int newLeftX = movingBug.getX()-distance;
					if (newLeftX >= 2 && newLeftX <= currentWorld.getHeight()-1 && !currentWorld.isEntityPresent(newLeftX, currentY)) {
						movingBug.setX(newLeftX);
					}
					break;
				}
			}
		} else {
			System.out.println("No such bug exists!");
		}
		this.displayWorld();
		this.tasks();
	}

	//prints a summary of the important attributes of each bug
	public void displayBugs() {
		if (allBugs.size() != 0) {
			for (Bug b : allBugs) {
				System.out.println(b.toString());
			}
		} else {
			System.out.println("No bugs to display yet!\n");
		}
		this.tasks();
	}
	
	//prints all attributes of each bug
	public void viewBugAttributes() {
		if (allBugs.size() != 0) {
			for (Bug b : allBugs) {
				System.out.println(b.toText());
			}
		} else {
			System.out.println("No bugs to view yet!");
		}
		this.tasks();
	}

	//sends all array lists to currentWorld object and draws the world
	public void displayWorld() {
		currentWorld.setBugsInWorld(allBugs);
		currentWorld.setObstaclesInWorld(allObstacles);
		currentWorld.setPlantsInWorld(allPlants);
		currentWorld.setAllWorldEntities(allEntities);
		currentWorld.drawWorld();
		this.tasks();
	}

	//asks user for number of bugs, then for each bug randomly picks a species and position
	public void populateWorld() {
		System.out.println("Please enter the number of bugs you wish to add: ");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			//choose type of bug 1-4 1=bug 2=beetle 3=bumblebee 4=butterfly
			int bugType = (int) Math.ceil(Math.random()*4);
			//create new default bug of that type and randomise its position, then add it to the allBugs array
			switch (bugType) {
			case 1 :
				Bug newBug = new Bug();
				int randomBugX = randomiseX();
				int randomBugY = randomiseY();
				while (currentWorld.isEntityPresent(randomBugX, randomBugY)) {
					randomBugX = randomiseX();
					randomBugY = randomiseY();
				}
				newBug.setX(randomBugX);
				newBug.setY(randomBugY);
				allBugs.add(newBug);
				allEntities.add(newBug);
				break;
			case 2 :
				Beetle newBeetle = new Beetle();
				int randomBeetleX = randomiseX();
				int randomBeetleY = randomiseY();
				while (currentWorld.isEntityPresent(randomBeetleX, randomBeetleY)) {
					randomBeetleX = randomiseX();
					randomBeetleY = randomiseY();
				}
				newBeetle.setX(randomBeetleX);
				newBeetle.setY(randomBeetleY);
				allBugs.add(newBeetle);
				allEntities.add(newBeetle);
				break;
			case 3 :
				Bumblebee newBumblebee = new Bumblebee();
				int randomBumblebeeX = randomiseX();
				int randomBumblebeeY = randomiseY();
				while (currentWorld.isEntityPresent(randomBumblebeeX, randomBumblebeeY)) {
					randomBumblebeeX = randomiseX();
					randomBumblebeeY = randomiseY();
				}
				newBumblebee.setX(randomBumblebeeX);
				newBumblebee.setY(randomBumblebeeY);
				allBugs.add(newBumblebee);
				allEntities.add(newBumblebee);
				break;
			case 4:
				Butterfly newButterfly = new Butterfly();
				int randomButterflyX = randomiseX();
				int randomButterflyY = randomiseY();
				while (currentWorld.isEntityPresent(randomButterflyX, randomButterflyY)) {
					randomButterflyX = randomiseX();
					randomButterflyY = randomiseY();
				}
				newButterfly.setX(randomButterflyX);
				newButterfly.setY(randomButterflyY);
				allBugs.add(newButterfly);
				allEntities.add(newButterfly);
				break;
			}
		}
		this.displayWorld();
		this.tasks();
	}
	
	//moves each bug the number of time specified by their energy level, in a random direction
	public void updateWorld() {
		currentWorld.updateWorld();
		this.tasks();
	}
	
	//returns a random Y coordinate
	public int randomiseY() {
		int min = 2;
		int max = currentWorld.getHeight()-1;
		int range = (max-min) + 1;
		return (int) (Math.random() * range) + min;
	}
	
	//returns a random X coordinate
	public int randomiseX() {
		int min = 2;
		int max = currentWorld.getWidth()-1;
		int range = (max-min) + 1;
		return (int) (Math.random() * range) + min;
	}
	
	//MAIN
	public static void main(String[] args) {
		System.out.println("Welcome to Bug World!");
		new Interface();
	}

}
