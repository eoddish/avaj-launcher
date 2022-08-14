package app;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String output = getType() +
                "#" + getName() + "(" + getId() + "): ";
		switch (weather) {
			case "SUN":
				coordinates.setLatitude(coordinates.getLatitude() + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
				Tower.printLine(output + "Too much sun. Better put on my sunglasses.");
				break;
			case "RAIN":
				coordinates.setLatitude(coordinates.getLatitude() + 5);
				Tower.printLine(output + "It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				coordinates.setLatitude(coordinates.getLatitude() + 1);
				Tower.printLine(output + "OMG! That's quite a fog!");
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() - 7);
				Tower.printLine(output + "OMG! Winter is coming!");
				break;
		}
				
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

	public String getName() {
		return name;
	}
	public String getType() {
		return "JetPlane";
	}
	public long getId() {
		return id;
	}
	public WeatherTower getWeatherTower() {
        return weatherTower;
    }
}
