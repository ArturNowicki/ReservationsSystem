package reservations.model;

public class Flight {

	private int flightNumber;
	private String departureCity, arrivalCity;

	public Flight(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Flight(int flightNumber, String departureCity, String arrivalCity) {
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
//	@Override
//	public boolean equals(Object other) {
//	    if (other == null) return false;
//	    if (other == this) return true;
//	    if (!(other instanceof Flight))return false;
//	    Flight otherFlight = (Flight)other;
//	    if(otherFlight.flightNumber ==  this.flightNumber) return true;
//	    return false;
//	}
//
	@Override
	public String toString() {
		return "Flight number " + flightNumber + ", departureCity: " + departureCity + ", arrivalCity: " + arrivalCity;
	}

}
