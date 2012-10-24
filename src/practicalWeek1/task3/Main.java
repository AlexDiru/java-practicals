package practicalWeek1.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {

		//Loop until number entered
		int numberOfPeople;
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		
		while (true) {
			System.out.println("Enter the number of people: ");
			line = bufferedReader.readLine();
			
			//Attempt to cast line to number
			try {
				numberOfPeople = Integer.parseInt(line);
				break;
			} catch (Exception ex) {
				System.out.println("Please enter a number");
			}
		}
		
		String[] names = new String[numberOfPeople];
		
		System.out.println("Enter the names:");
		
		int namesEntered = 0;
		while (namesEntered < numberOfPeople) {
			names[namesEntered] = bufferedReader.readLine();
			namesEntered++;
		}
		
		//Print initials
		for (String name : names) {
			System.out.println(name + " =initials=> " + practicalWeek1.task2.Main.getInitials(name));
		}
		
	}
}
