package practicalWeek6.artificialLifeConfiguration;

import java.io.IOException;

public class Menu {
	
	private static boolean exitApplication = false;
	
	private static void exit() {
		exitApplication = true;
	}
	
	public static boolean getExitStatus() {
		return exitApplication;
	}
	
	/**
	 * Shows the menu to the user
	 */
	public void display() {

		clearInput();

		while (true) {
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
		}

		clearInput();
	}
	
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
			
			if (input == (int)'q')
				break;
		}
		
		clearInput();
	}
	
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
			
			if (input == (int)'q')
				break;
		}
		
		clearInput();
	}
	
	private void displayEditMenu() {
		
		clearInput();
		
		while (true) {
			System.out.println("--Edit--");
			System.out.println("\t(1) Modify Current Life Form Parameters");
			System.out.println("\t(2) Remove Current Life Form");
			System.out.println("\t(3) Add a New Life Form");
			System.out.println("\t(q) Back to main menu");
			
			int input = readInput();
			
			if (input == (int)'q')
				break;
		}
		
		clearInput();
	}
	
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
			
			if (input == (int)'q')
				break;
		}
		
		clearInput();
	}

	private void displayHelpMenu() {
		
		clearInput();
		
		while (true) {
			System.out.println("--Simulation--");
			System.out.println("\t(1) Application Info");
			System.out.println("\t(2) Author Info");
			System.out.println("\t(q) Back to main menu");
			
			int input = readInput();
			
			if (input == (int)'q')
				break;
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
	
	private int readInput() {
		try {
			return System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
