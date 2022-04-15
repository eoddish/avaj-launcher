public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				coordinates.setLongitude(coordinates.getLongitude () + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
				break;
			case "RAIN":
				coordinates.setLongitude(coordinates.getLongitude() + 5);
				break;
			case "FOG":
				coordinates.setLongitude(coordinates.getLongitude () + 1);
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() + 2);
				break;
		}
		
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
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

}
