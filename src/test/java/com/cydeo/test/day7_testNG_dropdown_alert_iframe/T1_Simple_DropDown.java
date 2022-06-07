package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Simple_DropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //    TC #1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //      1. Open Chrome browser
        System.out.println("BeforeMethod is running");
        //setup chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //      2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void simpleDropDownTest() {


//      3. Verify “Simple dropdown” default selected value is correct
//    Expected: “Please select an option”
        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //.getFirstSelectedOption() method will return to default selected option. Return type is WebElement
        String actualDefaultSimple = simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefaultSimple = "Please select an option";

        Assert.assertEquals(actualDefaultSimple, expectedDefaultSimple, "Verification failed");

    }

    @Test
    public void stateSelectionDropDown() {
//      4. Verify “State selection” default selected value is correct
//    Expected: “Select a State”
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        String actualStateDefaultText = stateSelection.getFirstSelectedOption().getText();
        String expectedStateDefaultText = "Select a State";
        Assert.assertEquals(actualStateDefaultText, expectedStateDefaultText, "Verification failed");
    }

}
