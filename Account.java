package TheaterSystem;

/*
 * The account class
 * Miles Littlejohn
 */
public class Account {
	public String firstName;
	private String lastName;
	private int ticketsPurchased;

	/*
	 * Creates an account with inputed first and last names
	 */
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
