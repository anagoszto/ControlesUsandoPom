package codigo;

import org.testng.*;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import paginas.paginaRadioButton;

public class codigoRadioButton {
	//SeleniumEasy.com
	String url = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
	
	WebDriver driver;
	String driverPath = "..\\EducacionIt1\\Drivers\\chromedriver.exe";
	
	@BeforeSuite
	public void beforeSuite() {		
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void antes() {
		System.out.println("Inicio Prueba");
	}
	
	@BeforeMethod
	public void setup() {		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	/*
	@Test
	public void verifyRadioButtonPage() {		
		paginaRadioButton rbutton = new paginaRadioButton(driver);
		Assert.assertEquals(driver.getCurrentUrl(),url);
		
		System.out.println("pagina de inicio");
		
    }*/
	
	@Test
	public void verifyRadioButton() {
		paginaRadioButton rbutton = new paginaRadioButton(driver);
		rbutton.clickRadioButtonTwo();
		rbutton.clickRadioButtonOne();
		//WebDriverWait wait = new WebDriverWait(driver, 10);	
		rbutton.clickButton();
		Assert.assertEquals(driver.getCurrentUrl(),url);
	
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
