package com.cydeo.test.officeHours.day10;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class P02_ExplicitWaitTest extends TestBase {
    @Test
    public void test1() throws InterruptedException {
    /*
        Task 1

        - Go to "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html"
        - Click buttons in order
        - Verify messages are equal after click all buttons
                - All Buttons Clicked
                - Clickable Buttons
                - Click Buttons In Order
         */
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement start = driver.findElement(By.id("button00"));
        System.out.println(start.isEnabled()); //true

        WebElement one = driver.findElement(By.id("button01"));
        System.out.println(start.isEnabled());

        WebElement two = driver.findElement(By.id("button02"));
        System.out.println(start.isEnabled());

        WebElement three = driver.findElement(By.id("button03"));
        System.out.println(start.isEnabled());

        start.click();
        wait.until(ExpectedConditions.elementToBeClickable(one));

        one.click();
        wait.until(ExpectedConditions.elementToBeClickable(two));

        two.click();
        wait.until(ExpectedConditions.elementToBeClickable(three));

        three.click();

    }
}
