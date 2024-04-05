package com.inetBanking.utilities;

//Listeners class used to generate extent report

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// create the time stamp
		String repname = "Test-Report-" + timeStamp + ".html";

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repname);// specify the
																									// location
		try {
			spark.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml/");
		} catch (IOException e) {

			e.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Renukaprasad");

		spark.config().setDocumentTitle("InetBanking Test Project");// title of the report
		spark.config().setReportName("Functional Test Report");// name of the report
		spark.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());// create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));// send the information to
																							// extent report

	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

		File f = new File(screenShotPath);

		if (f.exists()) {
			try {
				logger.fail("screenShot is below:" + logger.addScreenCaptureFromPath(screenShotPath));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
