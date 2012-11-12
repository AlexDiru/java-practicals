package practicalWeek6.artificialLifeConfiguration;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	
	private int xSize;
	private int ySize;
	private String[] cells;
	private Random random = new Random();
	
	//How often an obstacle appears on the map
	private int obstacleFrequency = 5;
	
	//How often food appears on the map
	private int foodFrequency = 4;
	
	/**
	 * Randomly generates the map
	 * @param x The XSize of the map
	 * @param y The YSize of the map
	 * @author Alex
	 */
	public Map(int x, int y) {
		xSize = x;
		ySize = y;
		
		ArrayList<String> generatedCells = new ArrayList<String>();
		
		for (y = 0; y < ySize; y++) {
			//Add an empty string for the row
			generatedCells.add("");
			for (x = 0; x < xSize; x++) {
				//Generate the random cell
				int r = random.nextInt(100);
				
				char toAdd;
				
				//Obstacle?
				if (r < obstacleFrequency)
					toAdd = 'X';
				//Food?
				else if (r < obstacleFrequency + foodFrequency)
					//Get a random single digit
					toAdd = (char)('0' + (random.nextInt(9) + 1));
				//Blank
				else
					toAdd = ' ';
				
				generatedCells.set(generatedCells.size()-1, generatedCells.get(generatedCells.size()-1) + toAdd);
			}
		}
		
		cells = generatedCells.toArray(new String[generatedCells.size()]);
	}
	
	/**
	 * Checks if a cell has food on it
	 * @param x The x position of the cell to check
	 * @param y The y position of the cell to check
	 * @return Whether or not the food exists on the cell
	 * @author Alex
	 */
	public boolean isFood(int x, int y) {
		//Check if the cell is between '0' and '9'
		try {
			int cellValue = (cells[y].toCharArray()[x] - '0');
			return cellValue >= 0 && cellValue <= 9;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * Removes the food at a cell
	 * @param x X position of the cell
	 * @param y Y position of the cell
	 */
	public void removeFood(int x, int y) {
		char[] row = cells[y].toCharArray();
		row[x] = ' ';
		cells[y] = new String(row);
	}
	
	/**
	 * Checks if a cell has food on it
	 * @param x The x position of the cell to check
	 * @param y The y position of the cell to check
	 * @return Whether or not the food exists on the cell
	 * @author Alex
	 */
	public boolean isObstacle(int x, int y) {
		//Check if the cell is between '0' and '9'
		try {
			return cells[y].toCharArray()[x] == 'X';
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * Prints a border which will fit above or below the map
	 * @author Alex
	 */
	public void printBorder() {
		System.out.print("|");
		for (int x = 0; x < xSize; x++)
			System.out.print("-");
		System.out.print("|\n");
	}
	
	public String[] getCells() {
		return cells;
	}
	
	public int getXSize() {
		return xSize;
	}
	
	public int getYSize() {
		return ySize;
	}
}