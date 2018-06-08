package com.actiTIME.customertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.actiTIME.genericLib.BaseClass;
import com.actiTIME.genericLib.FileDataLib;
import com.actiTIME.objectRepositorylib.CreateNewCustomer;
import com.actiTIME.objectRepositorylib.Home;
import com.actiTIME.objectRepositorylib.ProjectAndCustomer;
import com.actiTIME.objectRepositorylib.Tasks;

@Listeners
public class CustomerTest extends BaseClass {
	
	/* Make Object of FileDataLib Class to access test data */
	FileDataLib lib = new FileDataLib();
	
	/**
	 * This test case will create a customer with only one parameter: customer name
	 * @throws Throwable
	 */
	@Test
	public void createCustomerTest() throws Throwable {
		
		/* read the test data from excel file */
		String custName = lib.getExcelData("Sheet1", 1, 2);
				
		/*======== Create customer =========*/
		
		Home hm = PageFactory.initElements(driver, Home.class);
		hm.navigateToTaskPage();
		
		Tasks tk = PageFactory.initElements(driver, Tasks.class);
		tk.navigateToCustomerPage();
		
		ProjectAndCustomer pac	= PageFactory.initElements(driver, ProjectAndCustomer.class);
		pac.navigateToCreateNewCustomer();
		
		CreateNewCustomer cnc = PageFactory.initElements(driver, CreateNewCustomer.class);
		cnc.createCustomer(custName);
		
		/*========= Verify customer is created successfully ===========*/
		
		String actMsg = cnc.getSuccessMsg().getText();
		boolean stat = actMsg.contains("successfully");
		Assert.assertEquals(stat, true);
		
	}
	
	@Test
	public void createCustomerWithDescrpTest() throws Throwable {
		
		/* read the test data from excel file */
		String custName = lib.getExcelData("Sheet1", 1, 2);
		String custDescrp = lib.getExcelData("Sheet1", 1, 3);
		
		/*======== Create customer =========*/
		
		Home hm = PageFactory.initElements(driver, Home.class);
		hm.navigateToTaskPage();
		
		Tasks tk = PageFactory.initElements(driver, Tasks.class);
		tk.navigateToCustomerPage();
		
		ProjectAndCustomer pac	= PageFactory.initElements(driver, ProjectAndCustomer.class);
		pac.navigateToCreateNewCustomer();
		
		CreateNewCustomer cnc = PageFactory.initElements(driver, CreateNewCustomer.class);
		cnc.createCustomer(custName,custDescrp);
		
		/*========= Verify customer is created successfully ===========*/
		
		String actMsg = cnc.getSuccessMsg().getText();
		boolean stat = actMsg.contains("successfully");
		Assert.assertEquals(stat, true);
		
	}

	@Test
	public void modifyCustomerTest() {
		System.out.println("Modify the customer and verify if");
	}
	
	@Test
	public void deleteCustomerTest() {
		System.out.println("delete customer and verify");
	}
}
