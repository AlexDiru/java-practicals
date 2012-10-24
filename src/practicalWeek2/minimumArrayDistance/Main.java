package practicalWeek2.minimumArrayDistance;

public class Main {

	static int minDistance(int arr[]) {
		
		//Set the minimum distance to an integer's maximum value
		int minDist = Integer.MAX_VALUE;
		int index = -1;
		boolean minDistFound = false;
		
		//Iterate the array's values
		for (int i = 0; i < arr.length - 1; i++) {
			//Calculate the distance of the ith array value and it's right neighbour
			int newDist = Math.abs(arr[i]-arr[i+1]);
			
			//If we've found a new minimum distance or we haven't found a minimum distance yet
			if (newDist < minDist || !minDistFound) {
				//Store the index
				index = i;
				//Change the current minimum index
				minDist = newDist;
				
				minDistFound = true;
			}
		}
		
		return index;
	}
	
	public static void main(String args[]) {
		System.out.print(minDistance(new int[] {4, 8, 6, 100, 2, 9, 4}));
	}
}
