package com.cydeo.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    public static void login_crm(WebDriver driver) {
//        Method #1 info:
//          • Name: login_crm()
//          • Return type: void
//          • Arg1: WebDriver

        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class = 'login-btn']"));
        loginBtn.click();
    }

    public static void login_crm(WebDriver driver, String username, String password) {
//    Method #2 info:
//          • Name: login_crm()
//          • Return type: void
//          • Arg1: WebDriver
//          • Arg2: String username
//          • Arg3: String password


        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class = 'login-btn']"));
        loginBtn.click();
    }
}