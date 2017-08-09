package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageExisteElemento {

    public boolean existe(WebDriver driver, By elemento){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(elemento));

        return driver.findElement(elemento).isDisplayed();
    }

    public void esperar(int seg){
        seg *= 1000;
        try{
            Thread.currentThread().sleep(seg);
        }catch (InterruptedException ex){

        }
    }

    public void esperarPagina(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
