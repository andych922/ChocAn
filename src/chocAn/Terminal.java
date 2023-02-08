package chocAn;



import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.sun.tools.javac.Main;

/**
*
* Main Terminal
*
* @author Anthony Minatel
*
*/
public class Terminal {
	
	
    
	/*
	 * default constructor
	 */
    public Terminal(){

    }
    /*
     * write data to file
     */
    private static void writeToFile(String type, String str) {
    	try {
    		FileWriter writer = new FileWriter("src/chocAn/dataFiles/"+type+"s.txt");
    		writer.write(str.substring(0,Math.max(str.length()-1, 0)));
    		writer.close();
	    } 
		catch (Exception e) {
	    	System.out.println("ERROR: Failed to save "+type+" data.");
		}
    }
    /*
     * Exit system and print exit message
     */
    public static void Quit() {
    	String S;
    	
    	S = "";
    	for (Member mem : MemberRecords.getMembers()) {
    		S = S+mem.toString()+"\n";
    	}
    	writeToFile("member", S);
    	
    	S = "";
    	for (Provider pro : ProviderRecords.getProviders()) {
    		S = S+pro.toString()+"\n";
    	}
    	writeToFile("provider", S);
    	
    	S = "";
    	for (Service ser : ServiceRecords.getServices()) {
    		S = S+ser.toString()+"\n";
    	}
    	writeToFile("service", S);
    	
    	System.exit(0);
    }
    /*
     * Primary menu to select user type
     */
    public static void startMenu(){
       //ProviderTerminal pAccess = new ProviderTerminal();
//        OperatorTerminal oAccess = new OperatorTerminal();
//        ManagerTerminal mAccess = new ManagerTerminal();
    	final ImageIcon icon = new ImageIcon("res/ChocolatePicture.png");
    	  

    	
    	while (true) {
	        Object [] options = {"Provider", "Operator", "Manager", "Run Main Accounting Procedure"};
	        int choice = JOptionPane.showOptionDialog(null, "Welcome to Chocoholics Anonymous!" + "\n" + "Select a User or Run Main Accounting Procedure.", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
	        
	        
	        if (choice == 0){
	            //Send to Provider Verification
	            System.out.println("providerTerminal()");
	            ProviderTerminal.verifyProvider();
	            
	        }
	        else if (choice == 1){
	            System.out.println("operatorTerminal()");  
	            OperatorTerminal.verifyOperator();
	            // "Update Member"
	        }
	        else if (choice == 2){
	            System.out.println("managerTerminal()");
	            ManagerTerminal.verifyManager();
	            // "Return to Operator Menu"
	        }
	        else if (choice == 3){
	            System.out.println("RunMainAccountingProcedure()");
	            final ImageIcon successIcon = new ImageIcon("old/MadisonScott/SuccessIcon.png");
	            JOptionPane.showMessageDialog(null, "Main Accounting Procedure was successful and files have been sent!", "Sucess!",JOptionPane.INFORMATION_MESSAGE, successIcon);
	            ReportGenerator.runMainAccountingProcedure();
	            
	            // "Return to Operator Menu"
	        }
	        else if (choice == -1) {
	            System.out.println("Leaving");
	            Quit();
	        }
    	}
        
    }
 
    /*
     * System start-up and start up message  
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Starting Program!");
//        Date dNow = new Date();
        //Service S = new Service("Therapy", dNow, "Meeting", "Family", "99999");
//        System.out.println(S.getServiceDate());
        //Terminal t = new Terminal();
        Terminal.startMenu();

        // MemberRecords mems = new MemberRecords();
        // Member b = new Member("Sasquatch", null, null, null, null, null);
        // mems.memberList.add(b);


    }
}

