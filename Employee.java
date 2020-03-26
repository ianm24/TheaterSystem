package TheaterSystem;

/***
 * @author Miles
 * This is the employee class to create an employee
 */
public class Employee extends User {
  public boolean isEmployee;
  
  /**
   * 
   * @param firstName
   * @param lastName
   * @param password
   * @param phoneNumber
   * @param isEmployee
   * This constructor creates an Employee
   */
  public Employee (String firstName, String lastName, String password, String phoneNumber, boolean isEmployee) {
    super(firstName, lastName, password, phoneNumber);
    this.isEmployee = isEmployee;
  }
}
