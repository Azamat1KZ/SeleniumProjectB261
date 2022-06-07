package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_StateDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
//    1. Open Chrome browser

        System.out.println("BeforeMethod is running");
// setup chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
    driver.close();

    }

    @Test
    public void stateDropDownTest() throws InterruptedException {
    Select stateDropDown = new Select(driver.findElement(By.id("state")));
//    3. Select Illinois with selectByValue()
        Thread.sleep(3000);
    stateDropDown.selectByValue("IL");
//    4. Select Virginia with selectByVisibleText()
        Thread.sleep(3000);
        stateDropDown.selectByVisibleText("Virginia");
//    5. Select California with selectByIndex()
        Thread.sleep(3000);
        stateDropDown.selectByIndex(5);
//    6. Verify final selected option is California. Use all Select options. (visible text, value, index)
        String actualStateOption = stateDropDown.getFirstSelectedOption().getText();
        String expectedStateOption = "California";
        Assert.assertEquals(actualStateOption, expectedStateOption, "Verification failed");
    }

    @Test
    public void multiSelectDropDownTest() throws InterruptedException {
//        3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));

        //isMultple() will return true if dropdown has mutiselect option
        System.out.println("languages.isMultiple() = " + languages.isMultiple());
        languages.selectByValue("java");
        languages.selectByVisibleText("C#");
        languages.selectByIndex(3);


//        4. Print out all selected values.
        // getOptions() will return all options in the dropdown
        List<WebElement> allOptions = languages.getOptions();
        for (WebElement each : allOptions){
            each.click();
            Thread.sleep(3000);
            System.out.println("each.getText() = " + each.getText());
        }


//        5. Deselect all values.
        Thread.sleep(1500);
    languages.deselectAll();

    }

}
