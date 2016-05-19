package reservations.model;

import java.util.ArrayList;

public class SeatsAndFlightsDB {

	private ArrayList<Seat> seats;
	private ArrayList<Flight> flights;
	
	public SeatsAndFlightsDB() {
		seats = new ArrayList<Seat>();
		flights = new ArrayList<Flight>();
	}
	
	public void addSeat(String seatNumber) {
		seats.add(new Seat(seatNumber));
	}

	public void addFlight(int flightNo, String dep, String arr) {
		flights.add(new Flight(flightNo, dep, arr));
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

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	
}
