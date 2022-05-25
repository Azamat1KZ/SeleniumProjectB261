package com.cydeo.test;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {
//        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

//        3- Verify “Reset password” button text is as expected:
//        Expected: Reset password
//        WebElement resetBtn = driver.findElement(By.cssSelector("button.login-btn")); //option 1
        WebElement resetBtn = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResetBtnText = "Reset password";
        String actualResetBtnText = resetBtn.getText();

        if (actualResetBtnText.equals(expectedResetBtnText)){
            System.out.println("Verification passed");
        } else {
            System.out.println("Verification failed");

        }

        driver.quit();
    }
}
