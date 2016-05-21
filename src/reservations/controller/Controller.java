package reservations.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import reservations.model.Flight;
import reservations.model.Seat;
import reservations.model.SeatsAndFlightsDB;
import reservations.model.Ticket;
import reservations.view.ButtonsEventListener;
import reservations.view.FlightEvent;
import reservations.view.PassengerEvent;

public class Controller implements ButtonsEventListener {

	private SeatsAndFlightsDB initDB;
	private LocalDate departureDate = LocalDate.now();
	private String passName;
	private ArrayList<Flight> flights;
	private ArrayList<Seat> seats;
	private ArrayList<Ticket> tickets;
	private int fNum;
	private ViewInterface viewInterface;

	public Controller(SeatsAndFlightsDB initDB) {
		this.initDB = initDB;
		initDB.bootstrap();
	}

	@Override
	public void showFlightsEventPerformed() {
		flights = initDB.getFlights();
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
					viewInterface.switchPassengerButton(true);
					System.out.println(initDB.getOpenSeats(departureDate, fNum));
					break;
				}
			}
			if (!isFlight)
				System.err.println("No such flight!");
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
			return;
		}
		seats = initDB.getOpenSeats(departureDate, fNum);
		boolean isSeat = false;
		for (Seat seat : seats) {
			if (seat.getSeatNumber().equals(event.getSeat().getText())) {
				isSeat = true;
				System.out.println(initDB.addTicket(departureDate, passName, fNum, event.getSeat().getText()));
				viewInterface.switchPassengerButton(false);
				viewInterface.clearForm();
				System.out.println("Add new ticket?");
				break;
			}
		}
		if (!isSeat) {
			System.err.println("Invalid seat number!");
		}
	}

	@Override
	public void showTicketsEventPerformed() {
		tickets = initDB.getTickets();
		System.out.println("Tickets list:");
		for (Ticket ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}

	public void setMainView(ViewInterface viewInterface) {
		this.viewInterface = viewInterface;
		
	}

}
