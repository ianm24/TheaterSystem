package TheaterSystem;

/***
 * @author Miles
 * This is the employee class to create an employee
 */
public class Employee extends User {
  public boolean isEmployee;
  
  /**
   * 
   * @param firstName The employee's first name
   * @param lastName The employee's last name
   * @param password The employee's password
   * @param phoneNumber The employee's phone number
   * @param isEmployee The validation that the user is an employee
   * This constructor creates an Employee
   */
  public Employee (String firstName, String lastName, String password, String phoneNumber, boolean isEmployee) {
    super(firstName, lastName, password, phoneNumber);
    this.isEmployee = isEmployee;
  }
}
