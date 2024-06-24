package com.inetBanking.testCases;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	private static Logger logger = LogManager.getLogger(TC_LoginTest_001.class.getName());

	@Test
	public void loginTestTitle() throws IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setName(userName);
		logger.info("username is entered");
        lp.setPassword(pwd);
        logger.info("password is entered");
        lp.clickOnLogin();
        logger.info("login is successfull.....");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);

		}

		else {
			captureScreenShot(driver, "loginTestTitle");
			Assert.assertTrue(false);

		}
	}

}
