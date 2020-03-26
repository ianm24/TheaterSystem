package TheaterSystem;

/*
 * Miles Littlejohn
 */
public class User extends Account {
  private String password;
  private String phoneNumber;
  
  
  /*
   * Creates a user account with a first and last name, password, and phone number
   */
  public User (String firstName, String lastName, String password, String phoneNumber) {
    super(firstName, lastName);
    this.password = password;
    this.phoneNumber = phoneNumber;
  }
}
