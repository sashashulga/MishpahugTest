package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageHelper;

import java.util.List;


public class HomePageTests extends TestBase {
    HomePageHelper homePage;

    @BeforeMethod
    public void initTests(){
        homePage = new HomePageHelper(driver);
        homePage.waitUntilPageIsLoaded();

    }

    @Test
    public void homePageVerificationTest()  {

        Assert.assertTrue(homePage.correctPageIsLoaded(),
                "Name of the listEvent element is not 'List events'");
    }

    @Test
    public void singleFilterHolidaysByShabbat()  {
        homePage.filterEventsByHolidayShabbat();
        Assert.assertTrue(homePage.allEventsBelongToHolidayShabbat());
    }



}
