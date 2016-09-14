package kn222gp_assign2.exercise2;

public class Car extends Vehicle{
	private static int _cost = 100;
	private static int _costPerPassenger = 15;
	private static int _space = 1;
	private static int _maxPassengers = 4;
	private int _numberOfPassengers = 0;
	
	public Car(int numberOfPassengers) {
		super(_cost, _space, numberOfPassengers, _costPerPassenger, _maxPassengers);
		_numberOfPassengers = numberOfPassengers;
		
	}
	
	public String toString(){
		String text = "";
		
		text += "\nCar\n";
		text += "Cost: " + _cost + ", Space: " + _space + ", Number of passengers: " 
				+ _numberOfPassengers + ", Cost per passenger: " + _costPerPassenger;
		
		return text;
	}
}
