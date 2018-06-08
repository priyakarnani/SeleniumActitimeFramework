package com.actiTIME.objectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomer {
	@FindBy(name="name")
	private WebElement custNameEdt;
	
	@FindBy(name="description")
	private WebElement descriptEdt;
	
	@FindBy (name="createCustomerSubmit")
	private WebElement createCustBtn;
	
	@FindBy (xpath="//span[@class='successmsg']")
	private WebElement successMsg;
	
	public WebElement getCustNameEdt() {
		return custNameEdt;
	}

	public WebElement getDescriptEdt() {
		return descriptEdt;
	}

	public WebElement getCreateCustBtn() {
		return createCustBtn;
	}

	public WebElement getSuccessMsg() {
		return successMsg;
	}
	
	/**
	 * Create customer with customer name
	 * @param custName - enter customer name
	 */
	public void createCustomer(String custName) {
		custNameEdt.sendKeys(custName);
		createCustBtn.click();
	}
	/**
	 * Create customer with customer name and description	
	 * @param custName - enter customer name
	 * @param description - enter customer description
	 */
	public void createCustomer(String custName, String description) {
		custNameEdt.sendKeys(custName);
		descriptEdt.sendKeys(description);
		createCustBtn.click();
	}

}
