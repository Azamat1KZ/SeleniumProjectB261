package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_getAttribute_Css {
    public static void main(String[] args) {
//        TC #3: NextBaseCRM, locators, getText(), getAttribute() practice 1- Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
//        3- Verify “Log in” button text is as expected:
//        WebElement loginButton = driver.findElement(By.cssSelector("input[type ='submit']"))
//        WebElement loginButton = driver.findElement(By.cssSelector("input[value ='Log in']"));
//        Expected: Log In
        WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        String expectedBtnText = "Log In";
        String actualBtnText = loginButton.getAttribute("value");
        System.out.println("actualBtnText = " + actualBtnText);

        if(actualBtnText.equals(expectedBtnText)){
            System.out.println("LoginBtnTExt verification Passed");
        }else {
            System.out.println("LoginBtnTExt verification Failed");
        }
        driver.quit();
    }

}
