package practicalWeek4.artificialLifeSimulator;

import java.awt.Point;
import java.util.Random;

public class ABug {

	private Point position;
	private int energy;
	private int maxSensingDistance;
	private AWorld world;
	private Random random = new Random();
	
	
	/** The direction the ABug moves in
	 * 
	 * @author Alex
	 *
	 */
	public enum Direction {
		North,
		South,
		East,
		West,
		None,
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
	
	public int move(Direction direction) {
		
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
}
