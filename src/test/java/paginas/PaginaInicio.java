package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos que se van a utilizar de la página web
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		// Inicializar los elementos de la página
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer sobre los elementos web
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirValorABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void presionarEnter() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
