package kn222gp_assign2.exercise2;

public class Lorry extends Vehicle{
	private static int _cost = 300;
	private static int _costPerPassenger = 15;
	private static int _space = 8;
	private static int _maxPassengers = 2;
	private int _numberOfPassengers;
	
	public Lorry(int numberOfPassengers) {
		super(_cost, _space, numberOfPassengers, _costPerPassenger, _maxPassengers);
		_numberOfPassengers = numberOfPassengers;
	}
	
	public String toString(){
		String text = "";
		
		text += "\nLorry\n";
		text += "Cost: " + _cost + ", Space: " + _space + ", Number of passengers: " 
				+ _numberOfPassengers + ", Cost per passenger: " + _costPerPassenger;
		
		return text;
	}

}
