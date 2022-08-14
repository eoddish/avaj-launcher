package app;

import java.io.*;
import java.util.*;


public class Simulator {
	static class CoordinatesOutOfRangeException extends Exception {
		CoordinatesOutOfRangeException(String text) {
			super(text);
		}
	}
	static class InvalidInputException extends Exception {
		InvalidInputException(String text) {
			super(text);
		}
	}

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.out.println("Wrong number of arguments!");
			return;
		}

		BufferedReader in = null;
		Integer numberOfSimulations;

		// existing file checked
		File file = new File("simulation.txt");
		if (file.exists())
			file.delete();

		try {
			file.createNewFile();
			;
			in = new BufferedReader(new FileReader(args[0]));
			String line;
			line = in.readLine();
			numberOfSimulations = Integer.parseInt(line);
			WeatherTower weatherTower = new WeatherTower();
			LinkedList<Flyable> aircrafts = new LinkedList<Flyable>();
			while ((line = in.readLine()) != null) {
				String[] parts = line.split(" ");
				int lng = Integer.parseInt(parts[2]);
				int lat = Integer.parseInt(parts[3]);
				int h = Integer.parseInt(parts[4]);
				if (lng < 0 || lat < 0 || h < 0 || h > 100)
					throw new CoordinatesOutOfRangeException("Coordinates aren't in available range!");
				Flyable aircraft = AircraftFactory.newAircraft(parts[0], parts[1], lng, lat, h);
				if (aircraft == null)
					throw new InvalidInputException("Invalid input!");
				aircraft.registerTower(weatherTower);
				aircrafts.add(aircraft);
			}
			in.close();

			for (int i = 0; i < numberOfSimulations; i++) {
				weatherTower.changeWeather();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
