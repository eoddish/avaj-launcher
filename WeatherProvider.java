public class WeatherProvider {

	private static WeatherProvider weatherProvider;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {
		weatherProvider = new WeatherProvider();
}
	public static WeatherProvider getProvider() {
		WeatherProvider weatherProvider = new WeatherProvider();
		return weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates) {
		return weather[(int)Math.round(Math.random() * weather.length) % weather.length];
	}


}
