import java.io.*;
import java.util.*;
public class Simulator {


	public static void main(String[] args) throws IOException {
		
		if (args.length != 1 ) {
			System.out.println("Wrong number of arguments!");
			return;
		}

		BufferedReader in = null;
		Integer numberOfSimulations;
		File file = new File("simulation.txt");

		try {
			file.createNewFile();;
			in = new BufferedReader(new FileReader(args[0]));
			String line;
			line = in.readLine();
			numberOfSimulations = Integer.parseInt(line);
			WeatherTower weatherTower = new WeatherTower();
			LinkedList<Flyable> aircrafts = new LinkedList<Flyable>();
			while ((line = in.readLine()) != null) {
				String[] parts = line.split(" ");
				Flyable aircraft = AircraftFactory.newAircraft(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
				if (aircraft == null) {
					System.out.println("Error!");
					return;
				}
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

