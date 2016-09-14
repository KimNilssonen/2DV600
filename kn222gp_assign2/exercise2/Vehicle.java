package kn222gp_assign2.exercise2;

import java.util.ArrayList;

public class Vehicle {
	private int _cost;
	private double _space;
	private int _numberOfPassengers;
	private int _costPerPassenger;
	private ArrayList<Passenger> passengers = new ArrayList<>();
	private int _maxPassengers;
	
	public Vehicle(int cost, double space, int numberOfPassengers, int costPerPassenger, int maxPassengers) {
		_cost = cost;
		_space = space;
		_numberOfPassengers = numberOfPassengers;
		_costPerPassenger = costPerPassenger;
		_maxPassengers = maxPassengers;
		
		for(int i = 0; i < _numberOfPassengers; i++) {
			passengers.add(new Passenger(_costPerPassenger));
		}
		
	}
	
	public int getCost() {
		return _cost;
	}
	
	public double getSpace() {
		return _space;
	}
	
	public void setSpace(int space) {
		_space = space;
	}
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	public int getCostPerPassenger() {
		return _costPerPassenger;
	}
	
	public void setCostPerPassenger(int cost) {
		_costPerPassenger = cost;
	}	
	
	public int getMaxPassengers() {
		return _maxPassengers;
	}
	
	public int getNumberOfPassengers() {
		return _numberOfPassengers;
	}
}
