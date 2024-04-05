package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTestTitle() throws IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setName(userName);
		lp.setPassword(pwd);
		lp.clickOnLogin();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);

		}

		else {
			captureScreenShot(driver, "loginTestTitle");
			Assert.assertTrue(false);

		}
	}

}
