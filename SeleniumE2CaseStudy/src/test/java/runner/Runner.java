package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
	features = {".\\src\\test\\resources\\Features"},
	glue = {"stepDefn"},
	//strict = true,
	dryRun = false,
	monochrome = true,
	plugin = { "pretty",
			   "usage:target//cucumber-reports",
			   "html:target//html-reports//",
			   "json:target//json-reports//",
			   "junit:target//junit-reports//cucumber.xml",
			   "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"
			 } 
	)

public class Runner {
	@AfterClass
	public static void writeExtentReport()
	{
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Sriranjani");
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Application name", "Hotel Booking System");
		Reporter.setSystemInfo("OS", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Local Testing Server");
	}

}
