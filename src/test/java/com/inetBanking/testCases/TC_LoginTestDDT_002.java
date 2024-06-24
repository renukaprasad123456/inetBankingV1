package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtility;

public class TC_LoginTestDDT_002 extends BaseClass {

	Logger logger = LogManager.getLogger(TC_LoginTestDDT_002.class.getName());

	@Test(dataProvider = "LoginData")
	public void loginTest(String UserName, String Password) throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setName(UserName);
		logger.info("Username is entered");
		lp.setPassword(Password);
		logger.info("Password is entered");
		lp.clickOnLogin();
		logger.info("login is successfull...");

		if (isAlertpresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}

		else {
			Assert.assertTrue(true);
			lp.clickOnLogOutButton();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertpresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData2.xlsx";
		int rowCount = XLUtility.getRowCount(path, "Sheet1");
		System.out.println("rowCount is:" + rowCount);
		int colCount = XLUtility.getCellCount(path, "Sheet1", 1);
		System.out.println("colCount is:" + colCount);

		String loginData[][] = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtility.getCellData(path, "Sheet1", i, j);
			}
		}

		return loginData;

	}

}
