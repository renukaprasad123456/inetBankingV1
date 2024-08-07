package com.inetBanking.testCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.MyRetryAnalyzer;

public class TC_LoginTest_001 extends BaseClass {

	private static Logger logger = LogManager.getLogger(TC_LoginTest_001.class.getName());

	@Test
	public void loginTestTitle() throws IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setName(userName);
		logger.info("username is entered");
		lp.setPassword(pwd);
		logger.info("password is entered");
		// call explicit wait method because login button takes some time to load on the
		// web page
		lp.waitUntiElementVisible(By.cssSelector("input[name='btnLogin']"));
		lp.clickOnLogin();
		logger.info("login is successfull.....");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("Expected title recieved");
			Assert.assertTrue(true);
		}

		else {
			captureScreenShot(driver, "loginTestTitle");
			Assert.assertTrue(false);

		}
	}

}
