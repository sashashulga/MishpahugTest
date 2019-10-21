package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.ProfilePageHelper;

public class ProfilePageTests extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;
    ProfilePageHelper profilePage;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);
        profilePage = new ProfilePageHelper(driver);

        homePage.waitUntilPageIsLoaded();
        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTheSystem(LOGIN,PASSWORD);
        homePageAuth.waitUntilPageIsLoaded();
        profilePage.GoToProfilePage();
        homePageAuth.waitUntilPageIsLoaded();
    }

    @Test
    public void lastNameOfFamilyChanging() throws InterruptedException {
        profilePage.OpenEditMode();
        profilePage.EnterNewLastname();
        profilePage.SaveProfile();
        profilePage.GoTofamilyPage();
        profilePage.NewLastNameChange();
                Assert.assertTrue(driver.findElement(By.linkText("Shulga")).isDisplayed(),
                "There is no an element which can be find by linkText('Shulga')");

    }
    @Test
    public void profileAndFamilyComparing() throws InterruptedException {
        profilePage.profileAndFamilyPageComparing();
    }

}
