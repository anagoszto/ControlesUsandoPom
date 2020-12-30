package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;


public class paginaAutomationPractice {
	
	WebDriver driver;
	
	@FindBy(id="email_create")
	WebElement email;
	
	@FindBy(xpath="//button[@id='SubmitCreate']/span")
	WebElement btnSubmit;
	
	@FindBy(name="id_gender")
	WebElement genero;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement selectDay;
	
	@FindBy(id="months")
	WebElement selectMonth;
	
	@FindBy(id="years")
	WebElement selectYear;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement province;
	
	@FindBy(id="id_country")
	WebElement selectCountry;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="postcode")
	WebElement usrZipCode;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/h1")
	WebElement tituloForm;
		
	@FindBy(linkText="Sign out")
	WebElement signOut;
	
	@FindBy(xpath="//span[contains(.,'Register')]")
	WebElement btnRegister;
	
	public paginaAutomationPractice(WebDriver driver) {
		 this.driver = driver;
		//Constructor 
		 //Inicializa los elementos con una espera implicita
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver, 20), this);
	}
	
	public void typeEmail(String usrEmail) {
		email.sendKeys(usrEmail);
		
	}

	public void clickBtn() {
		btnSubmit.click();
		
	}
	
	
	public String getTextTitleForm(){
    	return tituloForm.getText();
    	
    }
	

	public void setGender() {
		genero.click();
	}
	
	public void setUsrName(String keysToSend) {
		
		firstName.sendKeys(keysToSend);
	}
	
	public void setLastName(String lastN) {
		
		lastName.sendKeys(lastN);
    }
	
	public void setPwd(String usrPwd) {
		password.sendKeys(usrPwd);
	}
	
	public void setMonth(String month) {
		Select selectMonth = new Select(driver.findElement(By.id("months")));
		selectMonth.selectByValue(month);
	}
	
	public void setDay(String day) {
		Select selectDay = new Select(driver.findElement(By.id("days")));
		selectDay.selectByValue(day);
	}
	
	public void setYear(String year) {
		Select selectYear = new Select(driver.findElement(By.id("years")));
		selectYear.selectByValue(year);
	}
	public void setCompany(String com) {
		company.sendKeys(com);
	}
	
	public void setAddress(String addr) {
		address1.sendKeys(addr);
	}
	
	public void setCity(String cstCity) {
		city.sendKeys(cstCity);
	}
	
	public void selectState(String state) {
		Select province = new Select(driver.findElement(By.id("id_state")));
		province.selectByValue(state);
	}
	
	public void setCountry(Integer cntry) {
		Select selectCountry = new Select(driver.findElement(By.id("id_country")));
		selectCountry.selectByIndex(cntry);
	}
	
	public void setMobilePhone(String number) {
		mobile.sendKeys(number);		
	}
	
	public void enterZipcode(String zip) {
		usrZipCode.sendKeys(zip);
	}
	
	public void clickRegistration() {	
		btnRegister.click();
	}
	
	public void clickSignOut() {
		signOut.click();
	}
	
	
}