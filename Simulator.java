import java.io.*;
public class Simulator {


	public static void main(String[] args) throws IOException {
		
		if (args.length != 1 ) {
			System.out.println("Wrong number of arguments!");
			return;
		}

		BufferedReader in = null;
		BufferedWriter out = null;
		Integer numberOfSimulations;

		try {
			in = new BufferedReader(FileInputStream(args[0]));
			out = new BufferedWriter(new FileOutputStream("simulation.txt")); 
			String line;
			line = in.readLine();
			numberOfSimulations = parseInt(line);
			while ((line = in.readLine()) != null) {
				String[] parts = line.split(" ");
				AircraftFactory.newAircraft(parts[0], parts[1], parts[2].parseInt, parts[3].parseInt, parts[4].parseInt);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

