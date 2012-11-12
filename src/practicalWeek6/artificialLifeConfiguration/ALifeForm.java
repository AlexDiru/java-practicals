package practicalWeek6.artificialLifeConfiguration;

import java.awt.Point;

import practicalWeek6.artificialLifeConfiguration.ABug.Direction;

public interface ALifeForm {
	/**
	 * Main function to test the class
	 */
	public void main();
	
	/**
	 * Prints all the stats of the bug
	 */
	public void printStats();
	
	/**
	 * Checks if there is food in the vicinity of the bug
	 * @param direction The direction to search in
	 * @return Whether there is food
	 * @author Alex
	 */
	public boolean smellFood(Direction direction);
	
	/**
	 * Gets a random direction
	 * @return The direction
	 */
	public Direction getRandomDirectionToMove();
	
	/**
	 * Moves in a direction
	 * @return -1 if obstacle, 0 if nothing, 1 - 9 if food
	 */
	public int move(Direction direction);
	
	/**
	 * Gets the direction of the closest food
	 * @return The direction of the closest food
	 */
	public Direction getDirectionOfFood();
}
