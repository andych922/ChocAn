package chocAn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Provider Records Class holds information about providers and returns provider names,
 * and checks if a name is a provider.
 *
 * @author Ashwin Suryaram
 * 
 */
public class ProviderRecords {
	/*
	 * the list that will store the providers
	 */
	static ArrayList<Provider> providerList = new ArrayList<Provider>();
	
	/*
	 * The file that holds Provider records
	 * Reads and stores the file
	 * @throws "ERROR: Provider file not found." when providers.txt is not found
	 */
	
	static {
		File file = new File("src/chocAn/dataFiles/providers.txt");
		try {
        	Scanner reader = new Scanner(file);
			String[] entries = new String[6];
			int i, pi;
			int index;
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				index = 0;
				pi = 0;
				for (i=0; i<data.length(); i++) {
					if(data.charAt(i) == '~') {
						entries[index] = data.substring(pi,i);
						pi = i+1;
						index++;
					}
				}
				providerList.add(new Provider(entries[0], entries[1], entries[2], entries[3], entries[4], entries[5]));
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR: Provider file not found.");
		}
	}

	/*
	 * Default constructor
	 */
	public ProviderRecords() {
		
	}

	/*
	 * Returns provider list
	 * @return a list of providers generated from the file scanner
	 */
	public static ArrayList<Provider> getProviders() {
		return providerList;
	}
	
	/*
	 * Returns a provider given their code
	 * @return a single provider, given their number exists in providers.txt; else return null
	 */
	public static Provider getProvider(String code) {
		for(Provider pro : providerList) {
			if(code.equals(pro.getNumber())) return pro;
		}
		return null;
	}
	
	/*
	 * Gives a provider name in a certain position in the list
	 * @return Name of provider at position pos in providerList
	 */
	public static String getProviderName(int pos) {
		return providerList.get(pos).getName();
	}
	
	/*
	 * Gives a provider name given their code
	 * @return A providers name, given their code exists in the list; else return blank ""
	 */
	public static String getProviderName(String code) {
		for(int i = 0; i < providerList.size(); i++) {
			if(code.equals(providerList.get(i).getNumber())) {
				return providerList.get(i).getName();
			}
		}
		return "";
	}
	
	/*
	 * Verifies if a provider's name is correct
	 * @return true if the name exists, false if it does not
	 */
	public static boolean isProviderName(String nameToSearch) {
		for (Provider p : providerList) {
            if( p.getName().equals(nameToSearch)){
                return true;
            }
        }
        return false;
	}
	
	/*
	 * Verifies if a number is linked to a provider
	 * @return true if a number is a provider's; false if not
	 */
	public static boolean isProviderNum(String numToSearch) {
		for(int i = 0; i < providerList.size(); i++) {
			if(numToSearch.equals(providerList.get(i).getNumber())) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Verifies if a provider exists based on their number
	 * @return true if the provider exists; false if not
	 */
	public static boolean providerExists(String numToSearch) {
		for (Provider p : providerList) {
            if( p.getNumber().equals(numToSearch)){
                return true;
            }
        }

        return false;
	}
}