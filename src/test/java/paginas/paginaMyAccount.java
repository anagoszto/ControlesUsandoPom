package paginas;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class paginaMyAccount {
	
	WebDriver driver;
	
	@FindBy(css="#search_query_top")
	WebElement search;
	
	@FindBy(id="email")
	WebElement regUsrEmail;
	
	@FindBy(id="passwd")
	WebElement regUsrPwd;
	
	@FindBy(xpath="//button[@id='SubmitLogin']/span")
	WebElement btnLogin;
	
	@FindBy(id="search_query_top")
	WebElement srchFld;
	
	@FindBy(name="submit_search")
	WebElement srchBtn;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSignout;
	
	@FindBy(id="selectProductSort")
	WebElement selectCat;
	
	@FindBy(linkText="TOP SELLERS")
	WebElement lnkToSel;
	
	@FindBy(xpath="//div[@id='center_column']//h1")
	WebElement pageTitle;
	
	public paginaMyAccount(WebDriver driver) {
		 this.driver = driver;
		 
		 //Inicializa los elementos con una espera implicita
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver, 20), this);
	}
	
	public void typeEmail(String usrEmail) {
		regUsrEmail.sendKeys(usrEmail);
		
	}
	
	public void typePassword(String usrEmail) {
		regUsrPwd.sendKeys(usrEmail);
		
	}
	
	public void submitButton() {
		btnLogin.click();
		
	}
	
	public void clickSignOut(){
		lnkSignout.click();
	}
	
	public void enterSearch(String srchStr) {
		srchFld.sendKeys(srchStr);
	}
	
	public void clickSrchBtn() {
		srchBtn.click();
	}
	
	public void selectCat(String str) {
		Select selectElem = new Select(driver.findElement(By.id("selectProductSort")));
		selectElem.selectByVisibleText(str);		
	}
	
	public void clickTopSellers() {
		lnkToSel.click();
	}
	
	public String getPageTitle(){
		return pageTitle.getText();
	}
	
}