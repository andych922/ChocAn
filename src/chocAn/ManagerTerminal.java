package chocAn;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ManagerTerminal extends Terminal{

    public static String managerCode = "3333";

    public ManagerTerminal(){

    }


    public static void verifyManager(){
    	final ImageIcon mIcon = new ImageIcon("old/MadisonScott/User.png");
        String inputCode = (String) JOptionPane.showInputDialog(null, "Enter the code for Manager: ", "Manager Verification", JOptionPane.QUESTION_MESSAGE, mIcon, null, null);
        //String inputCode = JOptionPane.showInputDialog(null, "Enter the code for Manager: ", "ChocAn", JOptionPane.QUESTION_MESSAGE);
        
        if (inputCode == null) return;
        
        while(inputCode.equals(managerCode) == false){
            inputCode = JOptionPane.showInputDialog(null,"Manager Code is incorrect. Please try again.", "ChocAn", JOptionPane.ERROR_MESSAGE);
                if (inputCode == null) return;
        }

        managerMenu();
    
    }

    public static void managerMenu(){
    	
    	while (true) {
    		final ImageIcon icon = new ImageIcon("old/MadisonScott/ManagerMenu.png");
	        Object [] options = {"Print EFT Report", "Print Summary Report", "Print Member Reports", "Print Provider Reports", "Return to Main Menu"};
	        int choice = JOptionPane.showOptionDialog(null, "Choose an Option", "Manager Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
	        
	        if (choice == 0) {
	        	System.out.println("printEFT()");
	        	final ImageIcon successIcon = new ImageIcon("old/MadisonScott/SuccessIcon.png");
	        	System.out.println(ReportGenerator.createEFTReport());
	            JOptionPane.showMessageDialog(null, "EFT Report successfully generated!", "Sucess!",JOptionPane.INFORMATION_MESSAGE, successIcon);
	        }

	        else if (choice == 1){
	            System.out.println("printSummaryReport()");  
	        	final ImageIcon successIcon = new ImageIcon("old/MadisonScott/SuccessIcon.png");
	        	System.out.println(ReportGenerator.createSummaryReport());
	            JOptionPane.showMessageDialog(null, "Summary Report successfully generated!", "Sucess!",JOptionPane.INFORMATION_MESSAGE, successIcon);
	        }

	        else if (choice == 2){
	            System.out.println("printMemberReports()");
	            final ImageIcon successIcon = new ImageIcon("old/MadisonScott/SuccessIcon.png");
	            System.out.println(ReportGenerator.createMemberReports());
	            JOptionPane.showMessageDialog(null, "Member Reports successfully generated!", "Sucess!",JOptionPane.INFORMATION_MESSAGE, successIcon);
	        }

	        else if (choice == 3){
	            System.out.println("printProviderReports()");
	            final ImageIcon successIcon = new ImageIcon("old/MadisonScott/SuccessIcon.png");
	            System.out.println(ReportGenerator.createProviderReports());
	            JOptionPane.showMessageDialog(null, "Provider Reports successfully generated!", "Sucess!",JOptionPane.INFORMATION_MESSAGE, successIcon);
	        }

	        else if (choice == 4) {
	            System.out.println("mainMenu()");
	            return;
	            // if exit is pressed
	        }

	        else if (choice == -1) {
	            Terminal.Quit();
	        }
    	}
        
    }
    
}

