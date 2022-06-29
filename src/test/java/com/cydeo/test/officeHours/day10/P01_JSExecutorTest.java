package com.cydeo.test.officeHours.day10;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class P01_JSExecutorTest extends TestBase {

    @Test
    public void techCrunch(){

        driver.get("https://techcrunch.com");
        WebElement techCrunch = driver.findElement(By.xpath("//a[@data-ga-event-label=\"TechCrunch\"]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(0,250)");
            BrowserUtils.waitFor(1);
        }
        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(0,-250)");
            BrowserUtils.waitFor(1);
        }
        jse.executeScript("arguments[0].scrollIntoView(true)", techCrunch);

        BrowserUtils.waitFor(3);
        techCrunch.click();
    }

    @Test
    public void etsyTask() {
        //1. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");


        //2. Search for “wooden spoon”
        // search area --> xpath --> //input[@data-id="search-query"]
        // use Keys.ENTER to search
        WebElement searchArea = driver.findElement(By.xpath("//input[@data-id=\"search-query\"]"));
        searchArea.sendKeys("wooden spoon"+ Keys.ENTER);


        //3. Click on filters
        // filter --> xpath --> //span[.="All Filters"]
        driver.findElement(By.xpath("//span[.=\"All Filters\"]")).click();


        //4. Select free shipping, on sale
        // name --> free_shipping
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement free_shipping =  driver.findElement(By.name("free_shipping"));

        jse.executeScript("arguments[0].click()", free_shipping);
        BrowserUtils.waitFor(3);

        driver.findElement(By.xpath("//button[@aria-label=\"Apply\"]")).click();

        //6. Print count of results
        // xpath ---> //span[contains(text(),"results,")]

        BrowserUtils.waitFor(3);
        String result = driver.findElement(By.xpath("//span[contains(text(),\"results,\")]")).getText();

        System.out.println(result);

    }
}
