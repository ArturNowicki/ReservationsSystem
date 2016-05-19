package reservations.view;

import javax.swing.JTextField;

import reservations.model.Passenger;
import reservations.model.Seat;

public class PassengerEvent {

	private JTextField name, seat;

	public PassengerEvent(JTextField name, JTextField seat) {
		this.name = name;
		this.seat = seat;
	}

	public JTextField getName() {
		return name;
	}

	public JTextField getSeat() {
		return seat;
	}
	
	
	
}
