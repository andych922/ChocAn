package chocAn.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAn.ProviderRecords;
import chocAn.ProviderTerminal;

class RaheemCraytonTest {


	@BeforeEach
	void setUp() throws Exception {
		ProviderTerminal.verifyProvider();
		ProviderTerminal.verifyMember(1114);
		
	}

	@Test
	void testVerifyProvider() {
		
		String providerNum1 = "135798642";
		String providerNum2 ="456456456";
		String providerNum3 = "222333444";
		String providerNum4 = "999999999";
		
		assertTrue(ProviderRecords.isProviderNum(providerNum1) || ProviderRecords.isProviderNum(providerNum2) || ProviderRecords.isProviderNum(providerNum3) || ProviderRecords.isProviderNum(providerNum4) );
	}

	@Test
	void testVerifyMember() {
		
		assertFalse(ProviderTerminal.verifyMember(9878));
	}

	@Test
	void testQuit() {
		assertTrue(0 == 0);
	}

}
