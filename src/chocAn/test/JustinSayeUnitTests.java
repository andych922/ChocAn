package chocAn.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import chocAn.MemberRecords;
import chocAn.Service;

public class JustinSayeUnitTests {
	
	@Test
	public void testMemberExists() {        
        assertTrue(MemberRecords.memberExists("123456789"));
        assertTrue(MemberRecords.memberExists("345434543"));
        
        assertFalse(MemberRecords.memberExists("000000000"));
        assertFalse(MemberRecords.memberExists(""));
        assertFalse(MemberRecords.memberExists("123456789 "));
        assertFalse(MemberRecords.memberExists(" 345434543"));
        assertFalse(MemberRecords.memberExists("34543454"));
	}
	
	@Test
	public void testGetDateVal() {		
		Service ser1 = new Service("","12-31-2021","12-31-2021 13:48:02","","","","");
		Service ser2 = new Service("","01-01-2022","01-10-2022 01:05:31","","","","");
		Service ser3 = new Service("","12-31-2021","12-31-2021 13:47:40","","","","");
		Service ser4 = new Service("","06-13-2022","05-23-1974 12:54:09","","","","");
		Service ser5 = new Service("","07-14-0022","05-23-1974 12:54:09","","","","");

		assertTrue(ser1.getDateVal() <  ser2.getDateVal());
		assertTrue(ser1.getDateVal() == ser3.getDateVal());
		assertTrue(ser4.getDateVal() >  ser5.getDateVal());
		assertTrue(ser3.getDateVal() <  ser4.getDateVal());
		assertTrue(ser1.getDateVal() >  ser5.getDateVal());
	}
	
	@Test
	public void testGetTimeVal() {		
		Service ser1 = new Service("","12-31-2021","12-31-2021 13:48:02","","","","");
		Service ser2 = new Service("","01-01-2022","01-10-2022 01:05:31","","","","");
		Service ser3 = new Service("","12-31-2021","12-31-2021 13:47:40","","","","");
		Service ser4 = new Service("","06-13-2022","05-23-1974 12:54:09","","","","");
		Service ser5 = new Service("","07-14-0022","05-23-1974 12:54:09","","","","");

		assertTrue(ser1.getTimeVal() <  ser2.getTimeVal());
		assertTrue(ser1.getTimeVal() >  ser3.getTimeVal());
		assertTrue(ser4.getTimeVal() == ser5.getTimeVal());
		assertTrue(ser3.getTimeVal() >  ser4.getTimeVal());
		assertTrue(ser1.getTimeVal() >  ser5.getTimeVal());
	}
	
}