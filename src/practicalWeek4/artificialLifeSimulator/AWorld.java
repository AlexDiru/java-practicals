package practicalWeek4.artificialLifeSimulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class AWorld {
	
	private Map map = new Map(25,15);
	private ArrayList<ABug> bugs = new ArrayList<ABug>();
	private Random random = new Random();
	
	public void printMap(boolean printBoundaries) {
		
		if (printBoundaries)
			map.printBorder();
		
		//Iterate rows
		for (String row : map.getCells()) {
			if (printBoundaries)
				System.out.print("|");
			
			System.out.print(row);
			
			if (printBoundaries)
				System.out.print("|");
			
			System.out.print("\n");
		}
		
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
	
	public Map getMap() {
		return map;
	}
}
