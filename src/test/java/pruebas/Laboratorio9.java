package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9 {
	String url = "https://demo.guru99.com/test/table.html";
	String driverPath = "..\\EducacionIT25Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void leerValorTabla() {
		WebElement valor = driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		System.out.println("Cambio para probar GitHub y GIT");
		System.out.println("Valor de Fila 4 - Columna 3: " + valor.getText());
	}
}
