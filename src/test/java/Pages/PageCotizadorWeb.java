package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageCotizadorWeb extends PageExisteElemento{
    WebDriver driver;

    //Cotizador uno autos
    By idComboBox = By.id("1select2ss");
    By cssOpcionComboBox = By.cssSelector(".select2-result");

    //Direccion del contratante
    By idCodigoPostal = By.id("txtCodigoPostal");

    //Caracteristicas del vehiculo
    By idCaracteristicasVehiculo = By.id("btnTipoVehiculoGlm");

    public PageCotizadorWeb(WebDriver driver){
        this.driver = driver;
        esperarPagina(driver);
    }

    public void clicComboBox(){
        if(existe(driver, idComboBox)){
            driver.findElement(idComboBox).click();
        }
    }

    public void seleccionaComboBox(String oficina){
        if(existe(driver, cssOpcionComboBox)){
            List<WebElement> elements = driver.findElements(cssOpcionComboBox);
            for (int i = 0; i < elements.size(); i++) {
                if(elements.get(i).getText().equals("oficina")){
                    elements.get(i).click();
                }
            }
        }
        esperar(10);
    }


}
