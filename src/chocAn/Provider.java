package chocAn;

/**
 * Provider class.
 *
 * @author Andy
 *
 */
public class Provider extends User {

  /**

  * Default constructor.

  */

  public Provider() {

  }

  public Provider(String _name, String _number, String _address, String city, String _state, String _zip) {
    this.name = _name;
    this.number = _number;
    this.address = _address;
    this.city = city;
    this.state = _state;
    this.zip = _zip;
  }
    
}