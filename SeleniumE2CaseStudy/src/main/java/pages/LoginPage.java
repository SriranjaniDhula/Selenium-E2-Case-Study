package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id='mainCnt']/div/div/h1")
	private WebElement pageHeader;
	
	@FindBy(name = "userName")
	private WebElement userName;
	
	@FindBy(name = "userPwd")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement LoginBtn;
	
	@FindBy(id = "userErrMsg")
	private WebElement userErrMsg;
	
	@FindBy(id = "pwdErrMsg")
	private WebElement pwdErrMsg;
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void login(String user, String pwd)
	{
		userName.clear();
		password.clear();
		userName.sendKeys(user);
		password.sendKeys(pwd);
		LoginBtn.click();
	}
	
	public String invalidUNVerify()
	{
		LoginBtn.click();
		return userErrMsg.getText();
	}

	public String invalidPwdverify(String UserName)
	{
		userName.sendKeys(UserName);
		LoginBtn.click();
		return pwdErrMsg.getText();
	}
}
