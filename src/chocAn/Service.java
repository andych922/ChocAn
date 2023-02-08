package chocAn;

import java.util.Calendar;

/**
 * Service class.
 *
 * @author Andy
 *
 */
public class Service {
  private String serviceName;
  private String serviceDate;
  private String timeReceived;
  private String memberNumber;
  private String providerNumber;
  private String serviceCode;
  private String comments;

  /**

   * Default constructor.

   */

  public Service() {

  }

  public Service(String serviceName, String _serviceDate, String _memberNumber, String _providerNumber, String _serviceCode, String _comments) {
    this.serviceName = serviceName;
    Calendar cal = Calendar.getInstance();
    this.serviceDate = _serviceDate;
    this.timeReceived = String.format("%02d-%02d-%04d %02d:%02d:%02d",cal.get(2)+1,cal.get(5),cal.get(1),12*cal.get(0)+cal.get(10),cal.get(12),cal.get(13));
    this.memberNumber = _memberNumber;
    this.providerNumber = _providerNumber;
    this.serviceCode = _serviceCode;
    this.comments = _comments;
  }
    
  public Service(String serviceName, String _serviceDate, String _timeReceived, String _memberNumber, String _providerNumber, String _serviceCode, String _comments) {
    this.serviceName = serviceName;
    this.serviceDate = _serviceDate;
    this.timeReceived = _timeReceived;
    this.memberNumber = _memberNumber;
    this.providerNumber = _providerNumber;
    this.serviceCode = _serviceCode;
    this.comments = _comments;
  }
  
  public String toString() {
	  return(this.serviceDate+"~"+this.timeReceived+"~"+this.memberNumber+"~"+this.providerNumber+"~"+this.serviceCode+"~"+this.comments+"~");
  }

  public long getDateVal() {
    long month = Long.valueOf(this.serviceDate.substring(0,2))-1;
    long day = Long.valueOf(this.serviceDate.substring(3,5))-1;
    long year = Long.valueOf(this.serviceDate.substring(6))-2000;
    return(day + 31*month + 375*year);
  }

  public long getTimeVal() {
    long month = Long.valueOf(this.timeReceived.substring(0,2))-1;
    long day = Long.valueOf(this.timeReceived.substring(3,5))-1;
    long year = Long.valueOf(this.timeReceived.substring(6,10))-2000;
    long hour = Long.valueOf(this.timeReceived.substring(11,13));
    long minute = Long.valueOf(this.timeReceived.substring(14,16));
    long second = Long.valueOf(this.timeReceived.substring(17));
    return(86400*(day + 31*month + 375*year) + (3600*hour + 60*minute + second));
  }
    
  /** This function returns the service date.

  * @return returns the service date
  */
  public String getServiceName() {
    return this.serviceName;
  }
    
  public String getServiceDate() {
    return this.serviceDate;
  }
    
  /** This function returns the time received.

   * @return returns the time received
   */
  public String getTimeReceived() {
    return this.timeReceived;
  }   
    
  /** This function returns the member number.

   * @return returns the member number
   */
  public String getMemberNumber() {
    return this.memberNumber;
  }
    
  /** This function returns the provider number.

   * @return returns the provider number
   */
  public String getProviderNumber() {
    return this.providerNumber;
  }
    
  /** This function returns the service code.

   * @return returns the service code
   */
  public String getServiceCode() {
    return this.serviceCode;
  }
    
  /** This function returns the comments.

   * @return returns the comments
   */
  public String getComments() {
    return this.comments;
  }
}