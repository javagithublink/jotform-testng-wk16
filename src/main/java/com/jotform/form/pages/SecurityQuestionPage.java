package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityQuestionPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='input_11']")
    WebElement securityQuestionText;

    @CacheLookup
    @FindBy (xpath = "//button[@id='form-pagebreak-next_13']")
    WebElement securityNextButton;

    @CacheLookup
    @FindBy (xpath = "//button[@id='input_2']")
    WebElement submitButton;

    @CacheLookup
    @FindBy (xpath = "//button[@id='form-pagebreak-next_14']")
    WebElement blankNextButton;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input_12']")
    WebElement answerText;

    public SecurityQuestionPage(){
        PageFactory.initElements(driver, this);
    }

    public void selectSecurityQuestion(String securityQuestion){
        pmSelectByContainsTextFromDropDown(securityQuestionText,securityQuestion);
    }

    public void enterAnswerInTextBox(String answer){
        pmSendTextToElement(answerText,answer);
    }

    public void clickOnSubmitButton(){
        pmClickOnElement(securityNextButton);
        pmClickOnElement(blankNextButton);
        pmClickOnElement(submitButton);
    }
}
