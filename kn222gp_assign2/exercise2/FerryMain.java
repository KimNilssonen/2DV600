package kn222gp_assign2.exercise2;

import javax.swing.table.TableStringConverter;

public class FerryMain {

	public static void main(String[] args) {

		Ferry ferry = new Ferry();

		// Testing to fill ferry with 10 full busses.
		for(int i = 0; i < 10; i++) {
			ferry.embark(new Bus(20));
		}
		System.out.println(ferry.toString());
		System.out.println("Disembarking...\n\n");
		ferry.disembark();

		// Testing to fill ferry with 200 bicycles.
		for(int i = 0; i < 200; i++) {
			ferry.embark(new Bicycle());
		}
		System.out.println(ferry.toString());
		System.out.println("Disembarking...\n\n");
		ferry.disembark();

		//Testing to add 39 cars with 2 passengers, 1 bicycle and then another car. The last car should not be able to embark.
		for(int i = 0; i < 39; i++){
			ferry.embark(new Car(2));
		}
		ferry.embark(new Bicycle());
		ferry.embark(new Car(2));

		System.out.println(ferry.toString());
		System.out.println("Disembarking...\n\n");
		ferry.disembark();

		// Testing to add 200 passengers.
		for(int i = 0; i < 200; i++){
			ferry.embark(new Passenger(20));
		}
		
		System.out.println(ferry.toString());
		System.out.println("Disembarking...\n\n");
		ferry.disembark();
		
		// Trying to add 200 passengers and then 1 bicycle. Bicycle should not be able to embark since the ferry is full with passengers.
		for(int i = 0; i < 200; i++){
			ferry.embark(new Passenger(20));
		}
		
		ferry.embark(new Bicycle());
		
		System.out.println(ferry.toString());
		System.out.println("Disembarking...\n\n");
		ferry.disembark();

		/*
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
		for(int i = 0; i < 3; i++) {
			Bicycle bicycle = new Bicycle();
			ferry.embark(bicycle);
		}


		// Status
		System.out.println(ferry.toString());

		// Disembark the ferry but keep the money earned.
		ferry.disembark();

		// Status after disembark.
		System.out.println(ferry.toString());

		// Shutdown.*/
		System.exit(0);

	}
}
