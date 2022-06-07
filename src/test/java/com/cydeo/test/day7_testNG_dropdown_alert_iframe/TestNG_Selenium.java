package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;


    @BeforeMethod
    public void setUpMethod(){
        System.out.println("BeforeMethod is running");
        //setup chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("AfterMethod is running");
        driver.close();
    }

    @Test
    public void googleTitle(){
        //get google.com
        driver.get("https://google.com");

        // Assert: title is "Google"
        Assert.assertEquals(driver.getTitle(), "Google", "Test failed");

    }

    @Test
    public void yahooTitle(){
        driver.get("https://yahoo.com");
        Assert.assertEquals(driver.getTitle(), "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos", "Test failed");
    }

    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com");
        Assert.assertEquals(driver.getTitle(), "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", "Test failed");
    }

}
