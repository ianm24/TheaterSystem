package TheaterSystem;

/**
 * 
 * @author Miles
 * This is the admin class
 */
public class Admin extends User {
  public boolean isAdmin;
  
  /**
   * 
   * @param firstName
   * @param lastName
   * @param password
   * @param phoneNumber
   * @param isAdmin
   * This constructor creates an Admin
   */
  public Admin (String firstName, String lastName, String password, String phoneNumber, boolean isAdmin) {
    super(firstName, lastName, password, phoneNumber);
    this.isAdmin = isAdmin;
  }
}

