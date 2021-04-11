package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("Browser has been initilized.");
		lp.setUserName(username);
		logger.info("Username Entered.");
		lp.setPassword(password);
		logger.info("Password Entered.");
		lp.clickSubmit();
		logger.info("Submitted.");
		
		Thread.sleep(3000);
		
		logger.info("Providing Customer Details.");
		AddCustomerPage ac=new AddCustomerPage(driver);
		ac.clickAddNewCustomer();
		ac.custName("Amarjeet Verma");
		ac.custgender("male");
		ac.custdob("001987","07","16");
		Thread.sleep(5000);
		ac.custaddress("India");
		ac.custcity("Mumbai");
		ac.custState("MH");
		ac.custpinno(401107);
		ac.custtelephone(28431722);
		String email = randomstring()+"@gmail.com";		
		ac.custemailid(email);
		ac.custpassword("dadasdsada");
		ac.custsubmit();
		
		Thread.sleep(3000);
		logger.info("Customer Details Validation started.");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case is Passed.");
			
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test Case is Failed.");
		}
	}
}
