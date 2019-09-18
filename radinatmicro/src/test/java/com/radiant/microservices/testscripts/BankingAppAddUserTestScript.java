/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.common.Constants;
import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.pageobjects.BankingAppUser;
import com.radiant.microservices.pageobjects.Login;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JExcelParser;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppAddUserTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppAddUserWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppUser bankingAppAddUser;
	AppUtil apt = new AppUtil();

	// ==========================================================================

	public BankingAppAddUserTestScript(long testSuiteDetailsId) {
		testCaseDetails = new TestCaseDetails();
		testCaseDetails.setTestSuiteDetailsId(testSuiteDetailsId);
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
		testCaseDetails.setTestCaseName(BankingAppAddUserTestScript.class.getSimpleName());
		if (bankingAppAddUserWebElementList == null) {
			bankingAppAddUserWebElementList = JXMLParser.getInstance().getWebElements(BankingAppUser.class.getSimpleName());
		}
		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppUser.class.getSimpleName(), BankingAppAddUserTestScript.class.getSimpleName());
		   }
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void addBankingUser() {
		log.info("START of the method addNewbankingAppAddUserRecord");
		bankingAppAddUser = new BankingAppUser();
		String customMessage = null;
		WebDriver driver = null;
		
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerequisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
			driver.get(resourceBundle.getString("application.url"));
			customMessage = "Click on Add button";
			WebElementDetails userMenuobj = bankingAppAddUserWebElementList.get(14);
			bankingAppAddUser.userMenu(userMenuobj).click();
			Thread.sleep(6000);
			
			if (bankingAppAddUserWebElementList != null && bankingAppAddUserWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									
									customMessage = "Click on Add button";
									WebElementDetails addBtnobj = bankingAppAddUserWebElementList.get(0);
									bankingAppAddUser.addUserbtn(addBtnobj).click();
									Thread.sleep(10000);
									
									customMessage = "Enter First Name";
									WebElementDetails firstNameTxtobj = bankingAppAddUserWebElementList.get(1);
									bankingAppAddUser.firstNameTxtbox(firstNameTxtobj).click();
									bankingAppAddUser.firstNameTxtbox(firstNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(0));
									log.info(" Enter First Name");
									Thread.sleep(1000);
									customMessage = "Enter Last Name";
									WebElementDetails lastNameTxtobj = bankingAppAddUserWebElementList.get(2);
									bankingAppAddUser.lastNameTxtbox(lastNameTxtobj).click();
									bankingAppAddUser.lastNameTxtbox(lastNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(1));
									log.info(" Last Name");
									Thread.sleep(1000);
									customMessage = "Enter Middle Name";
									WebElementDetails middleNameTxtobj = bankingAppAddUserWebElementList.get(3);
									bankingAppAddUser.middleNameTxtbox(middleNameTxtobj).click();
									bankingAppAddUser.middleNameTxtbox(middleNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(2));
									log.info(" Enter Middle Name");
									Thread.sleep(1000);
									customMessage = "Enter User Name";
									WebElementDetails userNameobj = bankingAppAddUserWebElementList.get(4);
									bankingAppAddUser.userNameTxtbox(userNameobj).click();
									bankingAppAddUser.userNameTxtbox(userNameobj).sendKeys(webElementDataDetails.getDataSet().get(3));
									log.info(" Enter User Name");
									Thread.sleep(1000);
									customMessage = "Enter Password";
									WebElementDetails passWordobj = bankingAppAddUserWebElementList.get(5);
									bankingAppAddUser.passwordTxtbox(passWordobj).click();
									bankingAppAddUser.passwordTxtbox(passWordobj).sendKeys(webElementDataDetails.getDataSet().get(4));
									log.info(" Enter Password");
									Thread.sleep(1000);
									customMessage = "Enter eMail";
									WebElementDetails eMailobj = bankingAppAddUserWebElementList.get(6);
									bankingAppAddUser.emailTxtbox(eMailobj).click();
									bankingAppAddUser.emailTxtbox(eMailobj).sendKeys(webElementDataDetails.getDataSet().get(5));
									log.info(" Enter eMail ");
									Thread.sleep(1000);
									customMessage = "Enter Phone";
									WebElementDetails pHoneobj = bankingAppAddUserWebElementList.get(7);
									bankingAppAddUser.phoneTxtbox(pHoneobj).click();
									bankingAppAddUser.phoneTxtbox(pHoneobj).sendKeys(webElementDataDetails.getDataSet().get(6));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									customMessage = "Enter City";
									WebElementDetails Cityobj = bankingAppAddUserWebElementList.get(8);
									bankingAppAddUser.cityTxtbox(Cityobj).click();
									bankingAppAddUser.cityTxtbox(Cityobj).sendKeys(webElementDataDetails.getDataSet().get(7));
									log.info(" Enter City ");
									Thread.sleep(1000);
									
									customMessage = "Enter State";
									WebElementDetails sTateobj = bankingAppAddUserWebElementList.get(9);
									bankingAppAddUser.stateTxtbox(sTateobj).click();
									bankingAppAddUser.stateTxtbox(sTateobj).sendKeys(webElementDataDetails.getDataSet().get(8));
									log.info(" Enter State ");
									Thread.sleep(1000);
									
									customMessage = "Enter Building";
									WebElementDetails Buildingobj = bankingAppAddUserWebElementList.get(11);
									bankingAppAddUser.buildingTxtbox(Buildingobj).click();
									bankingAppAddUser.buildingTxtbox(Buildingobj).sendKeys(webElementDataDetails.getDataSet().get(10));
									log.info(" Enter Building ");
									Thread.sleep(1000);
									
									customMessage = "Enter Street";
									WebElementDetails Streetobj = bankingAppAddUserWebElementList.get(10);
									bankingAppAddUser.streetTxtbox(Streetobj).click();
									bankingAppAddUser.streetTxtbox(Streetobj).sendKeys(webElementDataDetails.getDataSet().get(9));
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									customMessage = "Enter Street";
									 Streetobj = bankingAppAddUserWebElementList.get(12);
									bankingAppAddUser.streetTxtbox(Streetobj).click();
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									Thread.sleep(10000);
									}
						   }	
						}
					} else {
						log.info(" Unable to execute the script Test data is empty");
					}
					
				} else {
					log.info(" Unable to execute the script as some or all the mandatory objects or values are null");
				}
			} catch (java.lang.AssertionError e) {
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} catch (Exception e) {
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} finally {
				TAFDBManagerHelper.getInstance().saveTestCaseDetails(testCaseDetails);
			}
			log.info("END of the method login");
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
