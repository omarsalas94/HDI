package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PageLogin{
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
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void escribirUsuario() {
        driver.findElement(idUsuario).sendKeys(usuario);
    }

    public void escribirContrasena() {
        driver.findElement(idContrasena).sendKeys(contrasena);
    }

    public void clicIngresar() {
        driver.findElement(idIngrear).click();
    }
}
