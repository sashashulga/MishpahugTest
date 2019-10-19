package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBase {
    WebDriver driver;
    public static final String LOGIN = "sashasasha";
    public static final String PASSWORD = "Sasha111";

    PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilElementIsVisible(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsPresent(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAllElementsVisible(List<WebElement> listOptions, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfAllElements(listOptions));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAllElementsPresent(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
