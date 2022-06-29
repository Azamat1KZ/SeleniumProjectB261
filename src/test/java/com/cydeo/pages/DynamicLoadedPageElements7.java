package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadedPageElements7 {
    public DynamicLoadedPageElements7() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//strong[.='Done!']")
    public WebElement doneMsg;

    @FindBy (xpath = "//img")
    public WebElement image;

}
