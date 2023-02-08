package chocAn;

/**
 * User class. This defines the characteristics of a user in the system.
 *
 * @author Andy
 *
 */
public class User {

  /**

   * Default constructor.

   */

  public User() {

  }
    
  protected String name;
  protected String number;
  protected String address;
  protected String city;
  protected String state;
  protected String zip;
  
  public String toString() {
	  return(this.name+"~"+this.number+"~"+this.address+"~"+this.city+"~"+this.state+"~"+this.zip+"~");
  }
    
  /** This function returns the name of the user.

   * @return returns the name of the user
   */
  public String getName() {
    return this.name;
  }
    
  /** This function returns the number of the user.

   * @return returns the number of the user
   */
  public String getNumber() {
    return this.number;
  }
    
  /** This function returns the address of the user.

   * @return returns the address of the user
   */
  public String getAddress() {
    return this.address;
  }
    
  /** This function returns the city of the user.

   * @return returns the city of the user
   */
  public String getCity() {
    return this.city;
  }
    
  /** This function returns the state of the user.

   * @return returns the state of the user
   */
  public String getState() {
    return this.state;
  }
    
  /** This function returns the zip of the user.

   * @return returns the zip of the user
   */
  public String getZip() {
    return this.zip;
  }
    
  /** This function sets the name of the user.

   * @param name of user
   */
  public void setName(String name) {
    this.name = name;
  }
    
  /** This function sets the number of the user.

   * @param number of user
   */
  public void setNumber(String number) {
    this.number = number;
  }
    
  /** This function sets the address of the user.

   * @param address of user
   */
  public void setAddress(String address) {
    this.address = address;
  }
    
  /** This function sets the city of the user.

   * @param city of user
   */
  public void setCity(String city) {
    this.city = city;
  }
    
  /** This function sets the state of the user.

   * @param state of user
   */
  public void setState(String state) {
    this.state = state;
  }
    
  /** This function sets the zip of the user.

   * @param zip of user
   */
  public void setZip(String zip) {
    this.zip = zip;
  }


}