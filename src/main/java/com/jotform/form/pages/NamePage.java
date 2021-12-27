package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NamePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='first_3']")
    WebElement firstNameText;

    @CacheLookup
    @FindBy (xpath = "//input[@id='last_3']")
    WebElement lastNameText;

    @CacheLookup
    @FindBy (xpath = "//button[@id='form-pagebreak-next_5']")
    WebElement nameNextButton;

    public NamePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName){
        pmSendTextToElement (firstNameText,firstName);
    }

    public void enterLastName(String lastName){
        pmSendTextToElement(lastNameText,lastName);
    }

    public void goToNextPageFromNamePage(){
        pmClickOnElement(nameNextButton);
    }

}
