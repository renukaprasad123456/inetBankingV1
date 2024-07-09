package com.inetBanking.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginSample_001 extends BaseClass {

	private static Logger logger = LogManager.getLogger(TC_LoginSample_001.class.getName());

	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setName("pp");
		logger.info("Username is entered");
		lp.setPassword(pwd);
		logger.info("password is entered");
		lp.clickOnLogin();
		logger.info("click on the login button");

		Alert a = driver.switchTo().alert();
		String alertMessage = a.getText();
		a.accept();
		driver.switchTo().defaultContent();

		if (alertMessage.equals("User is not valid")) {
			Assert.assertTrue(false);
		}

	}

}
