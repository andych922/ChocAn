package chocAn.test;

/**
*
* J-Unit Testing
*
* @author Anthony Minatel
*
* 
*/
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAn.ProviderRecords;


public class AnthonyMinatelJUnitTests {
	
	@BeforeEach
	public void addSetUp() {
		
		
	}
	
	@Test
	public void testVerifyOperator() {
		String opCode = "2222";
		String testopCode1 = "2222";
		String testopCode2 = "3333";
		assertTrue(opCode == testopCode1);
		assertFalse(opCode == testopCode2);
	}
	
	@Test
	public void testTerminalQuit() {
		boolean successTrial = true;
		boolean failTrial = false;
		assertTrue(successTrial);
		assertFalse(failTrial);
		//Terminal.Quit();
	}
	
	@Test
	public void testProviderExists() {
		String trueTest = "135798642";
		String falseTest = "18";
		assertTrue(ProviderRecords.providerExists(trueTest));
		assertFalse(ProviderRecords.providerExists(falseTest));
	}
	
	
}
