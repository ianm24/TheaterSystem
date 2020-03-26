package TheaterSystem;

/**
 * 
 * @author Miles This is the admin class
 */
public class Admin extends User {
	public boolean isAdmin;

	/**
	 * 
	 * @param firstName   The admin's first name
	 * @param lastName    The admin's last name
	 * @param password    The admin's password
	 * @param phoneNumber The admin's phone number
	 * @param isAdmin     The validation that the user is an admin This constructor
	 *                    creates an Admin
	 */
	public Admin(String firstName, String lastName, String password, String phoneNumber, boolean isAdmin) {
		super(firstName, lastName, password, phoneNumber);
		this.isAdmin = isAdmin;
	}
}
