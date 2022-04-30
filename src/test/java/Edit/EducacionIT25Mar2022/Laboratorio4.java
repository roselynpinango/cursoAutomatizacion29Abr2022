package Edit.EducacionIT25Mar2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio4 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT25Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		/**
		 * incognito 
		 * headless
		 * start-maximizied
		 * disable-extensions
		 * disable-popup-blocking
		 */
		
		driver = new ChromeDriver(options);
		driver.navigate().to(url); // es igual driver.get(url);
		driver.manage().window().maximize();
		
		// Paso 1: Ingresar el correo y hacer clic en el botón Create an Account
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("micorreo" + Math.random() + "@correo.com");
		
		driver.findElement(By.id("SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("id_gender")));
		
		// Paso 2: Completar el formulario y hacer clic en el botón Register
		
		// Radio Button - Title
		driver.findElement(By.name("id_gender")).click();
		
		// First Name
		WebElement txtFirstname = driver.findElement(By.name("customer_firstname"));
		txtFirstname.sendKeys("Patricio");
		
		// Last Name
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Perez");
		
		// Password
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1q2w3e4r5t");
		
		// Day
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("1");
		
		// Month
		Select months = new Select(driver.findElement(By.name("months")));
		months.selectByVisibleText("February ");
		
		// Year
		Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByIndex(20);
		
		// Newsletter
		driver.findElement(By.cssSelector("#newsletter")).click();
		
		// Special Offers
		driver.findElement(By.name("optin")).click();
		
		// Address
		driver.findElement(By.id("address1")).sendKeys("Mi Calle 1234 5B");
		
		// City
		driver.findElement(By.cssSelector("#city")).sendKeys("Tucuman");
		
		// State
		Select states = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		states.selectByVisibleText("California");
		
		// Zip Code
		driver.findElement(By.cssSelector("#postcode")).sendKeys("90210");
		
		// Country
		Select countries = new Select(driver.findElement(By.id("id_country")));
		countries.selectByValue("21");
		
		// Mobile phone
		driver.findElement(By.name("phone_mobile")).sendKeys("9456576855");
		
		// Alias
		WebElement txtAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		txtAlias.clear();
		txtAlias.sendKeys("Mi Casa");
		
		// Botón Register
		driver.findElement(By.id("submitAccount")).click();
	}
	
}
