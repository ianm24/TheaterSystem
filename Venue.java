package TheaterSystem;

import java.util.ArrayList;
public class Venue {
	private ArrayList<Theater> theaters;
	private String name;
	
	public Venue(String name) {
		this.name = name;
		this.theaters = new ArrayList<Theater>();
	}
	
	public void addTheater(ArrayList<Seat> seats) {
		Theater theater = new Theater(seats, this);
		this.theaters.add(theater);
	}
}