package TheaterSystem;

public class Seat {
	public boolean isHandicapable;
	public boolean isReserved;
	public char row;
	public int col;
	
	public Seat(boolean isHandicapable, char row, int col) {
		this.isHandicapable = isHandicapable;
		this.row = row;
		this.col = col;
	}
	
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
}
