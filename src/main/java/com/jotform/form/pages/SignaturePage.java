package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignaturePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@id='form-pagebreak-next_8']")
    WebElement signNextButton;

    @CacheLookup
    @FindBy(xpath = "//canvas[@aria-label='E-Signature Field']")
    WebElement signatureText;

    public SignaturePage(){
        PageFactory.initElements(driver, this);
    }

    public void enterSignature(){

        Actions builder = new Actions(driver);
        pmWaitWithThreadSleep(20);
        Action signature= builder.moveToElement(signatureText)
                //start points x axis and y axis.
                .clickAndHold()
                .moveToElement(signatureText,20,-50)
                .moveByOffset(50, 50) // 2nd point (x1,y1)
                .moveByOffset(-50,-100)
                .moveByOffset(80,40)
                .moveByOffset(-70,50)
                .release(signatureText)
                .click()
                .build();
        signature.perform();
        pmWaitWithThreadSleep(20);
    }

    public void goToNextPageFromSignaturePage(){

        pmClickOnElement(signNextButton);
    }

}
