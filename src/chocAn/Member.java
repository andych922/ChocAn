package chocAn;

/**
 * member class.
 *
 * @author Andy
 *
 */
public class Member extends User {
	
  /**
   * Default constructor.

   */

  private boolean isSuspended;

  public Member() {

  }

  /**
   * constructor.
   * 

   * @param name
   * 
   * @param number
   * 
   * @param address
   * 
   * @param city
   * 
   * @param state
   * 
   * @param zip
   * 
   */
  public Member(String name, String number, String address, String city, String state, String zip) {
    this.name = name;
    this.number = number;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.isSuspended = false;
  }

  public void setSuspended(boolean status) {
    this.isSuspended = status;
  }

  public boolean getSuspended() {
    return this.isSuspended;
  }

}