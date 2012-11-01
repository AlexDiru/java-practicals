package practicalWeek4.artificialLifeSimulator;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Create bugs
		ABug bug = new ABug("Alex", 'A', 10);
		ABug bug2 = new ABug("Tom", 'T', 10);
		ABug bug3 = new ABug("Snowy", 'S', 10);
		
		AWorld world = new AWorld(20,12);
		world.addBug(bug);
		world.addBug(bug2);
		world.addBug(bug3);
		
		world.main(5);
	}
}
