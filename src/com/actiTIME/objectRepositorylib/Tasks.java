package com.actiTIME.objectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tasks {
	@FindBy (linkText="Projects & Customers")
	private WebElement proj_custBtn;
	
	public void navigateToCustomerPage() {
		proj_custBtn.click();
	}
}
