public abstract class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Flyable aircraft = null;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter")) 
			aircraft = new Helicopter(name, coordinates);
		else if (type.equals("JetPlane"))
			aircraft = new JetPlane(name, coordinates);
		else if (type.equals("Baloon"))
			aircraft = new Baloon(name, coordinates);

		return aircraft;
	}

}
