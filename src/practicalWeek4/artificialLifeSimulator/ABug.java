package practicalWeek4.artificialLifeSimulator;

import java.awt.Point;
import java.util.Random;

public class ABug {

	private Point position;
	private int energy;
	private int maxSensingDistance;
	private AWorld world;
	private Random random = new Random();
	private String name;
	private char symbol;
	
	public ABug(String n, char s, int m) {
		energy = 10;
		maxSensingDistance = m;
		name = n;
		symbol = s;
	}
	
	/** 
	 * The direction the ABug moves in
	 * @author Alex
	 */
	public enum Direction {
		North, South, East, West, None,
	}
	
	/**
	 * Checks if there is food in the vicinity of the bug
	 * @param direction The direction to search in
	 * @return Whether there is food
	 * @author Alex
	 */
	public boolean smellFood(Direction direction) {
		boolean isFood;
		for (int offset = 1; offset <= maxSensingDistance; offset++) {
			if (direction.equals(Direction.North))
				isFood = world.getMap().isFood(position.x, position.y + offset);
			else if (direction.equals(Direction.South))
				isFood = world.getMap().isFood(position.x, position.y - offset);
			else if (direction.equals(Direction.East))
				isFood = world.getMap().isFood(position.x - offset, position.y);
			else
				isFood = world.getMap().isFood(position.x + offset, position.y);
			
			if (isFood)
				return true;
		}
		return false;
	}
	
	/**
	 * Gets a random direction
	 * @return The direction
	 */
	public Direction getRandomDirectionToMove() {
		int r = random.nextInt(4);
		
		switch (r) {
		case 0:
			return Direction.North;
		case 1:
			return Direction.East;
		case 2:
			return Direction.South;
		case 3:
			return Direction.West;
		}
		
		return Direction.None;
	}
	
	/**
	 * Moves in a direction
	 * @param direction The direction to move in
	 * @return -1 if obstacle, 0 if nothing, 1 - 9 if food
	 */
	public int move(Direction direction) {
		Point newPosition;
		if (direction.equals(Direction.North))
			newPosition = new Point(position.x, position.y + 1);
		else if (direction.equals(Direction.South))
			newPosition = new Point(position.x, position.y - 1);
		else if (direction.equals(Direction.East))
			newPosition = new Point(position.x - 1, position.y);
		else if (direction.equals(Direction.West))
			newPosition = new Point(position.x + 1, position.y);
		else
			return 0;
		
		char mapCellValue = world.getMap().getCells()[newPosition.y].toCharArray()[newPosition.x];
		
		if (mapCellValue == 'X')
			return -1;
		else if ((int)mapCellValue >= (int)'0' && (int)mapCellValue <= (int)'9')
			return ((int)mapCellValue - (int)'0');
		else
			return 0;
	}
	
	/**
	 * Gets the direction of the closest food
	 * @return The direction of the closest food
	 */
	public Direction getDirectionOfFood() {
		if (smellFood(Direction.North))
			return Direction.North;
		else if (smellFood(Direction.East))
			return Direction.East;
		else if (smellFood(Direction.South))
			return Direction.South;
		else if (smellFood(Direction.West))
			return Direction.West;
		
		return Direction.None;
	}
	
	public void setWorld(AWorld a) {
		world = a;
	}
	
	public AWorld getWorld() {
		return world;
	}
	
	public void setEnergy(int e) {
		energy = e;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setMaxSensingDistance(int m) {
		maxSensingDistance = m;
	}
	
	public int getMaxSensingDistance() {
		return maxSensingDistance;
	}
	
	public void setPosition(Point p) {
		position = p;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public void setSymbol(char c) {
		symbol = c;
	}

	public char getSymbol() {
		return symbol;
	}

}
