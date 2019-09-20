/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.pageobjects.BankingAppMenu;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppMenuTestScript {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppMenuWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppMenu bankingAppMenu;
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;
	// ==========================================================================

	public BankingAppMenuTestScript(TestSuiteDetails suiteDetails) {
		this.suiteDetails= suiteDetails;
		testCaseDetails = new TestCaseDetails();
		testCaseDetails.setTestSuiteDetailsId(suiteDetails.getTestSuiteDetailsId());
		System.out.println(testCaseDetails.getTestCaseDetailsId());
	}

	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		log.info("END of the method beforeTest");
	}

	// ==========================================================================

	private void setPrerequisites() throws InterruptedException {
		testCaseDetails.setTestCaseName(BankingAppMenuTestScript.class.getSimpleName());
		if (bankingAppMenuWebElementList == null) {
			bankingAppMenuWebElementList = JXMLParser.getInstance().getWebElements(BankingAppMenu.class.getSimpleName());
		}
}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void chkBankingAppMenu() {
		log.info("START of the method addNewbankingAppMenuRecord");
		bankingAppMenu = new BankingAppMenu();
		String customMessage = null;
		WebDriver driver = null;
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerequisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");

			if (bankingAppMenuWebElementList != null && bankingAppMenuWebElementList.size() > 0) {
								try {
									while (!driver.getCurrentUrl().contains("user")) {
											Thread.sleep(1000);
									}
									Thread.sleep(3000);
									customMessage = "Click on User Menu Item";
									WebElementDetails userMenuBtnobj = bankingAppMenuWebElementList.get(0);
									bankingAppMenu.userMenu(userMenuBtnobj).click();
									log.info(" User Menu");
									Thread.sleep(3000);
									customMessage = "Click on Customer Menu Item";
									WebElementDetails customerMenuBtnobj = bankingAppMenuWebElementList.get(1);
									bankingAppMenu.customerMenu(customerMenuBtnobj).click();
									log.info(" Customer Menu");
									Thread.sleep(3000);
									customMessage = "Click on Account Menu Item";
									WebElementDetails accountMenuBtnobj = bankingAppMenuWebElementList.get(2);
									bankingAppMenu.accountMenu(accountMenuBtnobj).click();
									log.info(" Account Menu");
									Thread.sleep(3000);
									customMessage = "Click on Balance Enquiry Menu Item";
									WebElementDetails balanceEnquiryMenuBtnobj = bankingAppMenuWebElementList.get(3);
									log.info(" Balance Enquiry");
									bankingAppMenu.balanceEnquiry(balanceEnquiryMenuBtnobj).click();
									Thread.sleep(3000);
									customMessage = "Click on Deposit Menu Item";
									WebElementDetails depositMenuBtnobj = bankingAppMenuWebElementList.get(4);
									bankingAppMenu.depositMenu(depositMenuBtnobj).click();
									log.info(" Deposit Menu");
									Thread.sleep(3000);
									customMessage = "Click on Locker Operations Menu Item";
									WebElementDetails lockerMenuBtnobj = bankingAppMenuWebElementList.get(5);
									bankingAppMenu.lockerMenu(lockerMenuBtnobj).click();
									log.info(" Locker Operations");
									Thread.sleep(3000);
									customMessage = "Click on WithDraw Menu Item";
									WebElementDetails withDrawMenuBtnobj = bankingAppMenuWebElementList.get(6);
									bankingAppMenu.withDrawMenu(withDrawMenuBtnobj).click();
									log.info(" Withdraw ");
									Thread.sleep(3000);
									customMessage = "Click on Change Password  Menu Item";
									WebElementDetails changePasswordMenuBtnobj = bankingAppMenuWebElementList.get(7);
									bankingAppMenu.changePasswordMenu(changePasswordMenuBtnobj).click();
									log.info(" Change Password ");
								} catch (java.lang.AssertionError e) {
								} catch (Exception e) {
									suiteDetails.setTestStatusSuccess(false);
									testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
								} finally {
									System.out.println("TEST CAME Thru");
									TAFDBManagerHelper.getInstance().saveTestCaseDetails(testCaseDetails);
								}
							} 

		} catch (Exception e) {
			suiteDetails.setTestStatusSuccess(false);
			testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
		}
	}

	// ==========================================================================

	@AfterTest
	public void afterTest() {
		log.info("START of the method afterTest");
		log.info("END of the method afterTest");
	}

	
	// ==========================================================================

	public String handleNavigationPageState() {
		
		String customMessage = "PASS";
		
				
		return customMessage;
		
	}

	// ==========================================================================

}
