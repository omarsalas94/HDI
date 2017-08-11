package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PageCotizar extends PageAuxiliar {
    WebDriver driver;

    //elementos
    By idCotizar = By.id("divCotizar");

    public PageCotizar(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        esperar(4);
    }

    public void clicCotizar() {
        if(isVisible(driver, idCotizar)){
            driver.findElement(idCotizar).click();
        }
    }
}
