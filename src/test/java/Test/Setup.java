package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
    WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/Resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://autos.staging.hdi.com.mx/Paginas/Login/InicioSesion.aspx?ReturnUrl=%2fPaginas%2fDefault%2fInicio.aspx%3fCodigoReferente%3dLogin&CodigoReferente=Login");
    }

    public void cerrarNavegador(){
        driver.quit();
    }
}
