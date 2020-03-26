package TheaterSystem;

/**
 * 
 * @author Miles
 * This is the User class to create a user
 */
public class User extends Account {
  private String password;
  private String phoneNumber;
  
  
  /**
   * 
   * @param firstName
   * @param lastName
   * @param password
   * @param phoneNumber
   * This constructor creates a User
   */
  public User (String firstName, String lastName, String password, String phoneNumber) {
    super(firstName, lastName);
    this.password = password;
    this.phoneNumber = phoneNumber;
  }
}
