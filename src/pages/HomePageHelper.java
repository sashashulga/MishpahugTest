package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePageHelper extends PageBase {


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(By.id("idsignin"),20);
        /*waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),60);*/
        waitUntilAllElementsPresent(By
                .xpath("//div[@class = 'itemEventInsert']"), 40);
    }

    public Boolean correctPageIsLoaded(){
        WebElement listEvent
                = driver.findElement(By.id("idtitletypesearchevents"));
        return listEvent.getText().equals("List events");
    }


    public void filterEventsByHolidayShabbat() {
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(By.name("selectholidays"),30);
        /*waitUntilAllElementsVisible(driver
                .findElements(By.xpath("//select[@name = 'selectholidays']/option")),30);*/
        waitUntilAllElementsPresent(By.xpath("//select[@name = 'selectholidays']/option"),30);
        // --- get select-element (filter by holiday)
        WebElement holidaysFilter = driver
                .findElement(By.name("selectholidays"));
        // --- verify states clear button ----
        System.out.println("is displayed: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isEnabled());

        // ------ choose filter "shabbat" ------
        Select selector;
        try{
            selector = new Select(holidaysFilter);
            selector.selectByValue("Shabbat");
        }catch(Exception e){
            try {
                Thread.sleep(20000);
                System.out.println("Exception: " + e);
                selector = new Select(driver
                        .findElement(By.name("selectholidays")));
                selector.selectByValue("Shabbat");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }


        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtnclearfilter']"),20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);


    }

    public Boolean allEventsBelongToHolidayShabbat() {
        // ------ get all holidays values for all chosen by filter "Shabbat" events
        List<WebElement> listHolidays = driver.findElements(By.xpath("//div[@class = 'holidayItemEvents']"));

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidays.size(); i++){
            if (listHolidays.get(i).getText().equals("Shabbat")) counter++;
        }


        return counter == listHolidays.size();
    }
}
