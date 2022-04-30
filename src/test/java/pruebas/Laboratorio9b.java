package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Laboratorio9b {
	String url = "https://www.selenium.dev/";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp( ) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void test() {
		System.out.println("Prueba sin el chromedriver.exe!!");
	}
}
