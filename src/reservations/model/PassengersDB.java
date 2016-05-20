package reservations.model;

import java.util.ArrayList;

public class PassengersDB {

	private ArrayList<Passenger> passengers;

	public PassengersDB() {
		passengers = new ArrayList<Passenger>();
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	public boolean addPassengers(String name) {
		boolean passengerAdd = true;
		for(Passenger passenger : passengers) {
			if(passenger.getName().equals(name)) {
				passengerAdd = false;
				System.err.println("Passenger: " + name + "already exists!");
				} else {
					passengers.add(new Passenger(name));
					System.out.println("Passenger: " + name + "added to database.");
				}
		}
		return passengerAdd;
	}
}
