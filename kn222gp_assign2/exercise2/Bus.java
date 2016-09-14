package kn222gp_assign2.exercise2;

public class Bus extends Vehicle{
	private static int _cost = 200;
	private static int _costPerPassenger = 10;
	private static int _space = 4;
	private static int _maxPassengers = 20;
	private int _numberOfPassengers;
	
	public Bus(int numberOfPassengers) {
		super(_cost, _space, numberOfPassengers, _costPerPassenger, _maxPassengers);
		_numberOfPassengers = numberOfPassengers;
	}
	
	public String toString(){
		String text = "";
		
		text += "\nBus\n";
		text += "Cost: " + _cost + ", Space: " + _space + ", Number of passengers: " 
				+ _numberOfPassengers + ", Cost per passenger: " + _costPerPassenger;
		
		return text;
	}

}
