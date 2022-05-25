package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_getText_getAttributes {
    public static void main(String[] args) {
//        TC #5: getText() and getAttribute() method practice
//        1- Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

//        3- Verify header text is as expected:
//        Expected: Registration form
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeader = "Registration form";
        String actualHeader = headerText.getText();

        if(actualHeader.equals(expectedHeader)){
            System.out.println("Header text verification passed");
        }else {
            System.out.println("Header text verification failed");
        }
        // 4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.className("form-control"));
        String expectedPlaceHolder = "first name";

        // 5- Verify placeholder attribute’s value is as expected: Expected: first name
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Placeholder text verification passed");
        }else {
            System.out.println("Placeholder text verification failed");
        }
    }
}
