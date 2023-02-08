package chocAn;

import java.io.FileWriter;

public class ProviderDirectory {
	
	private static String[] services = {"Dietitian Session", "Group Exercise", "Group Therapy", "Hypnosis Session", "Personal Training", "Private Therapy"};
	private static String[] codes = {"000000", "111111", "222222", "333333", "444444", "555555"};
	private static double[] fees = {40.0, 15.0, 20.0, 75.0, 45.0, 60.0};
	
	public static String[] getServiceCodes() {
		return codes;
	}
	
	public static String getServiceName(String code) {
		int pos = -1;
		String error = "Code not found";
		for(int i = 0; i < codes.length; i++) {
			if(code.equals(codes[i])) {
				pos = i;
			}
		}
		if(pos == -1) return error;
		return services[pos];
	}
	
	public static double getServiceFee(String code) {
		int pos = -1;
		double error = -1.0;
		for(int i = 0; i < codes.length; i++) {
			if(code.equals(codes[i])) {
				pos = i;
			}
		}
		if(pos == -1) return error;
		return fees[pos];
	}
	
	public static void printProviderDirectory() {
		String filePath = "src/chocAn/outFiles/ProviderDirectory.txt";
	    String S = "         Service         |   Code   |    Fee   \n-------------------------|----------|----------\n";
		for (int i = 0; i < codes.length; i++) {
			S = S + String.format("%-25s|%-10s|$%-10.2f%n", services[i], codes[i], fees[i]);
		}
		S = S.substring(0,S.length()-2);
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(S);
			writer.close();
		}
		catch(Exception e) {
			System.out.println("ERROR: Failed to create provider directory file.");
		}
	}
}