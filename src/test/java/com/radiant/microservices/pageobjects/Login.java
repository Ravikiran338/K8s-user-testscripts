/**
 * @author Chandu
 */
package com.radiant.microservices.pageobjects;

import org.openqa.selenium.WebElement;

import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.util.JWebElement;

public class Login {

	// ==========================================================================
	// This method creates object for Role Change* Button in HTML page

	public WebElement userNameTxtBox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Select Role* Button in HTML page

	public WebElement passwordTxtBox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Checking Role Name* in HTML page

	public WebElement domainTxtBox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Add Customer* Button in HTML page

	public WebElement loginBtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Add Customer* Button in HTML page
	public WebElement logoutBtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

}