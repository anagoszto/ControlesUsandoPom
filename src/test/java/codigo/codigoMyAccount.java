package codigo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import paginas.paginaMyAccount;

public class codigoMyAccount {

	
	String url2 = "http://automationpractice.com/index.php?controller=my-account";
	String topSellers = "http://automationpractice.com/index.php?controller=best-sales";
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\ControlesUsandoPOM\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	String usrEmail ="annagosze02@gmail.com";
	String pssWd = "12345678";
	String srchQuery = "dress";
	String cat = "Price: Lowest first";
	
	
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
	public void loginExistentUsr() {		
		paginaMyAccount myAcc = new paginaMyAccount(driver);
		Assert.assertEquals(driver.getCurrentUrl(),url);
		myAcc.typeEmail(usrEmail);
		myAcc.typePassword(pssWd);
		myAcc.submitButton();
		String Title = myAcc.getPageTitle();
		Assert.assertEquals(Title, "MY ACCOUNT");
		
	}
	
	@Test
	public void fillCompleteForm() {	
	
		paginaMyAccount myAcc = new paginaMyAccount(driver);
		Assert.assertEquals(driver.getCurrentUrl(),url);
		myAcc.typeEmail(usrEmail);
		myAcc.typePassword(pssWd);
		myAcc.submitButton();
		Assert.assertEquals(driver.getCurrentUrl(),url2);
		myAcc.enterSearch(srchQuery);
		myAcc.clickSrchBtn();
		myAcc.selectCat("Price: Lowest first");
		myAcc.clickTopSellers();
		Assert.assertEquals(driver.getCurrentUrl(),topSellers);
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
