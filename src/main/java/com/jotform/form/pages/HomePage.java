package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@id='jfCard-welcome-start']")
    WebElement welcomePageNextButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void goToNextPageFromHomePage(){
        pmClickOnElement(welcomePageNextButton);
    }

}
