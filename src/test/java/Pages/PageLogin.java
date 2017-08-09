package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends PageExisteElemento{
    private WebDriver driver;
    private String usuario;
    private String contrasena;

    //By
    By idUsuario = By.id("UserName");
    By idContrasena = By.id("Password");

    public PageLogin(WebDriver driver, String usuario, String contrasena) {
        this.driver = driver;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public void escribirUsuario(){
        if(isExist(driver, idUsuario)){
            driver.findElement(idUsuario).sendKeys(usuario);
        }
    }

    public void escribirContrasena(){
        if(isExist(driver, idContrasena)) {
            driver.findElement(idContrasena).sendKeys(contrasena);
        }
    }
}
