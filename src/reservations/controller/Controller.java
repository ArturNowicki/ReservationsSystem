package reservations.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import reservations.model.Flight;
import reservations.model.Seat;
import reservations.model.SeatsAndFlightsDB;
import reservations.view.ButtonsEventListener;
import reservations.view.FlightEvent;
import reservations.view.MainGUI;
import reservations.view.PassengerEvent;

public class Controller implements ButtonsEventListener {

	private SeatsAndFlightsDB initDB;
	private MainGUI mainView;
	private LocalDate departureDate = LocalDate.now();
	private String passName, seatNumber;
	private ArrayList<Flight> flights;
	private ArrayList<Seat> seats;
	private int fNum;

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
		flights = initDB.getFlights();
		boolean isFlight = false;
		try {
			fNum = Integer.parseInt(event.getFlightNumber().getText());
			for (Flight flight : flights) {
				if (flight.getFlightNumber() == fNum) {
					isFlight = true;
					mainView.switchPassengerButton(true);
					System.out.println(initDB.getOpenSeats(departureDate, fNum));
				}
			}
			if (!isFlight)
				System.err.println("No such flight!");
			// this works with overriden equals method in Flight class
			// if(flights.contains(new Flight(fNum))) {
			// System.out.println(fNum);
			// } else {
			// System.err.println("No such flight!");
			// }
		} catch (NumberFormatException e) {
			System.err.println("Invalid flight number. Must be integer!");
		}
	}

	@Override
	public void addPassengerEventPerformed(PassengerEvent event) {
		if (!event.getName().getText().equals("")) {
			passName = event.getName().getText();
			boolean addPass = initDB.addPassengers(passName);
			if(addPass) {
				System.out.println("Welcome!");
			} else System.out.println("Welcome back!");
		} else {
			System.err.println("Enter name!");
		}
		seats = initDB.getOpenSeats(departureDate, fNum);
		boolean isSeat = false;
		for (Seat seat : seats) {
			if (seat.getSeatNumber().equals(event.getSeat().getText())) {
				isSeat = true;
				System.out.println(initDB.addTicket(departureDate, passName, fNum, event.getSeat().getText()));
				mainView.switchPassengerButton(false);
				mainView.clearForm();
				System.out.println("Add new passenger.");
			}
		}
		if (!isSeat) {
			System.err.println("Invalid seat number!");
		}
	}

}
