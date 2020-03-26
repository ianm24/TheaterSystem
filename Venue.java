package TheaterSystem;

/**
 * Venue class that will contain the theaters
 */
import java.util.ArrayList;

public class Venue {
	private ArrayList<Theater> theaters;
	private String name;

	/**
	 * Constructor
	 * 
	 * @param name of the venue
	 */
	public Venue(String name) {
		this.name = name;
		this.theaters = new ArrayList<Theater>();
	}

	/**
	 * Method that adds a theater for this venue
	 * 
	 * @param arraylist for the seats in the venue
	 */
	public void addTheater(ArrayList<Seat> seats) {
		Theater theater = new Theater(seats, this);
		this.theaters.add(theater);
	}
}