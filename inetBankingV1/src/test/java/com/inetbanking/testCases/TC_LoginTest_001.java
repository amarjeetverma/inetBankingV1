package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		logger.info("URL is opened: " + baseURL);

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username: " + username);
		Thread.sleep(2000);
		
		lp.setPassword(password);
		logger.info("Entered Password.");
		Thread.sleep(2000);

		lp.clickSubmit();
		logger.info("Clicked on Submitted.");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test case is Passed.");
			
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test case is Failed.");
		}
	}
}
