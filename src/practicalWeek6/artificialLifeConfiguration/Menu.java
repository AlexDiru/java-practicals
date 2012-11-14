package practicalWeek6.artificialLifeConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	private static boolean exitApplication = false;
	private boolean exitMenu = false;
	private AWorld world;
	private BufferedReader bufferedReader;

	/**
	 * Creates a reader for the menu and assigns the menu to a word
	 * 
	 * @param world
	 *            The world to assign the menu to
	 */
	public Menu(AWorld world) {
		this.world = world;
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Sets the exitApplication flag to true - will exit the application
	 */
	private static void exit() {
		exitApplication = true;
	}

	/**
	 * Shows the menu to the user
	 */
	public void display() {

		clearInput();

		while (!exitMenu) {
			int mainMenuReply = displayMainMenu();

			if (mainMenuReply == (int) 'q')
				break;
			else if (mainMenuReply == (int) '1')
				displayFileMenu();
			else if (mainMenuReply == (int) '2')
				displayViewMenu();
			else if (mainMenuReply == (int) '3')
				displayEditMenu();
			else if (mainMenuReply == (int) '4')
				displaySimulationMenu();
			else if (mainMenuReply == (int) '5')
				displayHelpMenu();

			if (exitApplication)
				return;
		}

		exitMenu = false;
		clearInput();
	}

	/**
	 * Displays the file menu and handles input
	 */
	private void displayFileMenu() {

		clearInput();

		while (true) {
			System.out.println("--File--");
			System.out.println("\t(1) New Configuration");
			System.out.println("\t(2) Open Configuration File");
			System.out.println("\t(3) Save");
			System.out.println("\t(4) Save As");
			System.out.println("\t(5) Exit");
			System.out.println("\t(q) Back to main menu");

			int input = readInput();

			clearInput();
			if (input == (int) 'q')
				break;
			else if (input == (int) '1') {
				world.resetConfiguration();
			} else if (input == (int) '2') {
				while (true) {
					System.out.println("Enter directory (q to quit):");
					String dir = null;
					try {
						dir = bufferedReader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (dir == null || dir.equals("q") || world.getConfiguration().load(dir))
						break;
				}
			} else if (input == (int) '3') {
				world.getConfiguration().save(world.getBugNumber(), world.getMap().getObstacleFrequency(), world.getMap().getFoodFrequency(), world.getMap().getXSize(), world.getMap().getYSize());
			} else if (input == (int) '4') {
				String directory = null;
				System.out.println("Enter directory: ");
				try {
					directory = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				world.getConfiguration().saveAs(directory, world.getBugNumber(), world.getMap().getObstacleFrequency(), world.getMap().getFoodFrequency(), world.getMap().getXSize(),
						world.getMap().getYSize());
			} else if (input == (int) '5') {
				exit();
				break;
			}
		}

		clearInput();
	}

	/**
	 * Displays the view menu and handles input
	 */
	private void displayViewMenu() {

		clearInput();

		while (true) {
			System.out.println("--View--");
			System.out.println("\t(1) Display Configuration");
			System.out.println("\t(2) Edit Configuration");
			System.out.println("\t(3) Display Life Form Info");
			System.out.println("\t(4) Display Map Info");
			System.out.println("\t(q) Back to main menu");

			int input = readInput();

			if (input == (int) 'q')
				break;
			else if (input == (int) '1')
				world.getConfiguration().display();
			else if (input == (int) '2')
				world.getConfiguration().edit();
			else if (input == (int) '3')
				world.printStats();
			else if (input == (int) '4')
				world.getMap().printStats();

			clearInput();
		}

	}

	/**
	 * Displays the edit menu and handles input
	 */
	private void displayEditMenu() {

		clearInput();

		while (true) {
			System.out.println("--Edit--");
			System.out.println("\t(1) Modify Current Life Form Parameters");
			System.out.println("\t(2) Remove Current Life Form");
			System.out.println("\t(3) Add a New Life Form");
			System.out.println("\t(q) Back to main menu");

			int input = readInput();

			if (input == (int) 'q')
				break;
			else if (input == (int) '1') {
				clearInput();
				System.out.println("Enter name: ");
				try {
					String bugName = bufferedReader.readLine();
					world.editBugFromName(bugName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (input == (int) '2') {
				clearInput();
				System.out.println("Enter name: ");
				try {
					String bugName = bufferedReader.readLine();
					world.removeBugFromName(bugName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (input == (int) '3') {
				clearInput();
				ABug b = new ABug();
				b.edit();
				world.addBug(b);
			}
		}

		clearInput();
	}

	/**
	 * Displays the simulation menu and handles input
	 */
	private void displaySimulationMenu() {

		clearInput();

		while (true) {
			System.out.println("--Simulation--");
			System.out.println("\t(1) Run");
			System.out.println("\t(2) Stop");
			System.out.println("\t(3) Restart");
			System.out.println("\t(4) Reset");
			System.out.println("\t(5) Display Map at each Iteration");
			System.out.println("\t(q) Back to main menu");

			int input = readInput();

			if (input == (int) 'q')
				break;
			else if (input == (int) '1') {
				exitMenu = true;
				break;
			} else if (input == (int) '2') {
			} else if (input == (int) '3') {
				world.reset();
				exitMenu = true;
			} else if (input == (int) '4') {
				world.reset();
			} else if (input == (int) '5') {
				world.setDisplayFlag(!world.getDisplayFlag());
				System.out.println("Display flag is now " + (world.getDisplayFlag() ? "ON" : "OFF"));
			}

			clearInput();
		}

		clearInput();
	}

	/**
	 * Displays the help menu and handles input
	 */
	private void displayHelpMenu() {

		clearInput();

		while (true) {
			System.out.println("--Simulation--");
			System.out.println("\t(1) Application Info");
			System.out.println("\t(2) Author Info");
			System.out.println("\t(q) Back to main menu");

			int input = readInput();

			if (input == (int) 'q')
				break;
			else if (input == (int) '1')
				System.out.println("Simulator");
			else if (input == (int) '2')
				System.out.println("Alex");

			clearInput();
		}

		clearInput();
	}

	/**
	 * Clears the input buffer
	 */
	private static void clearInput() {
		// Clear input buffer
		try {
			while (System.in.available() > 0)
				System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Displays the main menu text
	 * 
	 * @return The input read
	 */
	private int displayMainMenu() {
		System.out.println("--Menu--");
		System.out.println("(1) File");
		System.out.println("(2) View");
		System.out.println("(3) Edit");
		System.out.println("(4) Simulation");
		System.out.println("(5) Help");
		System.out.println("(q) Quit Menu");

		return readInput();
	}

	/**
	 * Reads a single character on the System.in stream
	 * 
	 * @return The character read
	 */
	private int readInput() {
		try {
			return System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static boolean getExitStatus() {
		return exitApplication;
	}
}
