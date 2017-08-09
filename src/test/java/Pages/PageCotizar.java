package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCotizar extends PageExisteElemento{
    WebDriver driver;

    //elementos
    By idCotizar = By.id("divCotizar");

    public PageCotizar(WebDriver driver){
        this.driver = driver;
        esperarPagina(driver);
    }

    public void clicCotizar(){
        if(existe(driver, idCotizar)){
            esperar(1);
            driver.findElement(idCotizar).click();
        }
    }
}
