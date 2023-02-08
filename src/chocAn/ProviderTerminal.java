package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * This class is the terminal for providers to go through and select different functions to complete 
 * their class.
 * 
 * @author raheemcrayton
 * version 1.0
 *
 */

public class ProviderTerminal extends Terminal{

    public static String providerCode = "1111";
    
    public static ProviderTerminal pAccess = new ProviderTerminal();
    
    private static String currentProvider;

    public ProviderTerminal(){

    }
    
    /**This function is a void function that verifies the provider.
     * 
     */


    public static void verifyProvider(){
    	final ImageIcon pIcon = new ImageIcon("old/MadisonScott/User.png");
        String inputCode = (String) JOptionPane.showInputDialog(null, "Enter the code for Provider: ", "Provider Verification", JOptionPane.QUESTION_MESSAGE, pIcon, null, null);
        //boolean isRightCode = false;
        // int intValue;
        // try {
        //     intValue = Integer.parseInt(inputID);
        //     isDigit = true;
        // } catch (NumberFormatException e) {
        //     //System.out.println("Input String cannot be parsed to Integer.");
        //     isDigit = false;
        // }
        
        if (inputCode == null) return;
        
        while(!inputCode.equals(providerCode)){
            inputCode = JOptionPane.showInputDialog(null,"Provider Code is incorrect. Please try again.", "ChocAn", JOptionPane.ERROR_MESSAGE);
            if (inputCode == null) return;
        }
        
        String inputNumber = JOptionPane.showInputDialog(null, "Enter your Provider number: ", "ChocAn", JOptionPane.QUESTION_MESSAGE);
        
        if (inputNumber == null) return;
        
        while(!ProviderRecords.isProviderNum(inputNumber)){
        	inputNumber = JOptionPane.showInputDialog(null,"Provider Number does not exist. Please try again.", "ChocAn", JOptionPane.ERROR_MESSAGE);
            if (inputNumber == null) return;
        }
        
        currentProvider = inputNumber;

        providerMenu();
    
    }
    /**This function verifies the member.
     * 
     * @param pin
     * @return true when pin matches member pin
     */
    public static boolean verifyMember(int pin) {
    	int memPin = 0000;
		if(pin == memPin) {
			return true;
		}else {
			return false;
		}
    	
    }
    /**This is a void function for billing chocan.
     * 
     */
    public static void billChocAn() {
    	
    	int intValue;
        boolean isDigit = false;
        
        String billId = JOptionPane.showInputDialog(null, "Enter the ID for the Member you want to "
            + "bill a service: ", "ChocAn", JOptionPane.QUESTION_MESSAGE); 
        
        try {
          intValue = Integer.parseInt(billId);
          isDigit = true;
        } catch (NumberFormatException e) {
          isDigit = false;
        }
        
        if (billId == null) return;

        boolean validId = (billId.length() == 9) && isDigit && MemberRecords.memberExists(billId);
        boolean notSus = validId && !MemberRecords.getMember(billId).getSuspended();
        String prompt;
        
        while (!validId || !notSus) {
          if (validId) prompt = "This member's account is currently suspended";
          else prompt = "ID must only be 9 digits and belong to an existing member";
          billId = JOptionPane.showInputDialog(null, prompt+". Please enter another Member ID.", "ChocAn", JOptionPane.ERROR_MESSAGE);
          if (billId == null) return;
          try {
            intValue = Integer.parseInt(billId);
            isDigit = true;
          } catch (NumberFormatException e) {
            isDigit = false;
          }
          validId = (billId.length() == 9) && isDigit && MemberRecords.memberExists(billId);
          notSus = validId && !MemberRecords.getMember(billId).getSuspended();
        }
        
        System.out.println("Validated");
        
        
        String regex = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
        
        
        String billDate = JOptionPane.showInputDialog(null, "Enter the date of the service "
                + "provided: ", "ChocAn", JOptionPane.QUESTION_MESSAGE);
        
        if (billDate == null) return;
        
        while((billDate.length() != 10) || !(billDate.matches(regex))) { 
            billDate = JOptionPane.showInputDialog(null, "Date is invalid. Please enter another date.", "ChocAn", JOptionPane.ERROR_MESSAGE);
            if (billDate == null) return;
        }
        
        System.out.println(billDate);
        
        
        
        String billServiceCode = JOptionPane.showInputDialog(null, "Enter the code for the service "
                + "provided: ", "ChocAn", JOptionPane.QUESTION_MESSAGE); 
        
        if (billServiceCode == null) return;
            
        try {
          intValue = Integer.parseInt(billServiceCode);
          isDigit = true;
        } catch (NumberFormatException e) {
          isDigit = false;
        }
        
        while ((billServiceCode.length() != 6) || (isDigit == false) || ProviderDirectory.getServiceName(billServiceCode).equals("Code not found")) {
          billServiceCode = JOptionPane.showInputDialog(null, "Service code must only be 6 digits and belong to an "
              + "existing service. Please enter another service code.", "ChocAn", JOptionPane.ERROR_MESSAGE);
          if (billServiceCode == null) return;
          try {
            intValue = Integer.parseInt(billServiceCode);
            isDigit = true;
          } catch (NumberFormatException e) {
            isDigit = false;
          }
        }
        
        String billComments = JOptionPane.showInputDialog(null, "Enter any additional comments: "
                , "ChocAn", JOptionPane.QUESTION_MESSAGE);
        
        if (billComments == null) return;

        while (billComments.length() > 100) {
          billComments = JOptionPane.showInputDialog(null, "Comments must be at most 100 characters. Please try again."
                , "ChocAn", JOptionPane.ERROR_MESSAGE);
          if (billComments == null) return;
        }
        
        String billServiceName = ProviderDirectory.getServiceName(billServiceCode);
        if (!billServiceName.equals("Code not found")) {
          int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to bill for the service: " + billServiceName, "Print Directory", JOptionPane.YES_NO_OPTION);
          if (confirm == 0){
            JOptionPane.showMessageDialog(null, "Service has been billed!");
            ServiceRecords.serviceList.add(new Service(billServiceName, billDate, billId, currentProvider, billServiceCode, billComments));
          }
          return;
        }
        System.out.println("ERROR: service code does not exist");
            
            
            
        
//    	Service s = new Service();
//    	int intValue;
//        boolean isDigit = false;
//        JFrame frame = new JFrame();
//        frame.setPreferredSize(new Dimension(500, 250));
        
        
            
        //adds name
//        String addName = JOptionPane.showInputDialog(frame, "Enter member numbers: ", 
//            "ChocAn", JOptionPane.QUESTION_MESSAGE);
//        if (addName == null) {
//          ProviderTerminal.providerMenu();
//          Terminal.Quit();
//        }else {
//        	int memberNum = Integer.parseInt(addName);
//        	if(ProviderTerminal.verifyMember(memberNum) == true) {
//        		String addService = JOptionPane.showInputDialog(frame, "Enter service numbers: ", 
//        	            "ChocAn", JOptionPane.QUESTION_MESSAGE);
//        		if(addService.equals(s.getServiceCode())) {
//        			JOptionPane.showMessageDialog(frame, "Billing Chocan...");
//        		}else {
//        			Terminal.Quit();
//        		}
//        	}
//        }
    }
    
