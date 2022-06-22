package com.cydeo.test.day9_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IframePractice extends TestBase {
@Test
    public void iFrameTest(){
//    2- Go to: https://practice.cydeo.com/iframe
    driver.get("https://practice.cydeo.com/iframe");

//    3- Clear text from comment body // NoSuchElementException comes with reasons: 1 - The element is not located correctly. 2 - There is an iframe and you have to switch to frame.

    // Option 1 - we can use frame(id) for id arg
    driver.switchTo().frame("mce_0_ifr");

    // Option 2 - we can use frame(locator)
    //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

    // Option 3 - frame(index), index starts from 0
    //driver.switchTo().frame(0);
    WebElement commentBody = driver.findElement(By.id("tinymce"));
    commentBody.clear();

//    4- Type "Hello World" in comment body
    commentBody.sendKeys("Hello World");

//    5- Verify "Hello World" text is written in comment body
    assertEquals(commentBody.getText(), "Hello World", "Verification failed");

//    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
    driver.switchTo().parentFrame();
    //driver.switchTo().defaultContent();
    WebElement headerText = driver.findElement(By.tagName("h3"));
    assertTrue(headerText.isDisplayed(), "Header did not appear");
    String actualHeader = headerText.getText();
    String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
    assertEquals(actualHeader, expectedHeader, "Header text did not appear correctly");

}
}
