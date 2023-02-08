package chocAn;

import java.awt.Dimension;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Report generator for making member, provider,
 * EFT, and summary reports.
 * 
 * @author Justin Saye
 *
 */
public class ReportGenerator {
	
	/**
	 * Default constructor, no class variables.
	 */
	public ReportGenerator() {

	}
	
	/**
	 * Generates reports for all members and providers.
	 * Generates summary and EFT reports.
	 */
	public static void runMainAccountingProcedure() {
		String S = "";
		S = S + createMemberReports();
		S = S + createProviderReports();
		S = S + createSummaryReport();
		S = S + createEFTReport();
		try {
			FileWriter writer = new FileWriter("src/chocAn/outFiles/Reports.txt");
			writer.write(S);
			writer.close();
		}
		catch(Exception e) {
			System.out.println("ERROR: Failed to generate Reports file.");
		}		
	}
	
	/**
	 * Creates a text file in which all the
	 * member information is written to.
	 * This includes all Member class variables
	 * as well as all services provided to the member,
	 * sorted by date provided.
	 * The file's name is the member's name
	 * followed by the date the file was generated.
	 * 
	 * @param mem     The Member object for which the method is making a report
	 */
	public static String createMemberReports() {
		String S = "------------Member Reports------------\n";
		for (Member mem : MemberRecords.getMembers()) {
			//formating member data
			String mem_number = mem.getNumber();
			Calendar cal = Calendar.getInstance();
			String timeGot = String.format("%02d-%02d-%04d",cal.get(2)+1,cal.get(5),cal.get(1));
			String filePath = mem.getName()+"_"+timeGot;
			S = S + String.format("Report: %s%nName: %s%nNumber: %s%nAddress: %s%nCity: %s%nState: %s%nZip: %s%nServices Received:%n%n",
						filePath,mem.getName(),mem_number,mem.getAddress(),mem.getCity(),mem.getState(),mem.getZip());
			
			//creating an ArrayList consisting of all services sorted by date
			ArrayList<Service> sortedServices = new ArrayList<Service>();
			int addInd;
			long dateNum;
			for (Service ser : ServiceRecords.getServices()) {
				dateNum = ser.getDateVal();
				addInd = sortedServices.size()-1;
				while (addInd >= 0 && dateNum < sortedServices.get(addInd).getDateVal()) {
					addInd--;
				}
				sortedServices.add(addInd+1, ser);
			}
			
			//adds all service information to the string to be written
			for (Service service : sortedServices) {
				if (mem_number.equals(service.getMemberNumber())) {
					S = S + String.format("\tDate: %s%n\tProvider: %s%n\tService: %s%n%n",
						service.getServiceDate(),ProviderRecords.getProviderName(service.getProviderNumber()),ProviderDirectory.getServiceName(service.getServiceCode()));
				}
			}
			S = S+"\n";
		}
		
		JTextArea textArea = new JTextArea(S);
	    JScrollPane scrollPane = new JScrollPane(textArea);  
	    textArea.setLineWrap(true);  
	    textArea.setWrapStyleWord(true); 
	    scrollPane.setPreferredSize(new Dimension(500, 250));
	    JOptionPane.showMessageDialog(null, scrollPane, "Member Report!", 
	            JOptionPane.INFORMATION_MESSAGE);
		
		return S;
	}
	
	/**
	 * Creates a text file in which all the
	 * provider information is written to.
	 * This includes all Provider class variables
	 * as well as all services provided by the provider,
	 * sorted by time received.
	 * The file's name is the provider's name
	 * followed by the date the file was generated.
	 * 
	 * @param pro     The Provider object for which the method is making a report
	 */
	public static String createProviderReports() {
		String S = "------------Provider Reports------------\n";
		for (Provider pro : ProviderRecords.getProviders()) {
			//formating member data
			String pro_number = pro.getNumber();
			Calendar cal = Calendar.getInstance();
			String timeGot = String.format("%02d-%02d-%04d",cal.get(2)+1,cal.get(5),cal.get(1));
			String filePath = pro.getName()+"_"+timeGot;
			S = S + String.format("Report: %s%nName: %s%nNumber: %s%nAddress: %s%nCity: %s%nState: %s%nZip: %s%nServices Provided:%n%n",
						filePath,pro.getName(),pro_number,pro.getAddress(),pro.getCity(),pro.getState(),pro.getZip());
			
			//creating an ArrayList consisting of all services sorted by time received
			ArrayList<Service> sortedServices = new ArrayList<Service>();
			int addInd;
			long dateNum;
			for (Service ser : ServiceRecords.getServices()) {
				dateNum = ser.getTimeVal();
				addInd = sortedServices.size()-1;
				while (addInd >= 0 && dateNum < sortedServices.get(addInd).getTimeVal()) {
					addInd--;
				}
				sortedServices.add(addInd+1, ser);
			}
			
			//adds all service information to the string to be written while keeping track of global service info
			int consultation_count = 0;
			double fee;
			double total_fee = 0;
			for (Service service : sortedServices) {
				if (pro_number.equals(service.getProviderNumber())) {
					fee = ProviderDirectory.getServiceFee(service.getServiceCode());
					S = S + String.format("\tDate: %s%n\tTime Received: %s%n\tMember Name: %s%n\tMember Number: %s%n\tService Code: %s%n\tFee: $%.2f%n%n",
						service.getServiceDate(),service.getTimeReceived(),MemberRecords.getMemberName(service.getMemberNumber()),service.getMemberNumber(),service.getServiceCode(),fee);
					consultation_count++;
					total_fee = total_fee + fee;
				}
			}
			
			//adds global info to string
			S = S + String.format("Total Consultations: %d%nTotal Fees: $%.2f%n%n%n", consultation_count, total_fee);
		}
		
		JTextArea textArea = new JTextArea(S);
	    JScrollPane scrollPane = new JScrollPane(textArea);  
	    textArea.setLineWrap(true);  
	    textArea.setWrapStyleWord(true); 
	    scrollPane.setPreferredSize(new Dimension(500, 250));
	    JOptionPane.showMessageDialog(null, scrollPane, "Proivder Report!", 
	            JOptionPane.INFORMATION_MESSAGE);
		return S;
	}
	
