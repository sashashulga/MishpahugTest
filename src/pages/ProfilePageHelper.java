package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProfilePageHelper extends PageBase {
    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public void GoToProfilePage() throws InterruptedException {
        driver.findElement(By.id("profile")).click();
        Thread.sleep(5000);
    }

    public void OpenEditMode() throws InterruptedException {
        driver.findElement(By.id("idbtneditprofile")).click();
        Thread.sleep(5000);
    }

    public void EnterNewLastname() throws InterruptedException {
        WebElement lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Shulga1");
        Thread.sleep(5000);
    }

    public void SaveProfile() throws InterruptedException {
        driver.findElement(By.id("idbtnsaveprofile")).click();
        Thread.sleep(5000);
    }

    public void GoTofamilyPage() throws InterruptedException {
        driver.findElement(By.id("family")).click();
        Thread.sleep(5000);
        System.out.println("Last name of the family verification: " + driver
                .findElement(By.id("titleprofile")).getText().contains("Shulga1"));
    }

    public void NewLastNameChange() throws InterruptedException {
        driver.findElement(By.id("profile")).click();
        Thread.sleep(3000);
        // --- Open in edit mode ----
        driver.findElement(By.id("idbtneditprofile")).click();
        Thread.sleep(7000);
        //--- Enter new last name ---
        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Shulga");
        Thread.sleep(5000);
        //--- Save profile ---
        driver.findElement(By.id("idbtnsaveprofile")).click();
        Thread.sleep(5000);
        System.out.println("Last name was changed: " + driver.findElement(By.linkText("Shulga")).isDisplayed());
    }

    public void profileAndFamilyPageComparing() throws InterruptedException {

        String profileConfession = driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
        System.out.println("Profile confession: " + profileConfession);

        String profileLanguage = driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();
        System.out.println("Profile Language: " + profileLanguage);

        String profileFoodPreference = driver.findElement(By.xpath("//*[@id='fieldobjfoodPreferences']")).getText();
        System.out.println("Profile Food Preference: " + profileFoodPreference);


        //----------------- Go to the Family ------------------------
        driver.findElement(By.id("family")).click();
        Thread.sleep(5000);

        //----------------------Comparing--------------------------

        System.out.println("Confession values are the same for profile and family page: "
                + driver.findElement(By.xpath("//span[@id='fieldobjconfession']"))
                .getText().equals(profileConfession));

        System.out.println("Language values are the same for profile and family page: "
                + driver.findElement(By.xpath("//span[@id='fieldobjlanguages']"))
                .getText().equals(profileLanguage));

        System.out.println("Food preferences values are the same for profile and family page: "
                + driver.findElement(By.cssSelector(".itemprofilefit > #fieldobjfoodPreferences"))
                .getText().equals(profileFoodPreference));

        int counter = 0;
        if (driver.findElement(By.xpath("//span[@id='fieldobjconfession']"))
                .getText().equals(profileConfession)) counter++;
        if (driver.findElement(By.xpath("//span[@id='fieldobjlanguages']"))
                .getText().equals(profileLanguage)) counter++;
        if (driver.findElement(By.cssSelector(".itemprofilefit > #fieldobjfoodPreferences"))
                .getText().equals(profileFoodPreference)) counter++;
        Assert.assertEquals(counter, 3);
    }
}
