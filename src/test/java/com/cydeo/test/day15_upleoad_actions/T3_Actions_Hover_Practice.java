package com.cydeo.test.day15_upleoad_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.apache.hc.core5.net.WWWFormCodec;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T3_Actions_Hover_Practice {
    @Test
    public void google_actions_hover_test() throws InterruptedException {
//    1. Go to https://www.google.com
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

//    2. Hover over on Search button
//    3. Hover over on Feeling Lucky button
        WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement luckyBtn = Driver.getDriver().findElement(By.id("gbqfbb"));


        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.moveToElement(searchBtn).perform();
        Thread.sleep(3000);
        actions.moveToElement(luckyBtn).perform();
    }
}
