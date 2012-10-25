package practicalWeek3.artificialbug;

public class Map {

	private int xSize;
	private int ySize;
	
	public Map(int x, int y) {
		xSize = x;
		ySize = y;
	}
	
	public void print(ABug bug) {
		//Modulo bug's coordinates so the map wraps
		int xPos = bug.getPosition().x % xSize;
		int yPos = bug.getPosition().y % ySize;
		
		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				if (x == xPos && y == yPos)
					System.out.print(bug.getSymbol());
				else
					System.out.print('.');
			}
			System.out.print('\n');
		}
	}
}
