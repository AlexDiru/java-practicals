package practicalWeek6.artificialLifeConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Configuration {
	
	//File format
	//number_of_bugs, obstacle_frequency, food_frequency, map_x_size, map_y_size
	
	private int bugNumber = 3;
	private int obstacleFrequency = 5;
	private int foodFrequency = 20;
	private int xSize = 30;
	private int ySize = 20;
	private String lastUsedConfigDirectory = "";
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Displays the parameters of the configuration
	 */
	public void display() {
		System.out.println("Bug number: " + bugNumber);
		System.out.println("Obstacle Frequency: " + obstacleFrequency);
		System.out.println("Food frequency: " + foodFrequency);
		System.out.println("X Size: " + xSize);
		System.out.println("Y Size: " + ySize);
	}
	
	/**
	 * Allows the user to edit the parameters of the configuration
	 */
	public void edit() {
		System.out.println("Bug number: ");
		bugNumber = InputHelper.readInteger(br);
		System.out.println("Obstacle Frequency: ");
		obstacleFrequency = InputHelper.readInteger(br);
		System.out.println("Food frequency: ");
		foodFrequency = InputHelper.readInteger(br);
		System.out.println("X Size: ");
		xSize = InputHelper.readInteger(br);
		System.out.println("Y Size: ");
		ySize = InputHelper.readInteger(br);
	}
	
	public Configuration(String directory) {
		File file = new File(directory);
		if (file.exists()) {
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			try {
				lastUsedConfigDirectory = bufferedReader.readLine();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Loads the last used config file
	 */
	public void loadLastUsed() {
		if (!lastUsedConfigDirectory.equals(""))
			load(lastUsedConfigDirectory);
	}

	/**
	 * Loads the configuration file
	 * @param directory The directory to load from
	 * @return Success of the operation
	 */
	public boolean load(String directory) {
		File file = new File(directory);
		if (file.exists()) {
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			try {
				String[] data = bufferedReader.readLine().split(",");
				bugNumber = Integer.parseInt(data[0]);
				obstacleFrequency = Integer.parseInt(data[1]);
				foodFrequency = Integer.parseInt(data[2]);
				xSize = Integer.parseInt(data[3]);
				ySize = Integer.parseInt(data[4]);
				bufferedReader.close();
				writeLatestDirectory(directory);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("File corrupted");
				return false;
			}
		}
		System.out.println("File doesn't exist");
		return false;
	}
	
	/**
	 * Writes the last config file used directory to config.txt
	 * @param directory The directory of the last used config file
	 */
	private void writeLatestDirectory(String directory) {
		lastUsedConfigDirectory = directory;
		File file = new File("config.txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		printWriter.println(directory);
	}
	
	/**
	 * Saves the parameters to a new file
	 * @param directory File to save to
	 * @param bugNum Number of bugs
	 * @param obstFreq Obstacle frequency
	 * @param foodFreq Food frequency
	 * @param xSize X Size
	 * @param ySize Y Size
	 */
	public void saveAs(String directory, int bugNum, int obstFreq, int foodFreq, int xSize, int ySize) {
		File file = new File(directory);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		printWriter.println(bugNum + "," + obstFreq + "," + foodFreq + "," + xSize + "," + ySize);
	}
	
	/**
	 * Saves the parameters to the same file
	 * @param bugNum Number of bugs
	 * @param obstFreq Obstacle frequency
	 * @param foodFreq Food frequency
	 * @param xSize X Size
	 * @param ySize Y Size
	 */
	public void save(int bugNum, int obstFreq, int foodFreq, int xSize, int ySize) {
		saveAs(lastUsedConfigDirectory, bugNum, obstFreq, foodFreq, xSize, ySize);
	}
	
	/**
	 * Gets the parameters of the configurations
	 * @return An array containing the parameters
	 */
	public int[] getParameters() {
		return new int[] { bugNumber, obstacleFrequency, foodFrequency, xSize, ySize };
	}
}
