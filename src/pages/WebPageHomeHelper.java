package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WebPageHomeHelper extends PageBase{

    public WebPageHomeHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsloaded(){
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Login')]"),30);
    }

    public Boolean correctPageIsLoaded(){
        WebElement eventList = driver.findElement(By.id("idtitletypesearchevents"));
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        return eventList.getText().equals("List events")&&loginIcon.isDisplayed();
    }

    public void filterByHolidayShabbat() {
        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(By.name("selectholidays"),30);
        waitUntilAllElementsVisible(driver
                .findElements(By.xpath("//select[@name = 'selectholidays']/option")),30);
        // --- get select-element (filter by holiday)
        WebElement holidaysFilter = driver
                .findElement(By.name("selectholidays"));
        // --- verify states clear button ----
        System.out.println("is displayed: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isEnabled());

        // ------ choose filter "shabbat" ------
        Select selector = new Select(holidaysFilter);
        selector.selectByValue("Shabbat");
        //Thread.sleep(10000);

        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtnclearfilter']"),20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);
    }

    public boolean eventsListBelongToShabbat() {

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
