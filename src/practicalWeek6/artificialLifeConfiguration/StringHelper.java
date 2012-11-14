package practicalWeek6.artificialLifeConfiguration;

import java.util.Random;

public class StringHelper {

	private static Random random = new Random();

	/**
	 * Generates a random string of length 3 to 9
	 * 
	 * @return The random string
	 */
	public static String generateRandomName() {
		int length = random.nextInt(7) + 3;
		String name = "";

		for (int i = 0; i < length; i++) {
			name += (char) (random.nextInt(26) + 'a');
		}

		// Uppercase first letter
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
