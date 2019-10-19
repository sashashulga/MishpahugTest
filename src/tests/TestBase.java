package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class TestBase {
    public static final String LOGIN = "sashasasha";
    public static final String PASSWORD = "Sasha111";
    WebDriver driver;

    @BeforeMethod
    public void initWebDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        waitUntilElementIsClickable(By.id("closedIntro"),30);
        driver.findElement(By.id("closedIntro")).click();
        //Thread.sleep(5000);
       // waitUntilElementIsClickable(By.id("idsignin"),20);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
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

    public void waitUntilElementIsClickable(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
