package practicalWeek4.artificialLifeSimulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class AWorld {
	
	private Map map;
	private ArrayList<ABug> bugs = new ArrayList<ABug>();
	private Random random = new Random();
	
	public AWorld(int xSize, int ySize) {
		map = new Map(xSize, ySize);
	}
	
	public void printMap(boolean printBoundaries) {
		
		if (printBoundaries)
			map.printBorder();
		
		ArrayList<String> mapList = new ArrayList<String>();
		
		//Iterate rows
		for (String row : map.getCells()) {
			
			String mapRow = "";
			
			if (printBoundaries)
				mapRow += "|";
			
			mapRow += row;
			
			if (printBoundaries)
				mapRow += "|";
			
			mapList.add(mapRow);
		}
		
		//Insert bugs in map
		for (ABug bug : bugs) {
			//Get the row
			char[] row = mapList.get(bug.getPosition().y).toCharArray();
			//Insert the bug
			row[bug.getPosition().x + 1] = bug.getSymbol();
			
			mapList.set(bug.getPosition().y, new String(row));
		}
		
		//Print mapList
		for (String line : mapList)
			System.out.println(line);
		
		if (printBoundaries)
			map.printBorder();
	}
	
	/**
	 * Gets a random space on the map that is open space 
	 * @return Random empty coordinates
	 */
	public Point getUnoccupiedPosition() {
		Point position = new Point();
		
		//Do while empty space not found
		do {
			position.x = random.nextInt(map.getXSize());
			position.y = random.nextInt(map.getYSize());
		} while (map.getCells()[position.y].toCharArray()[position.x] != ' ' && !isBugAtPosition(position));
		
		return position;
	}
	
	private boolean isBugAtPosition(Point position) {
		for (ABug bug : bugs)
			if (bug.getPosition() != null)
				if (bug.getPosition().equals(position))
						return true;
		return false;
	}
	
	/**
	 * Adds the bug to the world
	 * @param b The bug to add
	 */
	public void addBug(ABug b) {
		bugs.add(b);
		b.setWorld(this);
		
		//Get a position for the bug
		b.setPosition(getUnoccupiedPosition());
	}
	
	public void main(int numberOfCycles) {
		for (int n = 0; n < numberOfCycles; n++) {
			//For each bug
			//Perform sensing-moving-eating
			for (ABug bug : bugs) {
				//Check if nearby food
				ABug.Direction direction = bug.getDirectionOfFood();
				
				if (direction.equals(ABug.Direction.None)) {
					//No food, so move in a random direction (if possible)
					bug.move(bug.getRandomDirectionToMove());
				} else {
					//Else food, so prepare to increase the energy by the amount of food
					bug.setEnergy(bug.getEnergy() + bug.move(direction));
				}	
			}
			
			printMap(true);
			printStats();
		}
	}
	
	/**
	 * Prints the stats of each bug in the map
	 */
	public void printStats() {
		for (ABug bug : bugs)
			bug.printStats();
	}
	
	public Map getMap() {
		return map;
	}
}
