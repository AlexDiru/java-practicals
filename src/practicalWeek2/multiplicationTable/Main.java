package practicalWeek2.multiplicationTable;

public class Main {

	private static void mult(int x) {

		// Loop through all the rows
		for (int row = 1; row <= x; row++) {
			// Loop through all the columns
			for (int col = 1; col <= x; col++) {
				// Print the data
				System.out.print((row * col) + "\t");
			}
			// Move onto next row so new line
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {

		mult(10);
	}
}
