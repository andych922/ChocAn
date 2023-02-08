package chocAn;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Member Records Class holds information about members and returns member names, and checks if a name is a member.
 *
 * @author Ashwin Suryaram
 *
 */
public class MemberRecords {
	public static ArrayList<Member> memberList = new ArrayList<Member>();

	static {
		File file = new File("src/chocAn/dataFiles/members.txt");
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
				memberList.add(new Member(entries[0], entries[1], entries[2], entries[3], entries[4], entries[5]));
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR: Member file not found.");
		}
	}

	/*
	 * Default constructor
	 */
	public MemberRecords() {
		
	}

	
	/*
	 * Returns provider list
	 */
	public static ArrayList<Member> getMembers() {
		return memberList;
	}

	public static Member getMember(String code) {
		for(Member mem : memberList) {
			if(code.equals(mem.getNumber())) return mem;
		}
		return null;
	}
	
	public static String getMemberName(int pos) {
		return memberList.get(pos).getName();
	}

	public static String getMemberName(String code) {
		for(int i = 0; i < memberList.size(); i++) {
			if(code.equals(memberList.get(i).getNumber())) {
				return memberList.get(i).getName();
			}
		}
		return "";
	}
	
	public static boolean isMemberName(String nameToSearch) {
		for(int i = 0; i < memberList.size(); i++) {
			if(nameToSearch.equals(memberList.get(i).getName())) {
				return true;
			}
		}
		return false;
	}
	public static boolean memberExists(String numToSearch) {
		for (Member m : memberList) {
            if( m.getNumber().equals(numToSearch)){
                return true;
            }
        }
        return false;
	}
	
	
	
	
}