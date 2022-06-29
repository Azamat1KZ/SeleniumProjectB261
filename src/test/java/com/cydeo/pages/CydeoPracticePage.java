package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoPracticePage {
    @FindBy (id="draggable")
    public WebElement smallCircle;

    @FindBy (id="droptarget")
    public WebElement bigCircle;

    public CydeoPracticePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
}
