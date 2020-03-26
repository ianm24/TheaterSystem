package TheaterSystem;

/**
 * 
 * @author Sharpscore Class for seats within the theaters
 */
public class Seat {
	public boolean isHandicapable;
	public boolean isReserved;
	public char row;
	public int col;

	/**
	 * Constructor
	 * 
	 * @param boolean for if the seat is handicap accessable
	 * @param row     the seat is in
	 * @param col     the seat is in
	 */
	public Seat(boolean isHandicapable, char row, int col) {
		this.isHandicapable = isHandicapable;
		this.row = row;
		this.col = col;
	}

	/**
	 * Method for setting the Reserved-ness of a seat
	 * 
	 * @param isReserved
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
}
