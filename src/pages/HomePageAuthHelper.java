package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAuthHelper extends PageBase {
    public HomePageAuthHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(By.id("profile"),30);
    }

    public Boolean correctPageIsLoaded(){
        WebElement profileIcon = driver.findElement(By.id("profile"));
        return profileIcon.getAttribute("title").contains(LOGIN);
    }
}
