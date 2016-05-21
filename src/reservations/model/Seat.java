package reservations.model;

public class Seat {
	private String seatNumber;

	public Seat(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Seat number " + seatNumber;
	}
	
	
}
