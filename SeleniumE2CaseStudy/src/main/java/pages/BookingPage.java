package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class BookingPage extends TestBase{

	public BookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div/h2")
	private WebElement pageHeader;
	
	@FindBy(id = "txtFirstName")
	private WebElement firstname;
	
	@FindBy(id = "txtLastName")
	private WebElement lastname;
	
	@FindBy(id = "txtEmail")
	private WebElement email;
	
	@FindBy(id = "txtPhone")
	private WebElement phone;
	
	@FindBy(xpath = "/html/body/div/div/form/table/tbody/tr[6]/td[2]/textarea")
	private WebElement address;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "state")
	private WebElement state;
	
	@FindBy(name = "persons")
	private WebElement persons;
	
	@FindBy(id = "txtCardholderName")
	private WebElement cardHolderName;
	
	@FindBy(id = "txtDebit")
	private WebElement debitCardNum;
	
	@FindBy(id = "txtCvv")
	private WebElement cvv;
	
	@FindBy(id = "txtMonth")
	private WebElement month;
	
	@FindBy(id = "txtYear")
	private WebElement year;
	
	@FindBy(id = "btnPayment")
	private WebElement confirmBtn;
	
	/*public String getPageHeader()
	{
		return pageHeader.getText();
	}*/
	public void enterFirstName(String fName)
	{
		firstname.clear();
		firstname.sendKeys(fName);
	}

	public void enterLastName(String lName)
	{
		lastname.clear();
		lastname.sendKeys(lName);
	}
	
	public void enterEmail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
	}
	
	public void enterMobile(String mobile)
	{
		phone.clear();
		phone.sendKeys(mobile);
	}
	
	public void enterAddress(String addr)
	{
		address.clear();
		address.sendKeys(addr);
	}
	
	public void selectCity(String cityName)
	{
		new Select(city).selectByVisibleText(cityName);
	}
	
	public void selectState(String stateName)
	{
		new Select(state).selectByVisibleText(stateName);
	}
	
	public void selectGuests(String guestNum)
	{
		new Select(persons).selectByVisibleText(guestNum);
	}
	
	public void enterCardHolderName(String name)
	{
		cardHolderName.clear();
		cardHolderName.sendKeys(name);
	}
	
	public void enterDebitCardNum(String cardNum)
	{
		debitCardNum.clear();
		debitCardNum.sendKeys(cardNum);
	}
	
	public void enterCvv(String cvvNum)
	{
		cvv.clear();
		cvv.sendKeys(cvvNum);
	}
	
	public void enterMonth(String expiryMonth)
	{
		month.clear();
		month.sendKeys(expiryMonth);
	}
	
	public void enterExpiryYear(String expiryYear)
	{
		year.clear();
		year.sendKeys(expiryYear);
	}
	
	public void clickSubmit()
	{
		confirmBtn.click();
	}
	
	public String getAlertMsg()
	{
		return driver.switchTo().alert().getText();
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateMobile(String invalidMob)
	{
		if(!((invalidMob.startsWith("7") | invalidMob.startsWith("8") | invalidMob.startsWith("9")) & (invalidMob.length()==10)))
		{
			return getAlertMsg();
		}
		else
			return "";
	}
}
