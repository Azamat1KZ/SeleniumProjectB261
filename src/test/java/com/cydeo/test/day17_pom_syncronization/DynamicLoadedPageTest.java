package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.DynamicLoadedPageElements7;
import com.cydeo.test.utilities.Driver;
import org.apache.hc.core5.http.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadedPageTest {
@Test
    public void DynamicLoadedPageElements7(){
//    1. Go to https://practice.cydeo.com/dynamic_loading/7
    Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

    DynamicLoadedPageElements7 dynamicLoadedPageElements7 = new DynamicLoadedPageElements7();

//    2. Wait until title is “Dynamic title”

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    wait.until(ExpectedConditions.titleIs("Dynamic title"));

//    3. Assert:
//    Message “Done” is displayed.
    Assert.assertEquals(dynamicLoadedPageElements7.doneMsg.getText(), "Done!");
//    4. Assert: Image is displayed.
    Assert.assertTrue(dynamicLoadedPageElements7.image.isDisplayed());

}
}
