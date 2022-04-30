package pruebas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;
import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT25Mar2022\\Drivers\\chromedriver.exe";
	String documentPath = "..\\EducacionIT25Mar2022\\Evidencias\\DataProviderTest.docx";
	String imagePath = "..\\EducacionIT25Mar2022\\Evidencias\\img.jpg";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws InvalidFormatException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url); // abrir el navegador en la página especificada
		driver.manage().window().maximize(); // maximizar la ventana del navegador
		
		CapturaEvidencia.escribirTituloEnDocumento(documentPath, "Documento de Evidencia de Pruebas - Ejercicio Data Provider", 18);
	}
	
	@Test(dataProvider="Datos Login desde Excel")
	public void login(String email, String password) throws InvalidFormatException, IOException, InterruptedException {
		// En la página principal, hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath, documentPath, "1_Pagina_Inicial - Email: " + email);
		
		// Ingresar el correo y la contraseña
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath, documentPath, "2_Credenciales_Usadas");
		
		// Hacer clic en el botón Sign In
		login.hacerClicEnSignIn();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath, documentPath, "3_Resultado_Obtenido");
		
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
	
		login.hacerClicEnSignOut();
	}
	
	@DataProvider(name="Datos Login desde Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT25Mar2022\\Datos\\datos_Login.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[4][2];
		
		datos[0][0] = "micorreo0.5120054516256567@correo.com";
		datos[0][1] = "1q2w3e4r5t";
		
		datos[1][0] = "maria@micorreo.com";
		datos[1][1] = "3e4r5t6y";
		
		datos[2][0] = "pedro@micorreo.com";
		datos[2][1] = "5t454e3w";
		
		datos[3][0] = "ana@micorreo.com";
		datos[3][1] = "23r33e45";
		
		return datos;
	}
}
