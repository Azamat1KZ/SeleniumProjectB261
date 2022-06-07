package com.cydeo.test.day4_cssSelector_Xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_isDisplayed {
    public static void main(String[] args) {
//    TC #1: XPATH and cssSelector Practices
//      1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//      2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

//      3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)


//          a. “Home” link
        //Locating homeLink with cssSelector
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locating homeLink using cssSelector, href value
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[href='/']"));

        //Locating homeLink using cssSelector, syntax2 for class "."
        WebElement homeLink3 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locating homeLink using Xpath
        WebElement homeLink4 = driver.findElement(By.xpath("//a[.='Home']"));

//          b. “Forgot password” header
        //Locating forgotPassword using cssSelector from parent to child with ">"
        WebElement forgotPassword1 = driver.findElement(By.cssSelector("div[class='example']>h2"));

        //Locating forgotPassword using Xpath
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //Locating forgotPassword using cssSelector syntax2 from parent to child with ">"
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div.example>h2"));

//          c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));

        WebElement emailText1 = driver.findElement(By.xpath("//label[@for='email']"));

//          d. E-mail input box
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));

        WebElement emailInput1 = driver.findElement(By.xpath("//input[@name='email']"));

//          e. “Retrieve password” button
        WebElement retrievePassword1 = driver.findElement(By.cssSelector("button#form_submit"));
        WebElement retrievePassword2 = driver.findElement(By.cssSelector("button.radius"));

//          f. “Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.cssSelector("div[style='text-align: center;']"));




//      4. Verify all web elements are displayed.
        System.out.println("homeLink1.isDisplayed()) = " +  homeLink1.isDisplayed());
        System.out.println("forgotPassword1.isDisplayed() = " + forgotPassword1.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());
    }


}
