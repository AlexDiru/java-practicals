package practicalWeek3.artificialbug;

public class UniqueId {
	private static int currentId = 0;
	
	public static int Get() {
		return currentId++;
	}
}
