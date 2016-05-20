package reservations.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeatsAndFlightsDB {

	private ArrayList<Seat> seats;
	private ArrayList<Flight> flights;
	private ArrayList<Passenger> passengers;
	private ArrayList<Ticket> tickets;

	public SeatsAndFlightsDB() {
		seats = new ArrayList<Seat>();
		flights = new ArrayList<Flight>();
		passengers = new ArrayList<Passenger>();
		tickets = new ArrayList<Ticket>();
	}

	public void addSeat(String seatNumber) {
		seats.add(new Seat(seatNumber));
	}

	public void addFlight(int flightNo, String dep, String arr) {
		flights.add(new Flight(flightNo, dep, arr));
	}

	public String addTicket(LocalDate departureDate, String passengerName, int flightNumber, String seatNumber) {
		Passenger ticketPassenger = null;
		for (Passenger item : getPassengers()) {
			if (passengerName.equals(item.getName()))
				ticketPassenger = item;
		}

		Flight ticketFlight = null;
		for (Flight item : getFlights()) {
			if (flightNumber == item.getFlightNumber())
				ticketFlight = item;
		}

		Seat ticketSeat = null;
		for (Seat item : getSeats()) {
			if (seatNumber.equals(item.getSeatNumber()))
				ticketSeat = item;
		}

		Ticket tmpTicket = new Ticket(departureDate, ticketPassenger, ticketFlight, ticketSeat);

		return tmpTicket.toString();
	}

	public ArrayList<Seat> getOpenSeats(LocalDate departureDate, int flightNumber) {
		ArrayList<Seat> openSeats = getSeats();
		for (Ticket item : getTickets()) {
			if (item.getDepartureDate().equals(departureDate) && item.getFlight().getFlightNumber() == flightNumber) {
				openSeats.remove(item.getSeat());
			}
		}
		return openSeats;
	}

	public boolean addPassengers(String name) {
		boolean passengerAdd = true;
		for (Passenger passenger : passengers) {
			if (passenger.getName().equals(name)) {
				passengerAdd = false;
				System.err.println("Passenger: " + name + "already exists!");
			} else {
				passengers.add(new Passenger(name));
				System.out.println("Passenger: " + name + "added to database.");
			}
		}
		return passengerAdd;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void bootstrap() {
		addSeat("A01");
		addSeat("A02");
		addSeat("A03");
		addSeat("A04");
		addSeat("B01");
		addSeat("B02");
		addSeat("B03");
		addSeat("B04");

		addFlight(1245, "LA", "NY");
		addFlight(8546, "NY", "LA");
		addFlight(8731, "SF", "NY");
		addFlight(6648, "NY", "SF");
		addFlight(3374, "LA", "SF");
		addFlight(7991, "SF", "LA");
	}
}
