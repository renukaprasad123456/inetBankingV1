package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetBanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseurl = readConfig.getApplicationURL();
	public String userName = readConfig.getuserName();
	public String pwd = readConfig.getPassword();
	public static WebDriver driver;

	org.testng.log4testng.Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		if (br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			File f = new File("C:\\RP_Installed_Software\\CRX Files\\uBlock-Origin.crx");
			options.addExtensions(f);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (br.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseurl);

	}

	public void captureScreenShot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken...");
	}

	public void logOut() {
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public String randomInteger() {
		String generatedString2 = RandomStringUtils.randomNumeric(8);
		return generatedString2;
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
