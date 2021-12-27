package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ThankYouPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Thank You!']")
    WebElement thankYouMessage;

    public ThankYouPage(){
        PageFactory.initElements(driver, this);
    }

    public void verifyThankYouMessage(){

        String actual = thankYouMessage.getText();
        Assert.assertTrue(actual.contains("Thank You"));

    }

}
