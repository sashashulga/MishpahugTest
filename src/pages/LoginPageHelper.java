package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(By.id("signinrequest"),20);
    }

    public void openLoginPage(){
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
    }

    public Boolean correctPageIsLoaded(){
    return driver
            .findElement(By.id("clickreg")).getText().contains("registration");
    }

    public void loginToTheSystem(String login, String psw){
        //---- Enter incorrect login/psw ---
        driver.findElement(By.id("logininput")).sendKeys(login);
        driver.findElement(By.id("passwordinput")).sendKeys(psw);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
    }

    public boolean loginToTheSystemIncorrect() {
        waitUntilElementIsVisible(By.id("wrongloginorpassword"),10);
        return  driver.findElement(By.id("wrongloginorpassword")).getText()
                .contains("Wrong Authorization");
    }

    public void closeLoginWindowByX() {
        driver.findElement(By.id("closedsignin")).click();
    }
}
