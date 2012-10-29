package practicalWeek4.artificialLifeSimulator;

public class AWorld {
	
	private Map map = new Map(25,15);
	
	public void printMap(boolean printBoundaries) {
		
		if (printBoundaries)
			map.printBorder();
		
		//Iterate rows
		for (String row : map.getCells()) {
			if (printBoundaries)
				System.out.print("|");
			
			System.out.print(row);
			
			if (printBoundaries)
				System.out.print("|");
			
			System.out.print("\n");
		}
		
		if (printBoundaries)
			map.printBorder();
	}
	
	public Map getMap() {
		return map;
	}
}
