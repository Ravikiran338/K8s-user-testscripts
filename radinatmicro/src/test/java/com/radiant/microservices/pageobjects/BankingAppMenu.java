 /**
 * @author Subbarao
 */

package com.radiant.microservices.pageobjects;

import org.openqa.selenium.WebElement;

import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.util.JWebElement;

public class BankingAppMenu {
	
	// ==========================================================================
	// This method creates object for domain group lookup in HTML page
	public WebElement userMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

		
	// ==========================================================================
	// This method creates object for user Domain  db details in HTML page
	public WebElement customerMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Server Name db details in HTML page
	public WebElement accountMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Database Name db details in HTML page
	public WebElement balanceEnquiry(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for Schema Name db details in HTML page
	public WebElement depositMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for User Id  db details in HTML page
	public WebElement lockerMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	
	// ==========================================================================
	// This method creates object for Password db details in HTML page
	public WebElement withDrawMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	
	// ==========================================================================
	// This method creates object for Password chkbox db details in HTML page
	public WebElement changePasswordMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for TestConnection button in HTML page
	public WebElement logoutMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
		
	}
	

}
