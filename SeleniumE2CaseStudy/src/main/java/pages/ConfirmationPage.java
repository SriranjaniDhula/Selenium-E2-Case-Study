package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ConfirmationPage extends TestBase{

	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/h1")
	private WebElement successMsg;

	public String getSuccessMsg() {
		return successMsg.getText();
	}
	
}
