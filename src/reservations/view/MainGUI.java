package reservations.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainGUI extends JFrame {

	private JTextField fNumber, name, seat;
	private JButton showFlightsBtn, selectFlightBtn, addPassengerBtn;
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

	}

	public void clearForm() {
		fNumber.setText(null);
		name.setText(null);
		seat.setText(null);
	}

	public void switchPassengerButton(Boolean isEnable) {
		addPassengerBtn.setEnabled(isEnable);
	}

	public void setShowFlightsEventListener(ButtonsEventListener listener) {
		this.listener = listener;
	}

	private void initializeGUI() {
		// set layout
		setLayout(new GridLayout(6, 0));

		// create elements
		showFlightsBtn = new JButton("Flights");
		selectFlightBtn = new JButton("Select Flight");
		addPassengerBtn = new JButton("Add Passenger");

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

		setLocationRelativeTo(null);
		setSize(200, 280);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
