package chocAn;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The Member Updater Class allows an Operator to edit, delete, or add members.
 * in the Member Records
 *
 * @author Madison Scott
 *
 */
public class MemberUpdater {

    

  /**
  * Default Constructor.
  * 
  */
  public MemberUpdater() {

  }
    
  /**
  * Responsible for adding a member to member records.
  * 
  */
  public static void addMember() {
    int intValue;
    boolean isDigit = false;
    JFrame frame = new JFrame();
    frame.setPreferredSize(new Dimension(500, 250));
        
    //adds name
    String addName = JOptionPane.showInputDialog(frame, "Enter a name for the new Member: ", 
        "ChocAn", JOptionPane.QUESTION_MESSAGE);
    if (addName == null) {
      return;
    }
    //check
    while ((addName.length() > 25)) { 
      addName = JOptionPane.showInputDialog(frame, "Name must only be up to 25 characters. "
      + "Please enter another name.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (addName == null) {
    	  return;
      }
    }

    //add ID
    String addId = JOptionPane.showInputDialog(frame, "Enter an ID for the new Member: ",
        "ChocAn", JOptionPane.QUESTION_MESSAGE); 
    if (addId == null) {
  	  return;
    }
    try {
      intValue = Integer.parseInt(addId);
      isDigit = true;
    } catch (NumberFormatException e) {
      isDigit = false;
    }
    
    while ((addId.length() != 9) || (isDigit == false) || MemberRecords.memberExists(addId)) {
      addId = JOptionPane.showInputDialog(null, "ID must only be 9 digits and unused. "
        + "Please enter another Member ID.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (addId == null) {
    	  return;
      }
      try {
        intValue = Integer.parseInt(addId);
        isDigit = true;
      } catch (NumberFormatException e) {
        isDigit = false;
      }
    }

    //add address
    String address = JOptionPane.showInputDialog(frame, "Enter an address for the new Member: ", 
        "ChocAn", JOptionPane.QUESTION_MESSAGE);
    if (address == null) {
    	return;
    }
        
    while ((address.length() > 25)) { 
      address = JOptionPane.showInputDialog(frame, "Address must only be up to 25 digits. "
          + "Please enter another address.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (address == null) {
    	  return;
      }
    }

    //add city
    String city = JOptionPane.showInputDialog(frame, "Enter a city for the new Member: ",
        "ChocAn", JOptionPane.QUESTION_MESSAGE);
    if (city == null) {
    	return;
    }
        
    while ((city.length() > 14)) { 
      city = JOptionPane.showInputDialog(frame, "City must only be up to 14 digits. "
          + "Please enter another city.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (city == null) {
    	  return;
      }    
    }

    //add state
    String state = JOptionPane.showInputDialog(frame, "Enter a state for the new Member: ", 
        "ChocAn", JOptionPane.QUESTION_MESSAGE);
    if (state == null) {
    	return;
    }
        
    while (!(state.matches("^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]"
        + "|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$"))) { 
      state = JOptionPane.showInputDialog(frame, "State must only be up to 2 characters. "
          + "Please enter another state.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (state == null) {
    	  return;
      }
    }

    //add zip 
    String addZip = JOptionPane.showInputDialog(frame, "Enter a zip code for the new Member: ", 
        "ChocAn", JOptionPane.QUESTION_MESSAGE);
    if (addZip == null) {
    	return;
    }
        
    try {
      intValue = Integer.parseInt(addZip);
      isDigit = true;
    } catch (NumberFormatException e) {
      //System.out.println("Input String cannot be parsed to Integer.");
      isDigit = false;
    }
    
    while ((addZip.length() != 5) || (isDigit == false)) {
      addZip = JOptionPane.showInputDialog(null, "Zip code must only be 5 digits. "
          + "Please enter another zip code.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (addZip == null) {
    	  return;
      }
      try {
        intValue = Integer.parseInt(addZip);
        isDigit = true;
      } catch (NumberFormatException e) {
        //System.out.println("Input String cannot be parsed to Integer.");
        isDigit = false;
      }
    }
        
    Member z = new Member(addName, addId, address, city, state, addZip);
        

    JTextArea textArea = new JTextArea("New Member Info:\nName: " + addName + "\nNumber: " + addId 
            + "\nAddress: " + address + "\nCity: " + city + "\nState: " 
            + state + "\nZip Code: " + addZip);
    JScrollPane scrollPane = new JScrollPane(textArea);  
    textArea.setLineWrap(true);  
    textArea.setWrapStyleWord(true); 
    scrollPane.setPreferredSize(new Dimension(500, 250));
        
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add Member?",  
        "Confirm Addition", JOptionPane.YES_NO_OPTION);

