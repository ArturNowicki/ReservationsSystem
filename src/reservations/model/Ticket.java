package reservations.model;

public class Ticket {
	
	private String ticketNumber;
	private Passenger passenger;
	private Flight flight;
	private Seat seat;
	
	public Ticket(String ticketNumber, Passenger passenger, Flight flight, Seat seat) {
		this.ticketNumber = ticketNumber;
		this.passenger = passenger;
		this.flight = flight;
		this.seat = seat;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", passenger=" + passenger
				+ ", flight=" + flight + ", seat=" + seat + "]";
	}
	
	
}
