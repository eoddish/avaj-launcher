package app;

public interface Flyable {

	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);

	public String getName();
	public String getType();
	public long getId();
	public Coordinates getCoordinates();
	public WeatherTower getWeatherTower();
}
