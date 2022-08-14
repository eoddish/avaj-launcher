package app;

public abstract class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Flyable aircraft = null;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter") || type.equals("2ab8b43468e8b92b0fc5c81e70e35a2d"))
			aircraft = new Helicopter(name, coordinates);
		else if (type.equals("JetPlane") || type.equals("554cd647d6b135f7e36ab1214c5e816a"))
			aircraft = new JetPlane(name, coordinates);
		else if (type.equals("Baloon") || type.equals("994736b4f0aec72f6e5ae580051d012f"))
			aircraft = new Baloon(name, coordinates);

		return aircraft;
	}

}
