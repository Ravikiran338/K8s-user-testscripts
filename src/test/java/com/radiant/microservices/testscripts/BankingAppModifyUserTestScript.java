/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.pageobjects.BankingAppUser;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JExcelParser;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppModifyUserTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppModifyUserWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppUser bankingAppModifyUser;
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;

	// ==========================================================================

	public BankingAppModifyUserTestScript(TestSuiteDetails suiteDetails) {
		this.suiteDetails = suiteDetails;
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
		testCaseDetails.setTestCaseName(BankingAppModifyUserTestScript.class.getSimpleName());
		if (bankingAppModifyUserWebElementList == null) {
			bankingAppModifyUserWebElementList = JXMLParser.getInstance().getWebElements(BankingAppUser.class.getSimpleName());
		}

		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppUser.class.getSimpleName(), BankingAppModifyUserTestScript.class.getSimpleName());
		   }
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void modifyBankingUser() {
		log.info("START of the method addNewbankingAppModifyUserRecord");
		bankingAppModifyUser = new BankingAppUser();
		String customMessage = null;
		WebDriver driver = null;
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerequisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
			driver.get(resourceBundle.getString("application.url"));
			Thread.sleep(6000);
			
			customMessage = "Click on Add button";
			WebElementDetails userMenuobj = bankingAppModifyUserWebElementList.get(14);
			bankingAppModifyUser.userMenu(userMenuobj).click();
			Thread.sleep(6000);
			
			
			if (bankingAppModifyUserWebElementList != null && bankingAppModifyUserWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									Thread.sleep(10000);

									customMessage = "select all records from look-up";
									WebElementDetails lookupTableObj = bankingAppModifyUserWebElementList.get(15);
									WebElement lookupTable = bankingAppModifyUser.lookup(lookupTableObj); 
									Thread.sleep(1000);
									WebElementDetails rowsObj = bankingAppModifyUserWebElementList.get(16);
									int selctedRecordNo = 0;
									List<WebElement> rows = lookupTable
											.findElements(By.cssSelector(rowsObj.getCssSelector()));
									Thread.sleep(6000);
									String DomainId = null;
									JavascriptExecutor js = (JavascriptExecutor) driver;
									for (int i = 1; i <= rows.size(); i++) {
										  if ((i % 10) == 0)
										  {
											    js.executeScript("window.scrollBy(0,1000)");
											    Thread.sleep(3000);
											   // rows.get(i).click();
										  }		
										  List<WebElement> cols = rows.get(i).findElements(By.cssSelector("td"));
										  DomainId = cols.get(2).getText();
										  if ((DomainId).trim().equalsIgnoreCase(webElementDataDetails.getDataSet().get(0))) {
												rows.get(i).findElement(By.cssSelector(".btn-primary.btn-xs")).click();
												break;
											}
									}

									customMessage = "Enter First Name";
									WebElementDetails firstNameTxtobj = bankingAppModifyUserWebElementList.get(20);
									bankingAppModifyUser.firstNameTxtbox(firstNameTxtobj).click();
									bankingAppModifyUser.firstNameTxtbox(firstNameTxtobj).clear();
									bankingAppModifyUser.firstNameTxtbox(firstNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(1));
									log.info(" Enter First Name");
									Thread.sleep(1000);
									customMessage = "Enter Last Name";
									WebElementDetails lastNameTxtobj = bankingAppModifyUserWebElementList.get(21);
									bankingAppModifyUser.lastNameTxtbox(lastNameTxtobj).click();
									bankingAppModifyUser.lastNameTxtbox(lastNameTxtobj).clear();
									bankingAppModifyUser.lastNameTxtbox(lastNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(2));
									log.info(" Last Name");
									Thread.sleep(1000);
									customMessage = "Enter Middle Name";
									WebElementDetails middleNameTxtobj = bankingAppModifyUserWebElementList.get(22);
									bankingAppModifyUser.middleNameTxtbox(middleNameTxtobj).click();
									bankingAppModifyUser.middleNameTxtbox(middleNameTxtobj).clear();
									bankingAppModifyUser.middleNameTxtbox(middleNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(3));
									log.info(" Enter Middle Name");
									Thread.sleep(1000);
									customMessage = "Enter User Name";
									WebElementDetails userNameobj = bankingAppModifyUserWebElementList.get(23);
									bankingAppModifyUser.userNameTxtbox(userNameobj).click();
									bankingAppModifyUser.userNameTxtbox(userNameobj).clear();
									bankingAppModifyUser.userNameTxtbox(userNameobj).sendKeys(webElementDataDetails.getDataSet().get(4));
									log.info(" Enter User Name");
									Thread.sleep(1000);
									customMessage = "Enter Password";
									WebElementDetails passWordobj = bankingAppModifyUserWebElementList.get(24);
									bankingAppModifyUser.passwordTxtbox(passWordobj).click();
									bankingAppModifyUser.passwordTxtbox(passWordobj).clear();
									bankingAppModifyUser.passwordTxtbox(passWordobj).sendKeys(webElementDataDetails.getDataSet().get(5));
									log.info(" Enter Password");
									Thread.sleep(1000);
									customMessage = "Enter eMail";
									WebElementDetails eMailobj = bankingAppModifyUserWebElementList.get(25);
									bankingAppModifyUser.emailTxtbox(eMailobj).click();
									bankingAppModifyUser.emailTxtbox(eMailobj).clear();
									bankingAppModifyUser.emailTxtbox(eMailobj).sendKeys(webElementDataDetails.getDataSet().get(6));
									log.info(" Enter eMail ");
									Thread.sleep(1000);
									customMessage = "Enter Phone";
									WebElementDetails pHoneobj = bankingAppModifyUserWebElementList.get(26);
									bankingAppModifyUser.phoneTxtbox(pHoneobj).click();
									bankingAppModifyUser.phoneTxtbox(pHoneobj).clear();
									bankingAppModifyUser.phoneTxtbox(pHoneobj).sendKeys(webElementDataDetails.getDataSet().get(7));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									customMessage = "Enter City";
									WebElementDetails Cityobj = bankingAppModifyUserWebElementList.get(27);
									bankingAppModifyUser.cityTxtbox(Cityobj).click();
									bankingAppModifyUser.cityTxtbox(Cityobj).clear();
									bankingAppModifyUser.cityTxtbox(Cityobj).sendKeys(webElementDataDetails.getDataSet().get(8));
									log.info(" Enter City ");
									Thread.sleep(1000);
									customMessage = "Enter State";
									WebElementDetails sTateobj = bankingAppModifyUserWebElementList.get(28);
									bankingAppModifyUser.stateTxtbox(sTateobj).click();
									bankingAppModifyUser.stateTxtbox(sTateobj).clear();
									bankingAppModifyUser.stateTxtbox(sTateobj).sendKeys(webElementDataDetails.getDataSet().get(9));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									customMessage = "Enter Street";
									WebElementDetails Streetobj = bankingAppModifyUserWebElementList.get(29);
									bankingAppModifyUser.streetTxtbox(Streetobj).click();
									bankingAppModifyUser.streetTxtbox(Streetobj).clear();
									bankingAppModifyUser.streetTxtbox(Streetobj).sendKeys(webElementDataDetails.getDataSet().get(10));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									customMessage = "Enter Buildiong";
									WebElementDetails Buildingobj = bankingAppModifyUserWebElementList.get(30);
									bankingAppModifyUser.buildingTxtbox(Buildingobj).click();
									bankingAppModifyUser.buildingTxtbox(Buildingobj).clear();
									bankingAppModifyUser.buildingTxtbox(Buildingobj).sendKeys(webElementDataDetails.getDataSet().get(11));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									customMessage = "Click on Create btutn";
									WebElementDetails createBtnobj = bankingAppModifyUserWebElementList.get(31);
									bankingAppModifyUser.createBtn(createBtnobj).click();
									
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
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} catch (Exception e) {
				suiteDetails.setTestStatusSuccess(false);
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
