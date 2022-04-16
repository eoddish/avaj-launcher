import java.util.*;
import java.io.*;

public abstract class Tower {

	private LinkedList<Flyable> observers = new LinkedList<Flyable>();
	
	public void register(Flyable flyable) {
		observers.add(flyable);	
		String output = "Tower says: " + flyable.getType() + 
			"#" + flyable.getName() + "(" + flyable.getId() + ")" +
			" registered to weather tower.";
		printLine(output);	
	}
	public void unregister(Flyable flyable) {
		String output = "Tower says: " + flyable.getType() + 
			"#" + flyable.getName() + "(" + flyable.getId() + ")" +  
			" unregistered from weather tower.";
		printLine(output);
		//observers.remove(flyable);
	}

	protected void conditionsChanged() {
		Iterator<Flyable> iterator = observers.iterator();
		while ( iterator.hasNext() ) {
			Flyable observer = iterator.next();
			observer.updateConditions();
			if (observer.getCoordinates().getHeight() == 0) {
				String output = observer.getType() +
					"#" + observer.getName() + "(" + observer.getId() + "): ";
				printLine(output + "landing at the coordinates: longitude " + observer.getCoordinates().getLongitude() + " latitude " + observer.getCoordinates().getLatitude() + ".");
				observer.getWeatherTower().unregister(observer);
				iterator.remove();
				
			}
		}
	}

	public static void printLine(String line) {
		try {
			BufferedWriter out = null;
			out = new BufferedWriter(new FileWriter("simulation.txt", true));
			out.write(line, 0, line.length());
			out.newLine();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
