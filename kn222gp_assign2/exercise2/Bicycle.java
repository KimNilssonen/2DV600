package kn222gp_assign2.exercise2;

public class Bicycle extends Vehicle {
	private static int _cost = 40;
	private static double _space = 0.2;
	
	public Bicycle() {
		super(_cost, _space, 1, 0, 1);
	}
	
	public String toString(){
		String text = "";
		
		text += "\nBicycle\n";
		text += "Cost: " + _cost + ", Space: " + _space + ", Number of passengers: 1, Cost per passenger: 0";
		
		return text;
	}
}
