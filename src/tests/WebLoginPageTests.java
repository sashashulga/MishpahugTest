package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebLoginPageHelper;

public class WebLoginPageTests extends TestBase{

    WebLoginPageHelper loginPage;
    @BeforeMethod
    public void initTests() throws InterruptedException {
        loginPage = new WebLoginPageHelper(driver);
        //Thread.sleep(6000);
        /*WebElement loginIcon  = driver.findElement(By.id("idsignin"));
        loginIcon.click();*/
        //Thread.sleep(3000);
        //waitUntilElementIsClickable(By.id("signinrequest"),20);
        loginPage.loginPageOpen();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void webLoginPositive() throws InterruptedException {

     WebElement loginInput = driver.findElement(By.id("logininput"));
     WebElement passwordInput = driver.findElement(By.id("passwordinput"));
     loginInput.click();
     loginInput.sendKeys("marinaA");
     passwordInput.click();
     passwordInput.sendKeys("marina1!");
     driver.findElement(By.id("signinrequest")).click();
     //Thread.sleep(10000);
        waitUntilElementIsClickable(By.id("profile"),20);
     WebElement profileIcon = driver.findElement(By.id("profile"));
     Assert.assertTrue(profileIcon.getAttribute("title").contains("marinaA"));

 }

 @Test
 public void webNegativeLogin() throws InterruptedException {

     System.out.println("We are on the Login window: " + driver
             .findElement(By.id("clickreg")).getText().contains("registration"));

     //---- Enter incorrect login/psw ---
     driver.findElement(By.id("logininput")).sendKeys(LOGIN);
     driver.findElement(By.id("passwordinput")).sendKeys("123");
     WebElement signInButton = driver.findElement(By.id("signinrequest"));
     signInButton.click();
     //Thread.sleep(3000);
     waitUntilElementIsVisible(By.id("wrongloginorpassword"),10);

     //--- Error message 'wrong authorization is displayed' ----

     Assert.assertTrue(driver
             .findElement(By.id("wrongloginorpassword")).getText().contains("Wrong Authorization"));

     //--- Close login window ---
     driver.findElement(By.id("closedsignin")).click();
     //Thread.sleep(3000);
     waitUntilElementIsVisible(By.id("idtitletypesearchevents"),20);

     // ---- Usr is on the HomePage for the unauthorized user


     Assert.assertEquals(driver
             .findElement(By.id("idsignin")).getText(), "Login","Name of the loginButton is not equal to 'Login'");

 }
}