    /**This function pulls upp the provider menu.
     * 
     */

    public static void providerMenu(){
    	
    	while (true) {
    		final ImageIcon icon = new ImageIcon("/Users/madisonscott/git/Fall2022Team20/old/MadisonScott/ProviderMenu.png");
	        Object [] options = {"Bill for Service", "Request Provider Directory", "Return to Main Menu"};
	        int choice = JOptionPane.showOptionDialog(null, "Choose an Option", "ChocAn", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
	        
	        // "Add another Member"
	        if (choice == 0){
	            System.out.println("billChocAn()");
	            billChocAn();
	            // "Remove Member"
	        }
	        else if (choice == 1){
	            System.out.println("RequestDirectory()");  
	            ProviderDirectory.printProviderDirectory();
	            final ImageIcon successIcon = new ImageIcon("/Users/madisonscott/git/Fall2022Team20/old/MadisonScott/SuccessIcon.png");
	            JOptionPane.showMessageDialog(null, "Provider Directory has been sent!", "Sucess!",JOptionPane.INFORMATION_MESSAGE, successIcon);
	        }
	        else if (choice == 2){
	            System.out.println("startMenu()");
	            return;
	            //Terminal.startMenu();
	            // "Return to Operator Menu"
	        }
	        else if (choice == -1) {
	            System.out.println("Leaving");
	            Terminal.Quit();
	        }
    	}
    }
    
}