package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {
	
	public BasePage(WebDriver driver)
	{
		super(driver);
	}

	@Override
	public void waitUntiElementVisible(By locator) {
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("some error is coming while waiting for the perticular webelement:"+locator.toString());
			e.printStackTrace();
		}
		
	}

}
