package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDateDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("BeforeMethod is running");
        //setup chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("AfterMethod is running");
        driver.close();
    }

    @Test
    public void dateDropDownTest() throws InterruptedException {
//    3. Select “December 1, 1923” and verify it is selected.
        Select yearSelection = new Select(driver.findElement(By.id("year")));
        Select monthSelection = new Select(driver.findElement(By.id("month")));
        Select daySelection = new Select(driver.findElement(By.id("day")));

        for (WebElement eachYearOption : yearSelection.getOptions()) {
            System.out.println(eachYearOption.getText());
        }

//    Select year using   : visible text
        yearSelection.selectByVisibleText("1923");
        Thread.sleep(1500);

//    Select month using : value attribute Select
        monthSelection.selectByValue("11");
        Thread.sleep(1500);

//    day using : index number
        daySelection.selectByIndex(0);
        Thread.sleep(1500);

//  Verify each year, month and day selected correctly
        String actualYear = yearSelection.getFirstSelectedOption().getText();
        String actualMonth = monthSelection.getFirstSelectedOption().getText();
        String actualDay = daySelection.getFirstSelectedOption().getText();
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertTrue(actualYear.equals(expectedYear), "Year verification failed");
        Assert.assertEquals(actualMonth, expectedMonth, "Month verification failed");
        Assert.assertEquals(actualDay, expectedDay, "Day verification failed");

    }
}
