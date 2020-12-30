package codigo;

import org.testng.*;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import paginas.paginaAutomationPractice;

import java.util.Random;



public class codigoAutomationPractice {
	//generate email random
	Random rand = new Random();
	int n = rand.nextInt(500);
	
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	String url2 = "http://automationpractice.com/index.php?controller=my-account";
	String imagenes = "..\\EducacionIt\\Evidencias\\Test.png";
	WebDriver driver;
	
	String driverPath = "..\\EducacionIt1\\Drivers\\chromedriver.exe";
	String numCadena= String.valueOf(n);
	String usrEmail ="annagosze"+String.valueOf(n) +"@gmail.com";
	String usrName ="agoszto";
	String lastName = "gonzales";
	String pssWd = "12345678";
    String month = "11";
    String day = "9";
    String year = "1970";
    String suCp = "AluAr";
    String usrAddr = "Alumine 1234";
    String usrCity = "Madryn";
    String zip = "12344";
    String usrState = "32";
    Integer usrCountry = 1;
    String usrMobile = "1546273737";
    
	    @BeforeSuite
		public void beforeSuite() {		
			System.out.println("Before Suite");
			System.out.println(numCadena);
			
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
		public void fillCompleteForm() throws IOException {		
			paginaAutomationPractice automa = new paginaAutomationPractice(driver);
			Assert.assertEquals(driver.getCurrentUrl(),url);
			automa.typeEmail(usrEmail);
			automa.clickBtn();
			Assert.assertEquals(driver.getCurrentUrl(),url);
			automa.setGender();
			automa.setUsrName(usrName);
			automa.setLastName(lastName);
			automa.setPwd(pssWd);
			automa.setMonth(month);
			automa.setDay(day);
			automa.setYear(year);
			automa.setCompany(suCp);
			automa.setAddress(usrAddr);
			automa.setCity(usrCity);
			automa.selectState(usrState);
			automa.setCountry(usrCountry);
			automa.setMobilePhone(usrMobile);
			automa.enterZipcode(zip);
			automa.clickRegistration();
			Assert.assertNotEquals(driver.getCurrentUrl(),url );
			Assert.assertEquals(driver.getCurrentUrl(),url2 );
			String titulo = automa.getTextTitleForm();
			Assert.assertEquals(titulo, "MY ACCOUNT");
			File screen2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen2, new File("C:\\Users\\Luisa\\eclipse-workspace\\ControlesUsandoPOM\\Evidencias\\TestCreateUser"+"usrEmail"+".png"));
			automa.clickSignOut();
			
						
	    }
		
		@Test(priority = 1)
		public void crearCuentaInvalida() throws IOException {
			paginaAutomationPractice automa = new paginaAutomationPractice(driver);
			automa.typeEmail("dasdadas");
			automa.clickBtn();
			String titulo = automa.getTextTitleForm();

			Assert.assertEquals(titulo, "AUTHENTICATION");

			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("C:\\Users\\Luisa\\eclipse-workspace\\ControlesUsandoPOM\\Evidencias\\TestLoginInvalido.png"));

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
