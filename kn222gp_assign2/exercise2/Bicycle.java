package kn222gp_assign2.exercise2;

public class Bicycle extends Vehicle {
	private static int _cost = 40;
	
	public Bicycle() {
		super(_cost, 0.2, 1, 0, 1);
	}
	
	public String toString(){
		String text = "";
		
		text += "\nBicycle\n";
		text += "Cost: " + _cost + ", Space: 1, Number of passengers: 1, Cost per passenger: 0";
		
		return text;
	}
}
