package app;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String output = getType() +
                "#" + getName() + "(" + getId() + "): ";
		switch (weather) {
			case "SUN":
				coordinates.setLongitude(coordinates.getLongitude() + 2);
				coordinates.setHeight(coordinates.getHeight() + 4);
				Tower.printLine(output + "Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				coordinates.setHeight(coordinates.getHeight() - 5);
				Tower.printLine(output + "Damn you rain! You messed up my baloon.");
				break;
			case "FOG":
				coordinates.setHeight(coordinates.getHeight() - 3);
				Tower.printLine(output + "Great. So much fog I think I'm gonna fall asleep.");
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() - 15);
				Tower.printLine(output + "It's snowing. We're gonna crash.");
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
		return "Baloon";
	}
	public long getId() {
		return id;
	}
	public WeatherTower getWeatherTower() {
        return weatherTower;
    }
}
