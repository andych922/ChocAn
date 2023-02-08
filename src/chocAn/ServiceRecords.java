package chocAn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Service Records class.
 *
 * @author Andy
 *
 */
public class ServiceRecords {
	

  //public static ArrayList<Service> serviceList = new ArrayList<Service>();

  static ArrayList<Service> serviceList = new ArrayList<Service>();

  static {
    File file = new File("src/chocAn/dataFiles/services.txt");
    try {
      Scanner reader = new Scanner(file);
      String[] entries = new String[6];
      int i;
      int pi;
      int index;
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        index = 0;
        pi = 0;
        for (i = 0; i < data.length(); i++) {
          if (data.charAt(i) == '~') {
            entries[index] = data.substring(pi, i);
            pi = i + 1;
            index++;
          }
        }
        serviceList.add(new Service(ProviderDirectory.getServiceName(entries[4]), entries[0], entries[1], entries[2], entries[3], entries[4], entries[5]));
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: Service file not found.");
    }
  }

  /**

   * Default constructor.

   */

  public ServiceRecords() {

  }

  /** This function returns the service array.

   * @return returns the service array
   */

  public static ArrayList<Service> getServices() {
    return ServiceRecords.serviceList;
  }

  /** This function checks if service exists.

   * @return returns bool
   */
  
  public static boolean serviceExists(String numToSearch) {
    for (Service s : serviceList) {
      if (s.getServiceCode().equals(numToSearch)) {
        return true;
      }
    }
    return false;
  }
}