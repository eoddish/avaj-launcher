public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Aircraft aircraft;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type == "Helicopter") 
			aircraft = new Helicopter(name, coordinates);
		else if (type == "JetPlane")
			aircraft = new JetPlane(name, coordinates);
		else if (type == "Baloon")
			aircraft = new Baloon(name, coordinates);

		return aircraft;
	}

}
