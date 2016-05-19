package reservations.view;

import javax.swing.JTextField;

public class FlightEvent {
	private JTextField flightNumber;
	
	public FlightEvent(JTextField flightNumber) {
		this.flightNumber = flightNumber;
	}
	public JTextField getFlightNumber() {
		return flightNumber;
	}
}
