package practicalWeek6.artificialLifeConfiguration;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Class to represent an entity in the map
 * 
 * @author Alex
 * 
 */
public class ABug implements ALifeForm {

	/**
	 * Position of the bug on the map
	 */
	private Point position;

	/**
	 * The energy of the bug
	 */
	private int energy;

	/**
	 * The distance the bug can sense food
	 */
	private int maxSensingDistance;

	/**
	 * The world the bug belongs to
	 */
	private AWorld world;

	/**
	 * A random generator
	 */
	private Random random = new Random();

	/**
	 * The name of the bug
	 */
	private String name;

	/**
	 * The symbol of the bug
	 */
	private char symbol;

	/**
	 * A reader to read input
	 */
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Blank constructor generates a random ABug
	 */
	public ABug() {
		energy = 10;
		maxSensingDistance = 2;
		name = StringHelper.generateRandomName();
		symbol = (char) (random.nextInt((int)'A') + 25);
	}

	/**
	 * Allows the user to edit all the parameters of an ABug by typing into the
	 * console
	 */
	public void edit() {
		System.out.println("Name: ");
		try {
			name = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Energy: ");
		energy = InputHelper.readInteger(bufferedReader);

		System.out.println("Symbol: ");
		try {
			try {
				symbol = bufferedReader.readLine().charAt(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IndexOutOfBoundsException ex) {
		}

		position = new Point();

		System.out.println("X Position: ");
		position.x = InputHelper.readInteger(bufferedReader);

		System.out.println("Y Position: ");
		position.y = InputHelper.readInteger(bufferedReader);

		System.out.println("Sensing Distance: ");
		maxSensingDistance = InputHelper.readInteger(bufferedReader);
	}

	/**
	 * Constructor for the bug
	 * 
	 * @param n
	 *            Name
	 * @param s
	 *            Symbol
	 * @param m
	 *            Max Sensing Distance
	 */
	public ABug(String n, char s, int m) {
		energy = 10;
		maxSensingDistance = m;
		name = n;
		symbol = s;
	}

	/**
	 * Main function to test the class
	 */
	public void main() {
		printStats();
	}

	/**
	 * Prints all the stats of the bug
	 */
	public void printStats() {
		System.out.println(symbol + " " + name + ": " + " Energy = " + energy + " (" + position.x + "," + position.y + ")");
	}

	/**
	 * The direction the ABug moves in
	 * 
	 * @author Alex
	 */
	public enum Direction {
		North, South, East, West, None,
	}

	/**
	 * Checks if there is food in the vicinity of the bug
	 * 
	 * @param direction
	 *            The direction to search in
	 * @return Whether there is food
	 * @author Alex
	 */
	public boolean smellFood(Direction direction) {
		boolean isFood;
		for (int offset = 1; offset <= maxSensingDistance; offset++) {
			// Check North
			if (direction.equals(Direction.North)) {
				// Check food
				isFood = world.getMap().isFood(position.x, position.y + offset);
				// Check obstacle - bug cannot smell through an obstacle
				if (world.getMap().isObstacle(position.x, position.y + offset))
					return false;
			}
			// Check South
			else if (direction.equals(Direction.South)) {
				// Check food
				isFood = world.getMap().isFood(position.x, position.y - offset);
				// Check obstacle - bug cannot smell through an obstacle
				if (world.getMap().isObstacle(position.x, position.y - offset))
					return false;
			}
			// Check East
			else if (direction.equals(Direction.East)) {
				// Check food
				isFood = world.getMap().isFood(position.x - offset, position.y);
				// Check obstacle - bug cannot smell through an obstacle
				if (world.getMap().isObstacle(position.x - offset, position.y))
					return false;
			}
			// Check West
			else {
				// Check food
				isFood = world.getMap().isFood(position.x + offset, position.y);
				// Check obstacle - bug cannot smell through an obstacle
				if (world.getMap().isObstacle(position.x + offset, position.y))
					return false;
			}

			if (isFood)
				return true;
		}
		return false;
	}

	/**
	 * Gets a random direction
	 * 
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
	 * 
	 * @param direction
	 *            The direction to move in
	 * @return -1 if obstacle, 0 if nothing, 1 - 9 if food
	 */
	public int move(Direction direction) {
		Point newPosition;

		// Adjust the position according to the direction
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

		char mapCellValue;

		// Get the value of the map, if out of bounds return 0
		try {
			mapCellValue = world.getMap().getCells()[newPosition.y].toCharArray()[newPosition.x];
		} catch (Exception ex) {
			return 0;
		}

		if (mapCellValue == 'X')
			return -1;
		else if ((int) mapCellValue >= (int) '0' && (int) mapCellValue <= (int) '9') {
			position = newPosition;
			world.getMap().removeFood(newPosition.x, newPosition.y);
			return ((int) mapCellValue - (int) '0');
		} else {
			position = newPosition;
			return 0;
		}
	}

	/**
	 * Gets the direction of the closest food
	 * 
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
