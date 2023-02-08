package chocAn.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import chocAn.MemberRecords;
import chocAn.MemberUpdater;
import chocAn.ProviderRecords;

//Checks Add Member, Delete Member, and IsProviderName
public class MadisonScottTest {
	
	@BeforeAll
	public static void setUp() throws Exception {
		//Adding member "Madison Scott", "000000000", "123 Street Rd.", "Townsburg", "OH", "54321" through method addMember
		//Deleting member with member number 123456789
		//Checking if provider exists with name "Joe Mascon" or "Madison Scott"
		MemberUpdater.addMember();
		MemberUpdater.deleteMember();
		
	}
	
	
	
	@Test
	public void testAddMemberforSanity() {
		assertTrue(MemberRecords.getMembers().stream().anyMatch(item -> "000000000".equals(item.getNumber()) && "Madison Scott".equals(item.getName())));
		
	}
	
	@Test
	public void testDeleteMemberforSanity() {

		assertFalse(MemberRecords.getMembers().stream().anyMatch(item -> "123456789".equals(item.getNumber())));
		
	}
	
	@Test
	public void testIsProviderName() {
	
		String providerTestName1 = "Joe Macson";
		String providerTestName2 = "Madison Scott";
		assertTrue(ProviderRecords.isProviderName(providerTestName1));
		assertFalse(ProviderRecords.isProviderName(providerTestName2));
	}
	
	
	
}
