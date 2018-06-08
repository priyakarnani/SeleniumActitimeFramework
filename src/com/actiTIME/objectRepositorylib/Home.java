package com.actiTIME.objectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	@FindBy (xpath="//div[text()='Tasks']")
	private WebElement taskImg;
	
	@FindBy (xpath="//div[text()=' Reports']")
	private WebElement reportsImg;
	
	@FindBy (xpath="//div[text()='Users']")
	private WebElement usersImg;
	
	@FindBy (id="logoutLink")
	private WebElement logoutBtn;
	
	public void navigateToTaskPage() {
		taskImg.click();
	}
	
	public void navigateToReportsPage() {
		reportsImg.click();
	}
	
	public void navigateToUserPage() {
		usersImg.click();
	}
	
	public void logout() {
		logoutBtn.click();
	}

}
