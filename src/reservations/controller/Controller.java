package reservations.controller;

import java.util.ArrayList;

import reservations.model.Flight;
import reservations.model.Passenger;
import reservations.model.Seat;
import reservations.model.SeatsAndFlightsDB;
import reservations.view.ButtonsEventListener;
import reservations.view.FlightEvent;
import reservations.view.MainGUI;
import reservations.view.PassengerEvent;

public class Controller implements ButtonsEventListener {

	private SeatsAndFlightsDB initDB;
	private MainGUI mainView;

	public Controller(SeatsAndFlightsDB initDB, MainGUI mainView) {
		this.initDB = initDB;
		initDB.bootstrap();
		this.mainView = mainView;
	}

	@Override
	public void showFlightsEventPerformed() {
		ArrayList<Flight> flights = initDB.getFlights();
		for (Flight flight : flights) {
			System.out.println(flight);
		}
	}

	@Override
	public void selectFlightEventPerformed(FlightEvent event) {
		ArrayList<Flight> flights = initDB.getFlights();
		try {
			int fNum = Integer.parseInt(event.getFlightNumber().getText());
			if(flights.contains(new Flight(fNum))) {
				System.out.println(fNum);
			} else {
				System.err.println("No such flight!");
			}
		} catch (NumberFormatException e) {
			System.err.println("Invalid flight number. Must be integer!");
		}
	}

	@Override
	public void addPassengerEventPerformed(PassengerEvent event) {
		ArrayList<Seat> seats= initDB.getSeats();
//		if(seats.contains(o))
		System.out.println(event.getName().getText() + " " + event.getSeat().getText());
	}


}
