package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Edit Customer")
	WebElement editCust;

	@FindBy(name = "cusid")
	WebElement cusId;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	WebElement subButton;

	@FindBy(css = "textarea[name='addr']")
	WebElement addr;

	@FindBy(name = "city")
	WebElement cityCust;

	@FindBy(xpath = "//input[@name='state']")
	WebElement stateCust;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pincodeCust;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mobileNumCust;

	@FindBy(css = "input[name='emailid']")
	WebElement emailCust;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement editSubmit;

	// click on edit customer
	public void clickEditCustomer() {
		editCust.click();
	}

	public void sendCusId(String id) {
		cusId.sendKeys(id);
	}

	public void clickSubmitButton() {
		subButton.click();
	}

	// send addrs
	public void setAddress(String addrs) {
		addr.sendKeys(addrs);
	}

	// send city
	public void setCity(String city) {
		cityCust.sendKeys(city);
	}

	// send state
	public void setState(String state) {
		stateCust.sendKeys(state);
	}

	// send pin
	public void setPin(String pin) {
		pincodeCust.sendKeys(pin);
	}

	// send mobile
	public void setMobileNumber(int num) {
		String numMob = String.valueOf(num);
		mobileNumCust.sendKeys(numMob);
	}

	// send e-mail
	public void setEmail(String email) {
		emailCust.sendKeys(email);
	}

	// click on submit after edit
	public void clickOnSubmitAfterEdit() {
		editSubmit.click();
	}

	

}
