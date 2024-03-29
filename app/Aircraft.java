package app;

public abstract class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		id = idCounter;
		this.name = name;
		this.coordinates = coordinates;
		++idCounter;
	}
	private long nextId() {
		return idCounter;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

}
