package chocAn.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import chocAn.Member;
import chocAn.MemberRecords;
import chocAn.ServiceRecords;

public class AndrewHahnJUNIT {
	
	@BeforeAll
	public static void addSetUp() throws Exception {
      //Member tempMember = new Member("name", "number", "address", "city", "state", "zip");
	}
	
	@Test
	public void testAddMemberforSuccess() {
	  Member tempMember = new Member("name", "number", "address", "city", "state", "zip");
      assertTrue(tempMember.toString().equals("name~number~address~city~state~zip~"));
	}
	
	@Test
	public void testServiceExistsForFailure() {
		assertFalse(ServiceRecords.serviceExists("nonexistant"));
	}
	
	@Test
	public void testGetMemberForFailure() {
		assertNull(MemberRecords.getMember("nonexistant"));
	}
	
}
