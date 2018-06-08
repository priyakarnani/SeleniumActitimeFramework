package com.actiTIME.objectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectAndCustomer {
	@FindBy (xpath="//input[@value='Create New Customer']")
	private WebElement createNewCustBtn;
	
	@FindBy (xpath="//input[@value='Create New Project']")
	private WebElement createNewProjBtn;
	
	public void navigateToCreateNewCustomer() {
		createNewCustBtn.click();
	}
	
	private void navigateToCreateNewPro() {
		createNewProjBtn.click();
	}
	
}