	/**
	 * Prints a report consisting of every
	 * provider's name, number of consultations,
	 * and total of fees charged.
	 * The report also contains the total number of
	 * providers, number of consultations, and fees
	 * charged across the chocAn system.
	 */
	public static String createSummaryReport() {
		//initializing variables
		String S = "------------Summary Report------------\n";
		ArrayList<String> providerNumbers = new ArrayList<String>();
		ArrayList<Integer> providerCounts = new ArrayList<Integer>();
		ArrayList<Double> providerFees = new ArrayList<Double>();
		String number;
		int index;
		int total;
		int countTotal = 0;
		double feeTotal = 0;
		
		//loops through services and compiles service info for each provider
		for (Service service : ServiceRecords.getServices()) {
			number = service.getProviderNumber();
			index = providerNumbers.indexOf(number);
			if (index == -1) {
				providerNumbers.add(number);
				providerCounts.add(1);
				providerFees.add(ProviderDirectory.getServiceFee(service.getServiceCode()));
			}
			else {
				providerCounts.set(index, providerCounts.get(index) + 1);
				providerFees.set(index, providerFees.get(index) + ProviderDirectory.getServiceFee(service.getServiceCode()));
			}
		}
		
		//calculates global service info
		total = providerNumbers.size();
		for (int i = 0; i < total; i++) {
			countTotal = countTotal + providerCounts.get(i);
			feeTotal = feeTotal + providerFees.get(i);
		}
		
		//prints each provider's service info
		for (int i = 0; i < total; i++) {
			S = S + String.format("Provider: %s%n",ProviderRecords.getProviderName(providerNumbers.get(i)));
			S = S + String.format("Consultations: %d%nFees: $%.2f%n%n", providerCounts.get(i), providerFees.get(i));
		}
		
		//prints global service info
		S = S + String.format("Total Providers: %d%nTotal Consultations: %d%nTotal Fees: $%.2f%n%n%n", total,countTotal, feeTotal);
		
		JTextArea textArea = new JTextArea(S);
	    JScrollPane scrollPane = new JScrollPane(textArea);  
	    textArea.setLineWrap(true);  
	    textArea.setWrapStyleWord(true); 
	    scrollPane.setPreferredSize(new Dimension(500, 250));
	    JOptionPane.showMessageDialog(null, scrollPane, "Summary Report!", 
	            JOptionPane.INFORMATION_MESSAGE);
		return S;
	}

	/**
	 * Creates a text file containing all the
	 * EFT data. This contains similar information
	 * to the summary report. Each provider's name, 
	 * number, and total fee are written to the file.
	 */
	public static String createEFTReport() {
		//initializing variables
		String S = "------------EFT Report------------\n";
		ArrayList<String> providerNumbers = new ArrayList<String>();
		ArrayList<Double> providerFees = new ArrayList<Double>();
		String number;
		int index;
		
		//loops through services and compiles service info for each provider
		for (Service service : ServiceRecords.getServices()) {
			number = service.getProviderNumber();
			index = providerNumbers.indexOf(number);
			if (index == -1) {
				providerNumbers.add(number);
				providerFees.add(ProviderDirectory.getServiceFee(service.getServiceCode()));
			}
			else {
				providerFees.set(index, providerFees.get(index) + ProviderDirectory.getServiceFee(service.getServiceCode()));
			}
		}
		
		//writes each provider's service info to the string
		for (int i = 0; i < providerNumbers.size(); i++) {
			S = S + String.format("Name: %s%nNumber: %s%nFees: $%.2f%n%n", 
				ProviderRecords.getProviderName(providerNumbers.get(i)), providerNumbers.get(i), providerFees.get(i));
		}
		
		//trims string and writes it to file
		//S = S.substring(0,S.length()-2);
		JTextArea textArea = new JTextArea(S);
	    JScrollPane scrollPane = new JScrollPane(textArea);  
	    textArea.setLineWrap(true);  
	    textArea.setWrapStyleWord(true); 
	    scrollPane.setPreferredSize(new Dimension(500, 250));
	    JOptionPane.showMessageDialog(null, scrollPane, "EFT Report!", 
	            JOptionPane.INFORMATION_MESSAGE);
		return S;
	}
	
}