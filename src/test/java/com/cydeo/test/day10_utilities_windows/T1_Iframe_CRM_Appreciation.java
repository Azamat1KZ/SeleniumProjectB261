package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Iframe_CRM_Appreciation extends TestBase {
    @Test
    public void sendingApreciationMsg(){
//        2- Go to: https://login2.nextbasecrm.com/
            driver.get("https://login2.nextbasecrm.com");

//        3- Login Homepage ( Login with valid username and password)

//        CRM_Utilities.login_crm(driver); -> method1

        CRM_Utilities.login_crm(driver, "helpdesk1@cybertekschool.com", "UserUser"); // -> method2
//        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
//        username.sendKeys("helpdesk1@cybertekschool.com");
//
//        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
//        password.sendKeys("UserUser");
//
//        WebElement loginBtn = driver.findElement(By.xpath("//input[@class = 'login-btn']"));
//        loginBtn.click();

//        4- Click the MORE tab and select APPRECIATION
        WebElement moreBtn = driver.findElement(By.xpath("//span[contains(@id,'link-text')]")); // cssSelector: span[id*='link-text']

        moreBtn.click();

        WebElement appreciationBtn = driver.findElement(By.xpath("(//span[.='Appreciation'])[2]"));
        appreciationBtn.click();


//        5- Write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Break time?");


//        6- Click the SEND button
        driver.switchTo().parentFrame();
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
//        7- Verify the Appreciation message is displayed on the feed
        WebElement feedtext = driver.findElement(By.xpath("//div[starts-with(@id, 'blog_post_body')]"));
        String actualText = feedtext.getText();
        String expectedText = "Break time?";
        Assert.assertEquals(actualText, expectedText, "Feed msg did not appear correctly");
    }
}
