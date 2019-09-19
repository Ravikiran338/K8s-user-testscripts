/**
 * @author Jp
 *
 */
package com.radiant.microservices.testsuites;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.reports.ReportsManager;
import com.radiant.microservices.testscripts.BankingAppMenuTestScript;
import com.radiant.microservices.testscripts.BankingAppAddUserTestScript;
import com.radiant.microservices.testscripts.BankingAppDeleteUserTestScript;
import com.radiant.microservices.testscripts.BankingAppModifyUserTestScript;
import com.radiant.microservices.testscripts.LoginTestScript;
import com.radiant.microservices.testscripts.LogoutTestScript;

public class TNCTest {
	protected transient final Log log = LogFactory.getLog(getClass());
	private TestSuiteDetails testSuiteDetails = null;

	
	// ==========================================================================
	@Test
	public void tncTestSuite() {
		log.info("START of the method tncTestSuite");
		long testSuiteDetailsId = 0;
		
		LoginTestScript loginTestScript = null;
		BankingAppMenuTestScript bankingAppMenuTestScript = null;
		BankingAppAddUserTestScript bankingAppAddUserTestScript = null;
		BankingAppModifyUserTestScript bankingAppModifyUserTestScript = null;
		BankingAppDeleteUserTestScript bankingAppDeleteUserTestScript = null;
		LogoutTestScript logoutTestScript = null;

		try {
			// Adding test Suite details and getting test suite ID
			testSuiteDetails = TAFDBManagerHelper.getInstance().saveTestSuiteDetails(getClass().getSimpleName());

			if (testSuiteDetails != null && testSuiteDetails.getTestSuiteDetailsId() > 0) {
				testSuiteDetailsId = testSuiteDetails.getTestSuiteDetailsId();

			  // Executing the Test script for Login
				 loginTestScript = new LoginTestScript(testSuiteDetailsId);
				 loginTestScript.login();
				  
			  /*// Executing the Test script for Banking Menu App
			     bankingAppAddUserTestScript = new BankingAppAddUserTestScript(testSuiteDetailsId);
			     bankingAppAddUserTestScript.addBankingUser();
			     
			  // Executing the Test script for Banking Modify User Test Script
			     bankingAppModifyUserTestScript = new BankingAppModifyUserTestScript(testSuiteDetailsId);
			     bankingAppModifyUserTestScript.modifyBankingUser();
				
			  // Executing the Test script for Banking Delete User Test Script	
			     bankingAppDeleteUserTestScript = new BankingAppDeleteUserTestScript(testSuiteDetailsId);
			     bankingAppDeleteUserTestScript.deleteBankingUser();
				
			  // Executing the Test script for Banking Menu App
			     bankingAppMenuTestScript = new BankingAppMenuTestScript(testSuiteDetailsId);
			     bankingAppMenuTestScript.chkBankingAppMenu();
			    
			  // Executing the Test script for Logout
				 logoutTestScript = new LogoutTestScript(testSuiteDetailsId);
				 logoutTestScript.logout();*/
				
			} 
		} catch (Exception e) {
			log.error("PROBLEM in the method tncTestSuite");
		}
		log.info("END of the method tncTestSuite");
	}

	// ==========================================================================

	@AfterTest
	public void sendReport() {
		ReportsManager.getInstance().sendTestReport(testSuiteDetails);
	}
	
	// ==========================================================================
}