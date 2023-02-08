package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
*
* terminal class
*
* @author Anthony Minatel
*
*/

import javax.swing.JOptionPane;

public class OperatorTerminal extends Terminal{

    public static String operatorCode = "2222";

    public OperatorTerminal(){

    }


    public static void verifyOperator(){
    	final ImageIcon oIcon = new ImageIcon("old/MadisonScott/User.png");
        String inputCode = (String) JOptionPane.showInputDialog(null, "Enter the code for Operator: ", "ChocAn", JOptionPane.QUESTION_MESSAGE, oIcon, null, null);
        
        if (inputCode == null) return;
        
        while(inputCode.equals(operatorCode) == false){
            inputCode = JOptionPane.showInputDialog(null,"Operator Code is incorrect. Please try again.", "ChocAn", JOptionPane.ERROR_MESSAGE);
                if (inputCode == null) return;
        }

        operatorMenu();
    
    }

    public static void operatorMenu(){
    	
    	while (true) {
	    	JFrame frame = new JFrame();
	    	final ImageIcon icon = new ImageIcon("old/MadisonScott/OperatorMenu.png");
	        frame = null;
	        Object[] possibilities = {"Add Provider", "Delete Provider", "Edit a Current Provider's Information", "Add Member", "Delete Member", "Edit a Current Member's Information", "Return to Main Menu"};
	        String menuOption = (String) JOptionPane.showInputDialog(frame, "Choose aspect to "
	            + "change:\n", "Operator Menu", JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Add Provider");
	        
	        if (menuOption == null) return;
	        // "Add another Member"
	        else if (menuOption.equals("Add Provider")) {
	            System.out.println("addProvider()");
	            ProviderUpdater.addProvider();
	        }
	        else if (menuOption.equals("Delete Provider")) {
	            System.out.println("deleteProvider()");  
	            ProviderUpdater.deleteProvider();
	        }
	        else if (menuOption.equals("Edit a Current Provider's Information")){
	            System.out.println("editProvider()");
	            ProviderUpdater.editProvider();
	        }
	        else if (menuOption.equals("Add Member")){
	            System.out.println("addMember()");
	            MemberUpdater.addMember();
	            // "Remove Member"
	        }
	        else if (menuOption.equals("Delete Member")){
	            System.out.println("deleteMember()");
	            MemberUpdater.deleteMember();  
	            // "Update Member"
	        }
	        else if (menuOption.equals("Edit a Current Member's Information")){
	            System.out.println("editMember()");
	            MemberUpdater.editMember();
	            // "Return to Operator Menu"
	        }
	        else if (menuOption.equals("Return to Main Menu")) {
	            System.out.println("mainMenu()");
	            return;
	            // if exit is pressed
	        }
	        else {
	            Terminal.Quit();
	        }
    	}
        
    }
    
}
