package app;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String output = getType() +
                "#" + getName() + "(" + getId() + "): ";
		switch (weather) {
			case "SUN":
				coordinates.setLongitude(coordinates.getLongitude () + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
				Tower.printLine(output + "This is hot.");
				break;
			case "RAIN":
				coordinates.setLongitude(coordinates.getLongitude() + 5);
				Tower.printLine(output + "It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				coordinates.setLongitude(coordinates.getLongitude () + 1);
				Tower.printLine(output + "It's foggy. I can't see a thing!");
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() - 12);
				Tower.printLine(output + "My rotor is going to freeze!");
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
		return "Helicopter";
	}
	public long getId() {
		return id;
	}
	public WeatherTower getWeatherTower() {
		return weatherTower;
	}

}
