package reservations.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class TicketsDB {

	private ArrayList<Ticket> tickets;

	public TicketsDB() {
		tickets = new ArrayList<Ticket>();
	}

	public String addTicket(LocalDate departureDate, String passengerName, int flightNumber, int seatNumber) {
		Passenger ticketPassenger = null;
		return passengerName;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

}
