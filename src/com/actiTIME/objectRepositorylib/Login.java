package com.actiTIME.objectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(name="username")
	private WebElement userEdt;
	
	@FindBy(name="pwd")
	private WebElement pwdEdt;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	//Business Library
	public void login(String username, String pwd) {
		userEdt.sendKeys(username);
		pwdEdt.sendKeys(pwd);
		loginBtn.click();
	}
}
