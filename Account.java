package TheaterSystem;

/**
 * 
 * @author Miles This is the account class
 */
public class Account {
	public String firstName;
	private String lastName;
	private int ticketsPurchased;

	/**
	 * 
	 * @param firstName The first name for the owner of the account
	 * @param lastName  The last name for the owner of the account This constructor
	 *                  creates an account
	 */
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * getter method
	 * @return the last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	

}
