package practicalWeek6.artificialLifeConfiguration;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHelper {
	/**
	 * Reads an integer that the user inputs and repeats until the user enters an integer
	 * @param bufferedReader
	 * @return
	 */
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
	
	/**
	 * Given a string returns true if the string is a number and false otherwise
	 * @param string
	 * @return
	 */
	private static Boolean tryParseInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
