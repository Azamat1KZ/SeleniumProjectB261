package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_ActionPractices {
    CydeoPracticePage cydeoPracticePage;
    Actions actions;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
//        cydeoPracticePage = new CydeoPracticePage();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void drag_small_circle_test(){
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage();

//        3. Verify expected default text appears on big circle
//                Expected = "Drag the small circle here."
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drag the small circle here.");

    }

    @Test
    public void drop_here_test(){
//        TC #3: Cydeo Practice Drag and Drop Test
//        1. Open a chrome browser
//        2.  Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage();

//        3. Click and hold small circle
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(cydeoPracticePage.smallCircle).clickAndHold().pause(2000).moveByOffset(200, 100).pause(2000).perform();

//        4. Verify "Drop here." text appears on big circle
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drop here.");

    }
}
