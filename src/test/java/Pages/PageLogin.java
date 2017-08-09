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
    By idIngrear = By.id("Login");

    public PageLogin(WebDriver driver, String usuario, String contrasena) {
        this.driver = driver;
        this.usuario = usuario;
        this.contrasena = contrasena;
        esperarPagina(driver);
    }

    public void escribirUsuario(){
        if(existe(driver, idUsuario)){
            driver.findElement(idUsuario).sendKeys(usuario);
        }
    }

    public void escribirContrasena(){
        if(existe(driver, idContrasena)) {
            driver.findElement(idContrasena).sendKeys(contrasena);
        }
    }

    public void clicIngresar(){
        if(existe(driver, idIngrear)){
            driver.findElement(idIngrear).click();
        }
    }
}
