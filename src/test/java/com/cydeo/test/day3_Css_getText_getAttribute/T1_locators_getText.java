package com.cydeo.test.day3_Css_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) {
//        TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
//        3- Enter incorrect username: “incorrect”
        WebElement userName = driver.findElement(By.className("login-inp"));
        userName.sendKeys("incorrect");
//        4- Enter incorrect password: “incorrect”
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");
//        5- Click to login button.
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
//        6- Verify error message text is as expected:
//        Expected: Incorrect login or password
        WebElement errorMsg = driver.findElement(By.className("errortext"));
        String expectedText = "Incorrect login or password";
        String actualText = errorMsg.getText();
        if (actualText.equals(expectedText)){
            System.out.println("Error message verification passed");

        }else {
            System.out.println("Error message verification failed");
        }
        driver.quit();
    }
}
