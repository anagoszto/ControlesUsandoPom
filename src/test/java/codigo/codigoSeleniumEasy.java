package codigo;

import org.testng.*;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.paginaSeleniumEasy;



public class codigoSeleniumEasy {
	String url = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
	
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
	
	@Test
	public void verifySeleniumEasyPage() {		
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		Assert.assertEquals(driver.getCurrentUrl(),url);
		
		System.out.println("pagina de inicio");
		
    }
	
	@Test
	public void verifyCheckOne() {		
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		selenium.clickCheckBoxOne();
		System.out.println("pagina de inicio");
		
    }
	

	@Test
	public void verifyCheckBoxTwo() {		
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		selenium.clickCheckBoxTwo();
		
    }

	@Test
	public void verifyCheckBoxThree() {		
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		selenium.clickCheckBoxThree();
		
    }
	

	@Test
	public void verifyCheckBoxFour() {		
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		selenium.clickCheckBoxFour();
		
    }
	
	@Test
	public void SendDataClick() {
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		selenium.clickSubmitBtn();
	}
	
	@Test
	public void checkAllCheckboxes() {
		paginaSeleniumEasy selenium = new paginaSeleniumEasy(driver);
		selenium.clickCheckBoxOne();
		selenium.clickCheckBoxTwo();
		selenium.clickCheckBoxThree();
		selenium.clickCheckBoxFour();
		selenium.clickSubmitBtn();
		Assert.assertEquals(driver.getCurrentUrl(),url);
	}
	
	
	@AfterMethod
	public void cerrarBrowser() {
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