    if (confirm == 0) {
      JOptionPane.showMessageDialog(null, scrollPane, "New Member Successfully Added!", 
          JOptionPane.INFORMATION_MESSAGE);
      MemberRecords.memberList.add(z);
      for (Member m : MemberRecords.memberList) {
        System.out.println(m.getName() + "\n" + m.getNumber() + "\n" + m.getAddress() + "\n" 
            + m.getCity() + "\n" + m.getState() + "\n" + m.getZip());
      }
    }
  }

  /**
  * Responsible for editing an existing member's information.
  * 
  */
  public static void editMember() {
    int intValue;
    boolean isDigit = false;
    
    //Find member based on number
    String editId = JOptionPane.showInputDialog(null, "Enter the ID for the Member you want to "
        + "edit: ", "ChocAn", JOptionPane.QUESTION_MESSAGE); 
    
    if (editId == null) {
  	  return;
    }
    try {
      intValue = Integer.parseInt(editId);
      isDigit = true;
    } catch (NumberFormatException e) {
      isDigit = false;
    }
    
    while ((editId.length() != 9) || (isDigit == false) || !(MemberRecords.memberExists(editId))) {
      editId = JOptionPane.showInputDialog(null, "ID must only be 9 digits and unused. "
          + "Please enter another Member ID.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (editId == null) {
    	  return;
      }
      try {
        intValue = Integer.parseInt(editId);
        isDigit = true;
      } catch (NumberFormatException e) {
        isDigit = false;
      }
    }
    
    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("old/MadisonScott/Edit.png");
    frame = null;
    Object[] possibilities = {"Name", "Member ID", "Address", "City", "State", "Zip"};
    String editOption = (String) JOptionPane.showInputDialog(frame, "Choose aspect to "
        + "edit:\n", "Edit Member", JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Name");
    
    if (editOption == null) {
    	return;
    }
    else if (editOption.equals("Name")) {
      String newName = JOptionPane.showInputDialog(null, "Enter a new name for the Member: ", 
          "ChocAn", JOptionPane.QUESTION_MESSAGE);
      if (newName == null) {
        return;
      }
      //check length
      while ((newName.length() > 25)) { 
        newName = JOptionPane.showInputDialog(null, "Name must only be up to 25 characters. "
            + "Please enter another name.", "ChocAn", JOptionPane.ERROR_MESSAGE);
        if (newName == null) {
        	return;
        }  
      }
        
      int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit name?", 
          "Confirm Edit", JOptionPane.YES_NO_OPTION);

      if (confirm == 0) {
        for (Member m : MemberRecords.memberList) {
          if (m.getNumber().equals(editId)) {
            m.setName(newName);
          }
        }
        JOptionPane.showMessageDialog(null, "Name has been changed to " 
            + newName + "!");
      }
      
    } else if (editOption.equals("Member ID")) {
      String newId = JOptionPane.showInputDialog(null, "Enter a new ID for the Member: ", 
          "ChocAn", JOptionPane.QUESTION_MESSAGE);
      
      if (newId == null) {
      	return;
      }
      try {
        intValue = Integer.parseInt(newId);
        isDigit = true;
      } catch (NumberFormatException e) {
        isDigit = false;
      }
    
      while ((newId.length() != 9) || (isDigit == false) || MemberRecords.memberExists(newId)) {
        newId = JOptionPane.showInputDialog(null, "ID must only be 9 digits and unused. "
            + "Please enter another Member ID.", "ChocAn", JOptionPane.ERROR_MESSAGE);
        if (newId == null) {
        	return;
        }
        try {
          intValue = Integer.parseInt(newId);
          isDigit = true;
        } catch (NumberFormatException e) {
          isDigit = false;
        }
      }

      int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit Member ID?", 
          "Confirm Edit", JOptionPane.YES_NO_OPTION);

      if (confirm == 0) {
        for (Member m : MemberRecords.memberList) {
          if (m.getNumber().equals(editId)) {
            m.setNumber(newId);
          }
        }
        JOptionPane.showMessageDialog(null, "Member ID has been changed to " + newId + "!");
      }
      
    } else if (editOption.equals("Address")) {
      //System.out.println("Address");
      String newAddress = JOptionPane.showInputDialog(null, "Enter a new address for the "
            + "Member: ", "ChocAn", JOptionPane.QUESTION_MESSAGE);
      if (newAddress == null) {
    	  return;
      }
      //check length
      while ((newAddress.length() > 25)) { 
        newAddress = JOptionPane.showInputDialog(null, "Address must only be up to 25 characters. "
            + "Please enter another address.", "ChocAn", JOptionPane.ERROR_MESSAGE);
        if (newAddress == null) { 
        	return;
        }
      }
        
      int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit address?", 
          "Confirm Edit", JOptionPane.YES_NO_OPTION);

      if (confirm == 0) {
        for (Member m : MemberRecords.memberList) {
          if (m.getNumber().equals(editId)) {
            m.setAddress(newAddress);
          }
        }
        JOptionPane.showMessageDialog(null, "Address has been changed to " + newAddress + "!");
      }

    } else if (editOption.equals("City")) {
      String newCity = JOptionPane.showInputDialog(null, "Enter a new city for the Member: ",
            "ChocAn", JOptionPane.QUESTION_MESSAGE);
      if (newCity == null) {
    	  return;
      }
      //check length
      while ((newCity.length() > 14)) { 
        newCity = JOptionPane.showInputDialog(null, "City must only be up to 25 characters. "
            + "Please enter another city.", "ChocAn", JOptionPane.ERROR_MESSAGE);
        if (newCity == null) {
        	return;
        }
      }
        
      int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit "
          + "city?", "Confirm Edit", JOptionPane.YES_NO_OPTION);

      if (confirm == 0) {
        for (Member m : MemberRecords.memberList) {
          if (m.getNumber().equals(editId)) {
            m.setCity(newCity);
          }
        }
        JOptionPane.showMessageDialog(null, "City has been changed to " + newCity + "!");
      }
        
    } else if (editOption.equals("State")) {
      String newState = JOptionPane.showInputDialog(null, "Enter a new state "
          + "for the Member: ", "ChocAn", JOptionPane.QUESTION_MESSAGE);
      if (newState == null) {
    	  return;
      }
      //check length
      while (!(newState.matches("^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|"
          + "M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$"))) { 
        newState = JOptionPane.showInputDialog(null, "State must only be up to 2 characters. "
            + "Please enter another state.", "ChocAn", JOptionPane.ERROR_MESSAGE);
        if (newState == null) {
        	return;
        }
      }
        
      int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit state?", 
          "Confirm Edit", JOptionPane.YES_NO_OPTION);

      if (confirm == 0) {
        for (Member m : MemberRecords.memberList) {
          if (m.getNumber().equals(editId)) {
            m.setState(newState);
          }
        }
        JOptionPane.showMessageDialog(null, "State has been changed to " + newState + "!");
      }

    } else if (editOption.equals("Zip")) {
      String newZip = JOptionPane.showInputDialog(null, "Enter a new zip code for the Member: ", 
          "ChocAn", JOptionPane.QUESTION_MESSAGE);
      
      if (newZip == null) {
      	return;
      }
      try {
        intValue = Integer.parseInt(newZip);
        isDigit = true;
      } catch (NumberFormatException e) {
        isDigit = false;
      }
   
      while ((newZip.length() != 5) || (isDigit == false)) {
        newZip = JOptionPane.showInputDialog(null, "Zip Code must only be 5 digits. "
           + "Please enter another zip code.", "ChocAn", JOptionPane.ERROR_MESSAGE);
        if (newZip == null) {
        	return;
        }
        try {
          intValue = Integer.parseInt(newZip);
          isDigit = true;
        } catch (NumberFormatException e) {
          isDigit = false;
        }
      }

      int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit zip code?", 
          "Confirm Edit", JOptionPane.YES_NO_OPTION);

      if (confirm == 0) {
        for (Member m : MemberRecords.memberList) {
          if (m.getNumber().equals(editId)) {
            m.setZip(newZip);
          }
        }
        JOptionPane.showMessageDialog(null, "Zip Code has been changed to " + newZip + "!");
      }
    }
  }

  /**
  * Responsible for deleting an existing member from member records.
  * 
  */
  public static void deleteMember() {
    String deleteId = JOptionPane.showInputDialog(null, "Enter the ID for the Member you want to "
        + "delete: ", "ChocAn", JOptionPane.QUESTION_MESSAGE);
    int intValue;
    boolean isDigit = false;
    
    if (deleteId == null) {
  	  return;
    }
    try {
      intValue = Integer.parseInt(deleteId);
      isDigit = true;
    } catch (NumberFormatException e) {
      isDigit = false;
    }
    
    while ((deleteId.length() != 9) || (isDigit == false) 
       || (!(MemberRecords.memberExists(deleteId)))) {
      deleteId = JOptionPane.showInputDialog(null, "ID must only be 9 digits and unused. "
          + "Please enter another Member ID.", "ChocAn", JOptionPane.ERROR_MESSAGE);
      if (deleteId == null) {
    	  return;
      }
      try {
        intValue = Integer.parseInt(deleteId);
        isDigit = true;
      } catch (NumberFormatException e) {
        isDigit = false;
      }
    }

    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Member?", 
        "Confirm Deletion", JOptionPane.YES_NO_OPTION);

    if (confirm == 0) {
      for (Member m : MemberRecords.memberList) {
        if (m.getNumber().equals(deleteId)) {
        	JOptionPane.showMessageDialog(null, "Member " + m.getName() + " Is Successfully Deleted!");
          MemberRecords.memberList.remove(m);
          break;
        }
      }
    }
  }
    
}
