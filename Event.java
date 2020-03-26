package TheaterSystem;

/**
 * Used to hold Event information
 * 
 * @author Ian McDowell
 *
 */
public class Event {
	public Venue venue;
	public Theater theater;
	public String startTime;
	public String endTime;

	/**
	 * Used to create a new Event
	 * 
	 * @param venue     The venue the event takes place
	 * @param theater   The theater the event takes place
	 * @param startTime The start time of the event
	 * @param endTime   The end time of the event
	 */
	public Event(Venue venue, Theater theater, String startTime, String endTime) {
		this.venue = venue;
		this.theater = theater;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Returns all the information about the Event
	 */
	public String toString() {
		return "Venue: " + this.venue + "\nTheater: " + this.theater + "\nStart Time: " + this.startTime
				+ "\nEnd Time: " + this.endTime;
	}
}
