package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_ActionPractice {
    @Test
    public  void cydeo_practice_drag_and_drop_test(){
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
//        3. Click and hold small circle
//        4. Move it on top of the big circle
//        5. And release on it.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.getDriver());
//      actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.moveToElement(smallCircle).clickAndHold().moveToElement(bigCircle).release().perform();
//        6. Verify “You did great!” text appears on big circle
        Assert.assertEquals(bigCircle.getText(), "You did great!", "Verification failed");
    }
}
