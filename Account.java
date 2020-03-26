package TheaterSystem;
/**
 * 
 * @author Miles
 * This is the account class
 */
public class Account {
  public String firstName;
  private String lastName;
  private int ticketsPurchased;
  
  /**
   * 
   * @param firstName
   * @param lastName
   * This constructor creates an account
   */
  public Account(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
