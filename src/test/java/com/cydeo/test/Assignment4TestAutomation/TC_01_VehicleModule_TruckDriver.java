package com.cydeo.test.Assignment4TestAutomation;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_01_VehicleModule_TruckDriver extends TestBase {
    @Test
    public void TD_fleetModuleAccess() throws InterruptedException {
// 1. Open website / Go to login page
        driver.get("https://qa2.vytrack.com/");
// 2. Enter valid username
        WebElement login = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        login.sendKeys("user48");
// 3. Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
// 4.
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleet.click();
        Thread.sleep(3000);
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicles.click();

// 5.
        Thread.sleep(3000);
        WebElement anyCar = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//td[.='654321']"));
        anyCar.click();
// 6.
        Thread.sleep(3000);
        WebElement addEventBtn = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));
        addEventBtn.click();
    }}
