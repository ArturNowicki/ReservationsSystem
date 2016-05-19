package reservations;

import javax.swing.SwingUtilities;

import reservations.controller.Controller;
import reservations.model.SeatsAndFlightsDB;
import reservations.view.MainGUI;

public class MainApp {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runApp();
			}
		});
	}
	public static void runApp() {
		MainGUI mainFrame = new MainGUI();
		SeatsAndFlightsDB initDB = new SeatsAndFlightsDB();
		Controller controller = new Controller(initDB, mainFrame);
		mainFrame.setShowFlightsEventListener(controller);
	}
}
