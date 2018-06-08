package com.actiTIME.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverCommonLib {
	 
	public WebDriver driver;
	
	/**
	 * Press Okay or accept. 
	 */
	public void acceptAlert() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	
	/**
	 * Dismiss alert window or cancel it.
	 */
	public void dismissAlert() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
	/**
	 * @param sourceLocWebElem - Enter the weblelement present at the source locations
	 * @param dstLocWebElem - Enter the webelement present at the destination location
	 */
	public void dragAndDrop(WebElement sourceLocWebElem, WebElement dstLocWebElem ) {
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceLocWebElem, dstLocWebElem).perform();
	}
	
	/**
	 * @param onElement - double click on element
	 */
	public void doubleClick(WebElement onElement) {
		Actions act = new Actions(driver);
		act.doubleClick(onElement).perform();
	}
	
	public void waitForPageToDownload() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementToLoad() {
		
	}
	
}
