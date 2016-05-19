package reservations.view;

public interface ButtonsEventListener {
	void showFlightsEventPerformed();
	void selectFlightEventPerformed(FlightEvent event);
	void addPassengerEventPerformed(PassengerEvent event);
}
