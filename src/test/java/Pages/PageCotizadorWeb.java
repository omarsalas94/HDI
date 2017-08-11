package Pages;

import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.dnd.DragGestureEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PageCotizadorWeb extends PageAuxiliar {
    WebDriver driver;

    //By's
    private By idComboBox = By.id("1select2ss");//Cotizador uno autos
    private By cssBuscar = By.cssSelector(".select2-search");
    private By idCodigoPostal = By.id("txtCodigoPostal");//Direccion del contratante
    private By idCaracteristicasVehiculo = By.id("btnTipoVehiculoGlm");//Caracteristicas del vehiculo
    private By idTarificar = By.id("btnTarificar");

    //Array's datos a comparar
    private ArrayList<String> datos1, datos2;

    //By's datos1
    By idDanosMateriales = By.id("spanSA_233");
    By idRoboTotal = By.id("spanSA_236");
    By xpathResposabilidadCivil = By.xpath("//label[@id='comboSA_253']/select");
    By idAsistenciaJuridica = By.id("spanSA_242");
    By xpathGastosMedicosOcupantes = By.xpath("//label[@id='comboSA_239']/select");
    By xpatResposabilidadCivilMuerte = By.xpath("//label[@id='comboSA_366']/select");
    By idResposabilidadCivilFamiliar = By.id("spanSA_267");
    By idAsistenciaViajes = By.id("spanSA_249");
    By idAsistenciaMedica = By.id("spanSA_269");
    //By's datos2
    By xpathDanosMateriales2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[2]/td[2]");
    By xpathRoboTotal2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[3]/td[2]");
    By xpathResposabilidadCivil2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[5]/td[2]");
    By xpathAsistenciaJuridica2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[7]/td[2]");
    By xpathGastosMedicosOcupantes2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[4]/td[2]");
    By xpatResposabilidadCivilMuerte2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[6]/td[2]");
    By xpathResposabilidadCivilFamiliar2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[8]/td[2]");
    By xpathAsistenciaViajes2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[9]/td[2]");
    By xpathAsistenciaMedica2 = By.xpath("//table[@id='TablaDetalles2']/tbody/tr[10]/td[2]");


    public PageCotizadorWeb(WebDriver driver) {
        this.driver = driver;
    }

    public void clicComboBox() {
        esperar(10);
        if(isVisible(driver, idComboBox)){
            driver.findElement(idComboBox).click();
        }
    }

    public void buscarOficina(String oficina) {
        if(isVisible(driver, cssBuscar)){
            driver.findElement(cssBuscar).sendKeys(oficina, Keys.ENTER);
        }
    }

    public void ingresarCP(String cp) {
        esperar(6);
        if(isVisible(driver, idCodigoPostal)){
            driver.findElement(idCodigoPostal).sendKeys(cp, Keys.ENTER);
        }
    }

    public void seleccionarVehiculo(String tipo, String marca, String modelo, String submarca, String version){
        esperar(2); driver.findElement(idCaracteristicasVehiculo).click();

        esperar(2); driver.findElement(By.linkText(tipo)).click();//tipo
        esperar(3); driver.findElement(By.linkText(marca)).click();//marca
        esperar(2); driver.findElement(By.linkText(modelo)).click();//modelo
        esperar(2); driver.findElement(By.linkText(submarca)).click();//submarca
        esperar(2); driver.findElement(By.linkText(version)).click();//version/transmicion

        esperar(5);
    }

    public void datos1(){
        datos1 = new ArrayList<String>();

       if(isVisible(driver, idDanosMateriales)){
           //Datos de la primer cobertura
           datos1.add(driver.findElement(idDanosMateriales).getText());//Daños materiales 0
           String sinEspacio[] = driver.findElement(idRoboTotal).getText().split(" ");
           datos1.add(sinEspacio[0]);//RoboTotal 1
           datos1.add(new Select(driver.findElement(xpathResposabilidadCivil)).getFirstSelectedOption().getText());//Responsabilidad civil 2
           datos1.add(driver.findElement(idAsistenciaJuridica).getText());//asistencia juridica 3
           datos1.add(new Select(driver.findElement(xpathGastosMedicosOcupantes)).getFirstSelectedOption().getText());//Gastos medicos por ocupante 4
           datos1.add(new Select(driver.findElement(xpatResposabilidadCivilMuerte)).getFirstSelectedOption().getText());//Responsabilidad civil por muerte 5
           datos1.add(driver.findElement(idResposabilidadCivilFamiliar).getText());//Responsabilidad civil familiar 6
           datos1.add(driver.findElement(idAsistenciaViajes).getText());//asistencia en viajes 7
           datos1.add(driver.findElement(idAsistenciaMedica).getText());//assitencia medica 8
       }
    }

    public void clicTarificar(){
        if (isVisible(driver, idTarificar)){
            driver.findElement(idTarificar).click();//Tarificar
        }
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        esperar(5);
    }


    public void datos2(){
        datos2 = new ArrayList<String>();

        if(isVisible(driver, xpathDanosMateriales2)){
            //Datos de la segunda cobertura
            datos2.add(driver.findElement(xpathDanosMateriales2).getText());
            String sinEspacio2[] = driver.findElement(xpathRoboTotal2).getText().split("\\(");
            datos2.add(sinEspacio2[0]);
            datos2.add(driver.findElement(xpathResposabilidadCivil2).getText());
            datos2.add(driver.findElement(xpathAsistenciaJuridica2).getText());
            datos2.add(driver.findElement(xpathGastosMedicosOcupantes2).getText());
            datos2.add(driver.findElement(xpatResposabilidadCivilMuerte2).getText());
            datos2.add(driver.findElement(xpathResposabilidadCivilFamiliar2).getText());
            datos2.add(driver.findElement(xpathAsistenciaViajes2).getText());
            datos2.add(driver.findElement(xpathAsistenciaMedica2).getText());
        }
    }

    public ArrayList<String> getDatos1() {
        return datos1;
    }

    public ArrayList<String> getDatos2() {
        return datos2;
    }
}
