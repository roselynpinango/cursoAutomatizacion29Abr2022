package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio7 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT25Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url); // abrir el navegador en la página especificada
		driver.manage().window().maximize(); // maximizar la ventana del navegador
	}
	
	@Test
	public void login() {
		// En la página principal, hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		// Ingresar el correo y la contraseña
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("micorreo0.5120054516256567@correo.com");
		login.escribirPassword("1q2w3e4r5t");
		
		// Hacer clic en el botón Sign In
		login.hacerClicEnSignIn();
		
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirValorABuscar("dress");
		inicio.presionarEnter();
	}
}
