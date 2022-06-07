package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_findElements {
    public static void main(String[] args) {
//      TC #4: FindElements Task
//      1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//      2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

//      3- Locate all the links in the page.
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

//      4- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());

//      5- Print out the texts of the links.
        for (WebElement eachLink : allLinks) {
            System.out.println("eachLink.getText() = " + eachLink.getText());
            System.out.println("eachLink.getAttribute(\"href\") = " + eachLink.getAttribute("href"));
        }

//      6- Print out the HREF attribute values of the links
    }
}