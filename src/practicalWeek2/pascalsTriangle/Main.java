package practicalWeek2.pascalsTriangle;

public class Main {
	
	//Returns a 2d array with pascals triangle
	private static int[][] createPascalsTriangle(int depth) {
		
		//Create a 2d array with the correct depth
		int[][] triangle = new int[depth][];
		
		//First row - the two extra zeroes are so that when the next row's data is being filled, it will access the zeroes to sum and won't
		//cause a segfault
		triangle[0] = new int[] {0, 1, 0};
		
		//Fill in the rest of the data
		for (int i = 1; i < depth; i++) {
			
			//3 extra spaces so there is no segfault on the next row of triangle
			triangle[i] = new int[i + 3]; 
			
			//Fill the leftmost and rightmost cells with zero
			triangle[i][0] = triangle[i][triangle[i].length-1] = 0;
			
			//Fill the data into the rest of the cells - avoiding the leftmost and rightmost cells
			for (int j = 1; j < triangle[i].length - 1; j++) {
				//Current cell = Above left cell + Above right cell
				triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
			}
		}
		
		return triangle;
	}
	
	//Creates a pascals triangle given a number of rows
	private static void pascalsTriangle(int rows) {
		
		//Create pascals triangle
		int[][] triangle = createPascalsTriangle(rows);
		
		//Number of tabs on the left side
		int leftTabs = (int) Math.round((float)rows/2.0);
		
		//If we need more tabs then increase left tabs
		if (rows > 5)
			leftTabs += (rows-4)*2;
		
		for (int i = 0; i < rows; i++) {
			//Print the left tabs
			for (int t = 0; t < leftTabs; t++)
				System.out.print("    ");
			
			//Decrease a lefttab ready for the next row
			leftTabs--;
			
			//Print out all the data on the row (avoiding the left most and rightmost cells as they will be zero)
			for (int n = 1; n < triangle[i].length - 1; n++) {
				System.out.print(triangle[i][n] + "      ");
			}
			
			//New line for new row
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		pascalsTriangle(30);
	}

}
