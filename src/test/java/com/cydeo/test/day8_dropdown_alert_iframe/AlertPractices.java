package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.rowset.JdbcRowSet;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

public class AlertPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    2. Go to  website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts ");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void confirmAlertTest() {
//        3. Click to “Click for JS Confirm” button
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirmBtn.click();

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        5. Verify “You clicked: Ok” text is displayed.
        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertTrue(resultMessage.isDisplayed());

        String actualResult = resultMessage.getText();
        String expectedResult = "You clicked: Ok";

        Assert.assertEquals(actualResult, expectedResult, "Verification failed");
    }

    @Test
    public void promtAlertTest() throws InterruptedException {
//        3. Click to “Click for JS Prompt” button
        WebElement jsPromtBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromtBtn.click();

//        4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(1500);

//        5. Click to OK button from the alert
        alert.accept();

//        6. Verify “You entered:  hello” text is displayed.
        WebElement resultMsg = driver.findElement(By.id("result"));
        Assert.assertTrue(resultMsg.isDisplayed());

        String actualResultMsg = resultMsg.getText();
        String expectedResultMsg = "You entered:  hello";

        assertEquals(actualResultMsg, expectedResultMsg, "Verification failed");

    }

}
