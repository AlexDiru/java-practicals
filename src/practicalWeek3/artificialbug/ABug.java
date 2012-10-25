package practicalWeek3.artificialbug;

import java.util.Random;

public class ABug {

	private String species;
	private String name;
	private char symbol;
	private int energy;
	private int uniqueId;
	private Point2D position;
	private Random random = new Random();
	
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
	
	public void setSpecies(String s) {
		species = s;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setSymbol(char c) {
		symbol = c;
	}
	
	public void setEnergy(int e) {
		energy = e;
	}
	
	public void setPosition(Point2D p) {
		position = p;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public String getName() {
		return name;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public Point2D getPosition() {
		return position;
	}
	
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
	
	public void move() {
		//Get direction
		int direction = random.nextInt(4);
		
		switch (direction) {
		case 0:
			//North (graphically South)
			System.out.println("Moved South");
			position.y++;
			break;
			
		case 1:
			//South (graphically North)
			System.out.println("Moved North");
			position.y--;
			break;
			
		case 2:
			//East
			System.out.println("Moved East");
			position.x++;
			break;
			
		case 3:
			//West
			System.out.println("Moved West");
			position.x--;
			break;
		}
	}
}
