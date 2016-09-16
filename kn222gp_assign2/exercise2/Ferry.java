package kn222gp_assign2.exercise2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ferry implements FerryInterface{
	private final int MAX_NUMBER_OF_PASSENGERS = 200;
	private final int MAX_VEHICLE_SPACE = 40;
	private ArrayList<Passenger> _passengers;
	private ArrayList<Vehicle> _vehicles;
	private int _earnedMoney = 0;
	private double _usedSpace = 0;
	private int _numberOfBicycles = 0;
	
	public Ferry() {
		_passengers = new ArrayList<>();
		_vehicles = new ArrayList<>();
	}

	@Override
	public Iterator<Vehicle> iterator() {
		return new Iterator<Vehicle>() {
			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < _vehicles.size();
			}

			@Override
			public Vehicle next() {
				return _vehicles.get(count++);
			}
		};
	}

	@Override
	public int countPassengers() {
		return _passengers.size();
	}

	@Override
	public int countVehicleSpace() {
		return (int)_usedSpace;
	}
	
	public int countBicycles() {
		return _numberOfBicycles;
	}

	@Override
	public int countMoney() {
		return _earnedMoney;
	}

	@Override
	public void embark(Vehicle v) {
		if(hasSpaceFor(v) && (_passengers.size() + v.getPassengers().size()) <= MAX_NUMBER_OF_PASSENGERS){
			for(Passenger p: v.getPassengers()) {
				embark(p);
			}
			
			_vehicles.add(v);
			_usedSpace += v.getSpace();
			_usedSpace = fixDouble(_usedSpace);
			_earnedMoney += v.getCost();
			if(v.getSpace() == 0.2) {
				_numberOfBicycles++;
			}
		}
		else {
			System.err.println("Sorry! This vehicle cannot embark the ferry since the ferry is full or "
					+ "this vehicle contains too many passengers.");
		}
	}

	@Override
	public void embark(Passenger p) {
		if(hasRoomFor(p)){
			_passengers.add(p);
			_earnedMoney += p.getCost();
		}
		else {
			System.err.println("Sorry! The ferry does not have room for this person!");
		}
	}

	@Override
	public void disembark() {
		_passengers.clear();
		_vehicles.clear();
		_usedSpace = 0;
		_numberOfBicycles = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(v.getNumberOfPassengers() > v.getMaxPassengers()) {
			return false;
		}
		else if(_usedSpace + v.getSpace() <= MAX_VEHICLE_SPACE && !_vehicles.contains(v)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		if(countPassengers() < MAX_NUMBER_OF_PASSENGERS && !_passengers.contains(p)) {
			return true;
		}
		return false;
	}
	
	public double fixDouble(double sum) {
		int multiplier = (int) Math.pow(10, 2);
		return (double) (long) (sum*multiplier) / multiplier; 
	}

	public String toString() {
		String text = "";
		text += "\nFerry status:\n----------------------------------------\n";
		text += "\nNumber of passengers aboard  : " + countPassengers() + "/" + MAX_NUMBER_OF_PASSENGERS;
		text += "\nNumber of vehicles aboard    : " + _vehicles.size() + " (Bicycles: " + _numberOfBicycles + ")" ;
		text += "\nUsed vehicle space           : " + Math.ceil(_usedSpace) + "/" + MAX_VEHICLE_SPACE;
		text += "\n\nMoney earned               : " + countMoney() + " kr";
		text += "\n\n";

		Iterator<Vehicle> iterator = _vehicles.iterator();
		if(iterator.hasNext()) {
			text += "\n\nDetails of vehicles:\n----------------------------------------\n";
			while(iterator.hasNext()) {
				text += iterator.next().toString() + "\n";
			}
			text += "\n----------------------------------------\n";
		}
		return text;
	}

}
