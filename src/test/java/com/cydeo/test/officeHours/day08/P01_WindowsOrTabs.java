package com.cydeo.test.officeHours.day08;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class P01_WindowsOrTabs extends TestBase {
    @Test
    public void windowsTest() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("windows.url"));

        //click twitter
        String currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);

        WebElement twitter = driver.findElement(By.cssSelector(".twitter"));
        twitter.click();

        //current window handle
        currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);

        //get all window handles
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println(allHandles);

        System.out.println("===========================");
        for (String each : allHandles) {
            Thread.sleep(2000);
            System.out.println(each);
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().contains("twitter")){
                System.out.println("Driver is here " + driver.getTitle());
                break;
            }
        }
        String expectedTitle = "Selenium Framework";

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        System.out.println("Switch to main page");
        driver.switchTo().window(currentWindow);

        expectedTitle = "My Store";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }
}
