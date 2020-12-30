package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class paginaSeleniumEasy {
	
	WebDriver driver;
	
	@FindBy(css="#isAgeSelected")
	WebElement chkIsAgeSelected;
	
	@FindBy(xpath="//body/div[@id='easycont']/div[1]/div[2]/div[2]/div[2]/div[1]/label[1]/input[1]")
    WebElement checkOne;
	
	@FindBy(xpath="//body/div[@id='easycont']/div[1]/div[2]/div[2]/div[2]/div[2]/label[1]/input[1]")
	 WebElement checkTwo;
	
	@FindBy(xpath="//body/div[@id='easycont']/div[1]/div[2]/div[2]/div[2]/div[3]/label[1]/input[1]")
	 WebElement checkThree;
	 
	@FindBy(xpath="//body/div[@id='easycont']/div[1]/div[2]/div[2]/div[2]/div[4]/label[1]/input[1]")
	 WebElement checkFour;
	
	@FindBy(css="#check1")
	WebElement btn;
	
	
	public paginaSeleniumEasy(WebDriver driver) {
		 this.driver = driver;
		 
		 //Inicializa los elementos con una espera implicita
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver, 20), this);
	}	
	
	public void clickCheckBoxAge() {
		chkIsAgeSelected.click();
		
	}
	public void clickCheckBoxOne() {
		checkOne.click();
		
	}
	public void clickCheckBoxTwo() {
		checkTwo.click();
		
	}
	public void clickCheckBoxThree() {
		checkThree.click();
		
	}
	public void clickCheckBoxFour() {
		checkFour.click();
		
	}
	public void clickSubmitBtn() {
		btn.click();
	}
}
