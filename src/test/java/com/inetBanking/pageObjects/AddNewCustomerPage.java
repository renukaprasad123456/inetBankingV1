package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	@CacheLookup
	WebElement linkNewCustomer;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	@CacheLookup
	WebElement custName;

	@FindBy(how = How.XPATH, using = "//tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement cusGender;

	@FindBy(how = How.CSS, using = "input#dob")
	@CacheLookup
	WebElement custDOB;

	@FindBy(how = How.XPATH, using = "//tbody/tr[7]/td[2]/textarea[1]")
	@CacheLookup
	WebElement custAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement custCity;

	@FindBy(how = How.CSS, using = "input[name='state']")
	@CacheLookup
	WebElement custState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement custPincode;

	@FindBy(how = How.XPATH, using = "//tbody/tr[11]/td[2]/input[1]")
	@CacheLookup
	WebElement CustMobileNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement custMailID;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	@CacheLookup
	WebElement custPassword;

	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	@CacheLookup
	WebElement subButton;

	public void clickOnNewCustomer() {
		linkNewCustomer.click();
	}

	public void setCustomerName(String cName) {
		custName.sendKeys(cName);

	}

	public void selectGender() {
		cusGender.click();
	}

	public void selectDOB(String mm, String dd, String yyyy) {
		custDOB.sendKeys(mm);
		custDOB.sendKeys(dd);
		custDOB.sendKeys(yyyy);
	}

	public void setAddress(String address) {
		custAddress.sendKeys(address);
	}

	public void setCity(String city) {
		custCity.sendKeys(city);
	}

	public void setState(String state) {
		custState.sendKeys(state);
	}

	public void setPincode(String pincode) {
		custPincode.sendKeys(String.valueOf(pincode));
	}

	public void setMobileNumber(String num) {
		CustMobileNo.sendKeys(num);
	}

	public void setEmail(String email) {
		custMailID.sendKeys(email);
	}

	public void setpassword(String pwd) {
		custPassword.sendKeys(pwd);
	}

	public void clickOnSubmit() {
		subButton.click();
	}
}
