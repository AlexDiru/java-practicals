package practicalWeek3.artificialbug;

import java.lang.StringBuilder;

public class ABug {

	public String species;
	public String name;
	public char symbol;
	public int energy;
	private int uniqueId;
	public Point2D position;
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Name: ");
		stringBuilder.append(name);
		stringBuilder.append(" Position: ");
		stringBuilder.append(position.toString());
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}
	
	public String toText() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(toString());
		stringBuilder.append("Species: ");
		stringBuilder.append(species);
		stringBuilder.append("\nSymbol: ");
		stringBuilder.append(symbol);
		stringBuilder.append("\nEnergy: ");
		stringBuilder.append(energy);
		stringBuilder.append("\nUnique ID: ");
		stringBuilder.append(uniqueId);
		return stringBuilder.toString();
	}
	
	public ABug() {
		species = "";
		name = "";
		symbol = '\0';
		energy = -1;
		uniqueId = UniqueId.Get();
		position = new Point2D(0,0);
	}
	
	public ABug(String pname, String pspecies, char psymbol, int penergy, Point2D pposition) {
		name = pname;
		species = pspecies;
		symbol = psymbol;
		energy = penergy;
		position = pposition;
		uniqueId = UniqueId.Get();
	}
}
