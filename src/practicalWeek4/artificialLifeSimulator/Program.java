package practicalWeek4.artificialLifeSimulator;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Create bugs
		ABug bug = new ABug("Alex", 'A', 10);
		ABug bug2 = new ABug("Tom", 'T', 10);
		
		AWorld world = new AWorld();
		world.addBug(bug);
		world.addBug(bug2);
		
		world.main(300);

	}

}
