package reservations.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import reservations.controller.ViewInterface;

public class MainGUI extends JFrame implements ViewInterface {

	private JTextField fNumber, name, seat;
	private JButton showFlightsBtn, selectFlightBtn, addPassengerBtn, listTicketsBtn;
	private ButtonsEventListener listener;

	public MainGUI() {

		initializeGUI();
		
		showFlightsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.showFlightsEventPerformed();
			}
		});

		selectFlightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.selectFlightEventPerformed(new FlightEvent(fNumber));
			}
		});

		addPassengerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.addPassengerEventPerformed(new PassengerEvent(name, seat));
			}
		});
		
		listTicketsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.showTicketsEventPerformed();
			}
		});

	}

	@Override
	public void clearForm() {
		fNumber.setText(null);
		name.setText(null);
		seat.setText(null);
	}

	@Override
	public void switchPassengerButton(boolean isEnable) {
		addPassengerBtn.setEnabled(isEnable);
	}

	public void setShowFlightsEventListener(ButtonsEventListener listener) {
		this.listener = listener;
	}

	private void initializeGUI() {
		// set layout
		setLayout(new GridLayout(7, 0));

		// create elements
		showFlightsBtn = new JButton("Flights");
		selectFlightBtn = new JButton("Select Flight");
		addPassengerBtn = new JButton("Add Passenger");
		listTicketsBtn = new JButton("Tickets");

		addPassengerBtn.setEnabled(false);

		fNumber = new JTextField(null);
		name = new JTextField("");
		seat = new JTextField(null);

		// add elements to container
		Container c = getContentPane();
		c.add(showFlightsBtn);
		c.add(fNumber);
		c.add(selectFlightBtn);
		c.add(name);
		c.add(seat);
		c.add(addPassengerBtn);
		c.add(listTicketsBtn);

		setLocationRelativeTo(null);
		setSize(200, 280);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
