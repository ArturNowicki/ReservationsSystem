package reservations;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import reservations.model.SeatsAndFlightsDB;

public class Console {

	public static void main(String[] args) {
//		initialize database
		SeatsAndFlightsDB prodDB = new SeatsAndFlightsDB();
		prodDB.bootstrap();
//		initialize console
		boolean always = true;
		BufferedReader screenInput = new BufferedReader(new InputStreamReader((System.in)));
//		loop
		while(always) {
//			ask for passName
			System.out.println("Name:");
			String passengerName = screenInput.readLine();
			boolean result = prodDB.addPassengers(name)
					
			always = false;
//			show flights
//			show seats
//			add ticket
//			repeat
			
		}
	}
	
}
