package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//import org.testng.Assert;
//import org.testng.annotations.Test;

public class paginaRadioButton {
	
	WebDriver driver;

	@FindBy(xpath="//input")
	WebElement opcion1;
	
	@FindBy(xpath="//label[2]/input")
	WebElement opcion2;

	
	@FindBy(id="buttoncheck")
	WebElement button;
	
	public paginaRadioButton(WebDriver driver) {
		 this.driver = driver;
		 
		 //Inicializa los elementos con una espera implicita
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver, 20), this);
	}
	
	public void clickRadioButtonOne() {
		opcion1.click();
		
	}

	public void clickRadioButtonTwo() {
		opcion2.click();
		
	}
	
	public void clickButton() {
		button.click();
		
	}
	
	
}