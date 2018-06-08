package com.actiTIME.genericLib;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actiTIME.objectRepositorylib.Home;
import com.actiTIME.objectRepositorylib.Login;
/**
 * 
 * @author Priya
 *
 */
public class BaseClass {
	
	/* Datamember - common global variable */
	public WebDriver driver;
	
	/* Create an object of FileDataUtils class to access Properties file and excel file for test data */
	 FileDataLib lib = new FileDataLib(); 
	
	/* 
	 * Common Global Settings for all the test scripts
	 * Launch the Browser - firefox or chrome
	 */
	@BeforeClass
	public void configBC() throws Throwable {
		Properties pObj = lib.getPropertiesFileObject();
		String bName = pObj.getProperty("browser");
		if(bName.equals("firefox")) {
			/* Launch browser*/
			driver = new FirefoxDriver();
		} else if(bName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");	
			driver = new ChromeDriver();
		}
	}
		
	/*
	 * Navigate to the application and login		
	 */
	@BeforeMethod
	public void configBM() throws Throwable {
		
		/* Maximize the browser window */
		driver.manage().window().maximize();
		
		/* Set implicit wait for page loading */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/* Read Url, Username, Password from the Property File */
		Properties pObj= lib.getPropertiesFileObject();
		String URL=pObj.getProperty("Url");
		String USERNAME=pObj.getProperty("Username");
		String PWD=pObj.getProperty("Password");
		
		/* get actiTIME login page */
		driver.get(URL);
		
		/* Login to the application */
		Login ln=PageFactory.initElements(driver, Login.class);
		ln.login(USERNAME, PWD);
		
		/* Enter User name, Password and click on Login button 
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();*/
	}
	
	
	/*
	 * Logout from the application
	 */
	@AfterMethod
	public void configAM() {
		Home hm = PageFactory.initElements(driver, Home.class);
		hm.logout();
		
		/*driver.findElement(By.linkText("Logout")).click();*/
	}
	
	
	/*
	 * close the browser
	 */
	@AfterClass
	public void configAC() {
		driver.close();
		driver.manage().deleteAllCookies();
	}
	
}
