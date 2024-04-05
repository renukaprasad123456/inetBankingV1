package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {

	@Test
	public void addNewCust() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setName(userName);
		lp.setPassword(pwd);
		lp.clickOnLogin();
		Thread.sleep(3000);

		
		AddNewCustomerPage cp = new AddNewCustomerPage(driver);
	
		cp.clickOnNewCustomer();
		cp.setCustomerName("rameshprasad");
		cp.selectGender();
		cp.selectDOB("01", "14", "1995");
		cp.setAddress("magadi");
		cp.setCity("Bengaluru");
		cp.setState("karnataka");
		cp.setPincode("562120");
		cp.setMobileNumber(String.valueOf("9738255480"));
		String email = randomString() + "@gmail.com";
		cp.setEmail(email);
		cp.setpassword("Passid@08");
		Thread.sleep(3000);
		cp.clickOnSubmit();
		Thread.sleep(3000);
		String successMessage = driver
				.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).getText();
		System.out.println(successMessage);

		if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}

	}

}
