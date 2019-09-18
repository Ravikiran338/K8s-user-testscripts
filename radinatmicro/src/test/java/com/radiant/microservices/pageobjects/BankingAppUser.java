 /**
 * @author Subbarao
 */

package com.radiant.microservices.pageobjects;

import org.openqa.selenium.WebElement;

import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.util.JWebElement;

public class BankingAppUser {

	
	// This method creates object for domain group lookup in HTML page
	public WebElement userMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for domain group lookup in HTML page
	public WebElement addUserbtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

		
	// ==========================================================================
	// This method creates object for user Domain  db details in HTML page
	public WebElement firstNameTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Server Name db details in HTML page
	public WebElement lastNameTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Database Name db details in HTML page
	public WebElement middleNameTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for Schema Name db details in HTML page
	public WebElement userNameTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for User Id  db details in HTML page
	public WebElement passwordTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	
	// ==========================================================================
	// This method creates object for Password db details in HTML page
	public WebElement emailTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	
	// ==========================================================================
	// This method creates object for Password chkbox db details in HTML page
	public WebElement phoneTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for TestConnection button in HTML page
	public WebElement cityTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
		
	}
	
	// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement stateTxtbox(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}
		
		
		// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement streetTxtbox(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}
		
		// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement buildingTxtbox(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}
		
		// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement createBtn(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}
		
		// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement deleteUsrBtn(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}
				
		// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement closeBtn(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}
		
		// ==========================================================================
		// This method creates object for TestConnection button in HTML page
		public WebElement lookup(WebElementDetails webElementDetails) {
			return JWebElement.getWebElement(webElementDetails);
			
		}			
	

}
