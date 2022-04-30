package Edit.EducacionIT25Mar2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	// Atributos: Variables de uso general
	String url = "http://automationpractice.com";
	String chromePath = "..\\EducacionIT25Mar2022\\Drivers\\chromedriver.exe";
	String firefoxPath = "..\\EducacionIT25Mar2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	// Métodos: Rutinas para automatizar en Chrome y Firefox
	@Test
	public void buscarPalabraChrome() {
		// Paso 1: Indicar dónde está el driver.exe
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		// Paso 2: Abrir la página que queremos automatizar
		driver = new ChromeDriver();
		driver.get(url);
		
		// Maximizar la ventana
		driver.manage().window().maximize();
		
		// Borrar las cookies
		driver.manage().deleteAllCookies();
		
		// Paso 3: Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
				
		// Paso 4: Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simulamos que presionamos la tecla ENTER
		
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("Título de la página: " + driver.getTitle());
		
		// Paso 5: Cerrar el navegador
		
	}
	
	@Test
	public void buscarPalabraFirefox() {
		// Paso 1: Indicar dónde está el driver.exe
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		
		// Paso 2: Abrir la página que queremos automatizar
		driver = new FirefoxDriver();
		driver.get(url);
		
		// Paso 3: Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
				
		// Paso 4: Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simulamos que presionamos la tecla ENTER
		
		// Paso 5: Cerrar el navegador
		
	}
}
