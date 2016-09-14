package kn222gp_assign2.exercise2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ferry implements FerryInterface{
	private final int MAX_NUMBER_OF_PASSENGERS = 200;
	private final int MAX_VEHICLE_SPACE = 40;
	private ArrayList<Passenger> passengers;
	private ArrayList<Vehicle> vehicles;
	private int earnedMoney = 0;
	private int usedSpace = 0;
	
	public Ferry() {
		passengers = new ArrayList<>();
		vehicles = new ArrayList<>();
	}

	@Override
	public Iterator<Vehicle> iterator() {
		return new Iterator<Vehicle>() {
			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < vehicles.size();
			}

			@Override
			public Vehicle next() {
				return vehicles.get(count++);
			}
		};
	}

	@Override
	public int countPassengers() {
		return passengers.size();
	}

	@Override
	public int countVehicleSpace() {
		return usedSpace;
	}

	@Override
	public int countMoney() {
		return earnedMoney;
	}

	@Override
	public void embark(Vehicle v) {
		if(hasSpaceFor(v)){
			vehicles.add(v);
			usedSpace += v.getSpace();
			earnedMoney += v.getCost();
			for(Passenger p: v.getPassengers()) {
				embark(p);
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
			passengers.add(p);
			earnedMoney += p.getCost();
		}
		else {
			System.err.println("Sorry! The ferry does not have room for this person!");
		}


	}

	@Override
	public void disembark() {
		passengers.clear();
		vehicles.clear();
		usedSpace = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(v.getNumberOfPassengers() > v.getMaxPassengers()) {
			return false;
		}
		else if(countVehicleSpace() + v.getSpace() <= MAX_VEHICLE_SPACE) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		if(countPassengers() < MAX_NUMBER_OF_PASSENGERS && !passengers.contains(p)) {
			return true;
		}
		return false;
	}

	public String toString() {
		String text = "";
		text += "\nFerry status:\n----------------------------------------\n";
		text += "\nNumber of passengers aboard  : " + countPassengers();
		text += "\nNumber of vehicles aboard    : " + vehicles.size();
		text += "\nAmount of vehicle space left : " + (MAX_VEHICLE_SPACE - countVehicleSpace());
		text += "\n\nMoney earned               : " + countMoney() + " kr";
		text += "\n\n";

		Iterator<Vehicle> iterator = vehicles.iterator();
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
