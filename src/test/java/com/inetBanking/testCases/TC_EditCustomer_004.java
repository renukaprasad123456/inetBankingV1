package com.inetBanking.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

@Test(groups= {"Regression"})
public class TC_EditCustomer_004 extends BaseClass {
	private static Logger logger = LogManager.getLogger(TC_EditCustomer_004.class.getName());

	public void editExistingCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setName(userName);
		logger.info("User name is entered");
		lp.setPassword(pwd);
		logger.info("Password is entered");
		lp.clickOnLogin();
		logger.info("Login is successfull...");
		Thread.sleep(3000);

		EditCustomerPage ecp = new EditCustomerPage(driver);
		ecp.clickEditCustomer();
		ecp.sendCusId("61801");
		ecp.clickSubmitButton();
		ecp.setAddress("Nagharabhavi circle");
		ecp.setCity("Manglore");
		ecp.setState("Up");
		ecp.setPin("332211");
		ecp.setMobileNumber(990022333);
		ecp.setEmail("suresh99@gmail.com");
		ecp.clickOnSubmitAfterEdit();
		Thread.sleep(3000);

		String alertMess = driver.switchTo().alert().getText();
		System.out.println("alert message is:" + alertMess);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();

		if (alertMess.equals("No Changes made to Customer records")) {
			logger.info("Edit customer successfull...");
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}
		

	}

}
