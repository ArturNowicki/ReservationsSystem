package reservations.model;

import java.time.LocalDate;

public class Ticket {
	
	private LocalDate departureDate;
	private Passenger passenger;
	private Flight flight;
	private Seat seat;
	
	public Ticket(LocalDate departureDate, Passenger passenger, Flight flight, Seat seat) {
		this.departureDate = departureDate;
		this.passenger = passenger;
		this.flight = flight;
		this.seat = seat;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public Seat getSeat() {
		return seat;
	}


	@Override
	public String toString() {
		return "Ticket created: " + passenger
				+ ", " + flight + ", " + seat + ".";
	}
	
	
}
