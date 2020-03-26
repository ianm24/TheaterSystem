package TheaterSystem;

/***
 * This class is for guest accounts
 * 
 * @author Bekah
 *
 */
public class Guest extends Account {
	public boolean isGuest;

	/***
	 * This method is a constructor
	 */
	public Guest() {
		super("Guest", "User");
		this.isGuest = true;
	}
}
