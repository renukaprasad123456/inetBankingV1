package com.inetBanking.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Constructor of abstract class
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,Duration.ofSeconds(5));
	}
	
	public abstract void waitUntiElementVisible(By locator);
	

}
