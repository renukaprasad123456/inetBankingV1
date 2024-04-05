package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "uid")
	WebElement textUsername;

	@FindBy(xpath = "//input[@name='password']")
	WebElement textPassword;

	@FindBy(css = "input[name='btnLogin']")
	WebElement logButton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logOutButton;

	public void setName(String name) {
		textUsername.sendKeys(name);
	}

	public void setPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}

	public void clickOnLogin() {
		logButton.click();
	}
	
	public void clickOnLogOutButton()
	{
		logOutButton.click();
	}

}
