package kn222gp_assign2.exercise2;

public class FerryMain {

	public static void main(String[] args) {
		
		Ferry ferry = new Ferry();
		
		// Adding a few lorries.
		for(int i = 0; i < 2; i++) {
			Lorry lorry = new Lorry(1);
			ferry.embark(lorry);
		}
		
		// Adding some passengers.
		for(int i = 0; i < 60; i++){
			Passenger passenger = new Passenger(20);
			ferry.embark(passenger);
		}
		
		// Should return an error in console because it  has more passengers than allowed.
		Car car = new Car(6);
		ferry.embark(car);
		
		Car car2 = new Car(3);
		ferry.embark(car2);
		
		// Adding some bicycles.
		for(int i = 0; i < 6; i++) {
			Bicycle bicycle = new Bicycle();
			ferry.embark(bicycle);
		}
		
		
		// Status
		System.out.println(ferry.toString());
		
		// Disembark the ferry but keep the money earned.
		ferry.disembark();
		
		// Status after disembark.
		System.out.println(ferry.toString());
		
		// Shutdown.
		System.exit(0);

	}
}
