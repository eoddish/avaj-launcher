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

/*	private  void printLine(String line) {
        try {
            BufferedWriter out = null;
            out = new BufferedWriter(new FileWriter("simulation.txt", true));
            out.write(line, 0, line.length());
            out.newLine();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	*/
}
