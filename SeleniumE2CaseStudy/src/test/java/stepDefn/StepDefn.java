package stepDefn;

import base.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BookingPage;
import pages.ConfirmationPage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

public class StepDefn extends TestBase{
	LoginPage lp;
	BookingPage bp;
	ConfirmationPage cp;
	
	@Given("^user is in Login Page$")
	public void user_is_in_Login_Page() throws Throwable {
		TestBase.initialize();
	}

	@Given("^Title of login page is \"([^\"]*)\"$")
	public void title_of_login_page_is(String title) throws Throwable {
		lp = new LoginPage();
		Assert.assertEquals(lp.getPageHeader(), title);
	}	
	
	@When("^User enters invalid credentials receives warning message$")
	public void user_enters_invalid_credentials_receives_warning_message() throws Throwable {
		lp = new LoginPage();
		Assert.assertEquals("* Please enter userName.", lp.invalidUNVerify());
		Thread.sleep(1000);
		Assert.assertEquals("* Please enter password.", lp.invalidPwdverify(prop.getProperty("Username")));
		Thread.sleep(1000);
	}

	@Then("^User enters correct Login Credentials$")
	public void user_enters_Login_Credentials() throws Throwable {
		lp = new LoginPage();		
		lp.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Then("^User is in home page title is \"([^\"]*)\"$")
	public void user_is_in_home_page_title_is(String title) throws Throwable {
		lp = new LoginPage();
		Assert.assertEquals(lp.getPageTitle(), title);
	}
	
	@Given("^User is in Hotel Booking Form \"([^\"]*)\"$")
	public void user_is_in_Hotel_Booking_Form(String title) throws Throwable {
		bp = new BookingPage();
		Assert.assertEquals(bp.getPageTitle(), title);
	}

	@When("^User enters all the details$")
	public void user_enters_all_the_details() throws Throwable {
		bp = new BookingPage();
		//First Name
		bp.clickSubmit();
		Assert.assertEquals("Please fill the First Name", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterFirstName(prop.getProperty("FirstName"));
		//Last Name
		bp.clickSubmit();
		Assert.assertEquals("Please fill the Last Name", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterLastName(prop.getProperty("LastName"));
		//Email
		bp.clickSubmit();
		Assert.assertEquals("Please fill the Email", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterEmail(prop.getProperty("Email"));
		//Mobile No.
		bp.clickSubmit();
		Assert.assertEquals("Please fill the Mobile No.", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterMobile(prop.getProperty("InvalidMobile"));
		//Mobile No. Validation
		bp.clickSubmit();
		Assert.assertEquals("Please enter valid Contact no.", bp.validateMobile(prop.getProperty("InvalidMobile")));
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterMobile(prop.getProperty("Mobile"));
		//Address
		bp.enterAddress(prop.getProperty("Address"));
		//City
		bp.clickSubmit();
		Assert.assertEquals("Please select city", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.selectCity(prop.getProperty("City"));
		//State
		bp.clickSubmit();
		Assert.assertEquals("Please select state", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.selectState(prop.getProperty("State"));
		//Guests		
		bp.selectGuests(prop.getProperty("NumberOfStays"));
		//Card Holder Name
		bp.clickSubmit();
		Assert.assertEquals("Please fill the Card holder name", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterCardHolderName(prop.getProperty("CardHolderName"));
		//DebitCard Number
		bp.clickSubmit();
		Assert.assertEquals("Please fill the Debit card Number", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterDebitCardNum(prop.getProperty("CardNumber"));
		//CVV
		bp.clickSubmit();
		Assert.assertEquals("Please fill the CVV", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterCvv(prop.getProperty("CVV"));
		//Expiry Month
		bp.clickSubmit();
		Assert.assertEquals("Please fill expiration month", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterMonth(prop.getProperty("ExpiryMonth"));
		//Expiry Year
		bp.clickSubmit();
		Assert.assertEquals("Please fill the expiration year", bp.getAlertMsg());
		Thread.sleep(1000);
		bp.acceptAlert();
		bp.enterExpiryYear(prop.getProperty("ExpiryYear"));				
	}

	@And("^Submits the form$")
	public void submits_the_form() throws Throwable {
		bp = new BookingPage();
		bp.clickSubmit();
		Thread.sleep(500);
	}
	
	@Then("^User is in confirmation page with message \"([^\"]*)\"$")
	public void user_is_in_confirmation_page_with_message(String msg) throws Throwable {
		cp = new ConfirmationPage();
		Thread.sleep(1000);
		Assert.assertEquals(msg, cp.getSuccessMsg());
		//Assert.assertEquals("Booking Completed!!!", cp.getSuccessMsg());
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException
	{
		Reporter.addScenarioLog("Failure Screenshot");
		if(scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot screen = (TakesScreenshot)driver;
			File srcPath = screen.getScreenshotAs(OutputType.FILE);
			File destPath = new File(System.getProperty("user.dir") + "//target//html//" + screenshotName + ".png");
			FileUtils.copyFile(srcPath, destPath);
			Reporter.addScreenCaptureFromPath(destPath.toString());
		}
		if(scenario.getName().equals("Hotel Booking Form"))
			driver.quit();
	}

}
