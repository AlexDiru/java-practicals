package practicalWeek2.minimumArrayDistance;

public class Main {

	static int minDistance(int arr[]) {
		
		int minDist = Integer.MAX_VALUE;
		int index = -1;
		
		for (int i = 0; i < arr.length - 1; i++) {
			//Calculate the distance of the ith array value and it's right neighbour
			int newDist = Math.abs(arr[i]-arr[i+1]);
			
			if (newDist < minDist)
			{
				index = i;
				minDist = newDist;
			}
		}
		
		return index;
	}
	
	public static void main(String args[]) {
		System.out.print(minDistance(new int[] {4, 8, 6, 1, 2, 9, 4}));
	}
}
