package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAuxiliar {
    public void esperar(int seg){
        seg *= 1000;
        try{
            Thread.currentThread().sleep(seg);
        }catch (InterruptedException ex){

        }
    }

    public boolean isVisible(WebDriver driver, By elemento){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(elemento));

        return driver.findElement(elemento).isDisplayed();
    }
}
