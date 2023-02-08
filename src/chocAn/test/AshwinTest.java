package chocAn.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAn.Member;
import chocAn.MemberRecords;
class AshwinTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetMemberNameInt() {
		String memberTestName1 = "John Do";
		String memberTestName2 = "Ashwin Suryaram";
		assertTrue(MemberRecords.getMemberName(0).equals(memberTestName1));
		assertFalse(MemberRecords.getMemberName(0).equals(memberTestName2));
	}
	
	@Test
	void testIsMemberName() {
		String memberTestName1 = "John Do";
		String memberTestName2 = "Ashwin Suryaram";
		assertTrue(MemberRecords.isMemberName(memberTestName1));
		assertFalse(MemberRecords.isMemberName(memberTestName2));
	}
	
	@Test
	void testGetAddress() {
		Member tempMember = new Member("name", "number", "address", "city", "state", "zip");
		assertTrue(tempMember.getAddress().equals("address"));
		assertFalse(tempMember.getAddress().equals("name"));
	}

}
