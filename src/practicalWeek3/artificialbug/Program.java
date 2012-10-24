package practicalWeek3.artificialbug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {
	
	//Given a string returns true if the string is a number and false otherwise
	public static Boolean tryParseInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	//Reads an integer that the user inputs
	//Repeats until the user enters an integer
	public static int readInteger(BufferedReader bufferedReader) {
		String line = "-1";
		do {
			try {
				line = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tryParseInteger(line));
		
		return Integer.parseInt(line);
	}
	
	//Gets the user to enter all the details manually - task 1
	public static ABug getFromUserInputBlankConstructor() {
		//Read user input
		String species = "";
		String name = "";
		int energy = -1;
		char symbol = '\0';
		int xposition = 0;
		int yposition = 0;
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Species: ");
			species = bufferedReader.readLine();
			
			System.out.println("Name: ");
			name = bufferedReader.readLine();
			
			System.out.println("Energy: ");
			energy = readInteger(bufferedReader);
			
			System.out.println("Symbol: ");
			try {
				symbol = bufferedReader.readLine().charAt(0);
			} catch (IndexOutOfBoundsException ex) {
			}
			
			System.out.println("X Position: ");
			xposition = readInteger(bufferedReader);
			
			System.out.println("Y Position: ");
			yposition = readInteger(bufferedReader);
				
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		ABug aBug = new ABug();
		aBug.species = species;
		aBug.name = name;
		aBug.energy = energy;
		aBug.symbol = symbol;
		aBug.position.x = xposition;
		aBug.position.y = yposition;
		return aBug;
	}
	
	public static ABug getFromUserInputFullConstructor() {
		//Read user input
		String species = "";
		String name = "";
		int energy = -1;
		char symbol = '\0';
		int xposition = 0;
		int yposition = 0;
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Species: ");
			species = bufferedReader.readLine();
			
			System.out.println("Name: ");
			name = bufferedReader.readLine();
			
			System.out.println("Energy: ");
			energy = readInteger(bufferedReader);
			
			System.out.println("Symbol: ");
			try {
				symbol = bufferedReader.readLine().charAt(0);
			} catch (IndexOutOfBoundsException ex) {
			}
			
			System.out.println("X Position: ");
			xposition = readInteger(bufferedReader);
			
			System.out.println("Y Position: ");
			yposition = readInteger(bufferedReader);
				
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return new ABug(name, species, symbol, energy, new Point2D(xposition, yposition));
	}
	
	//Gets the user to enter details for multiple bugs
	public static ABug[] getBugArray(int number) {
		ArrayList<ABug> aBugList = new ArrayList<ABug>();
		
		for (int i = 0; i < number; i++)
			aBugList.add(getFromUserInputFullConstructor());
		
		return aBugList.toArray(new ABug[number]);
	}
	
	public static ABug[] getBugArrayUndefinedSize() {
		ArrayList<ABug> aBugList = new ArrayList<ABug>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			aBugList.add(getFromUserInputFullConstructor());
			//Termination
			System.out.println("Terminate? Blank line to continue, anything else to terminate");
			try {
				if (!bufferedReader.readLine().equals(""))
					break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return aBugList.toArray(new ABug[aBugList.size()]);
	}
	
	public static void task1234() {
		ABug aBug;
		
		//Task 1
		System.out.println("~Task 1~");
		aBug = getFromUserInputBlankConstructor();
		System.out.println(aBug.toText());
		
		//Task 2
		System.out.println("\n~Task 2~");
		aBug = getFromUserInputFullConstructor();
		System.out.println(aBug.toText());
		
		//Task 3
		System.out.println("\n~Task 3~");
		ABug[] bugArray = getBugArray(3);
		for (ABug bug : bugArray) {
			System.out.println(bug.toText());
		}
		
		//Task 4
		System.out.println("\n~Task 4~");
		ABug[] bugArray2 = getBugArrayUndefinedSize();
		for (ABug bug : bugArray2) {
			System.out.println(bug.toText());
		}
	}
	
	public static void mapTask() {
		Map map = new Map(50,30);
		ABug bug = new ABug("Mr Sparkle", "Donkey", '@', 50, new Point2D(25,15));
		map.print(bug);
		
		//Move 15 steps
		for (int i = 0; i < 15; i++)
			bug.move();
		
		System.out.println("\n");
		
		map.print(bug);
	}

	public static void main(String[] args) {

		//task1234();
		mapTask();
	}

}
