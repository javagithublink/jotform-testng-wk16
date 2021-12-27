package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//img[@id='input_9_pick']")
    WebElement calendarTab;

    /*@CacheLookup
    @FindBy (xpath = "//tr[@class='days']/td")
    List<WebElement> datesText;*/

    @CacheLookup
    @FindBy (xpath = "//input[@id='lite_mode_9']")
    WebElement datesText;

    @CacheLookup
    @FindBy (xpath = "//button[@id='form-pagebreak-next_10']")
    WebElement dateNextButton;

    public CalendarPage(){
        PageFactory.initElements(driver, this);
    }


    public void selectDateFromCalender(String day) {
        /*pmClickOnElement(calendarTab);

        for (WebElement date1 : datesText) {
            if (date1.getText().equalsIgnoreCase(day)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pmClickOnElement(date1);
                break;
            }
        }*/

        pmSendTextToElement(datesText,day);

    }

    public void goToNextPageFromDatePage(){
        pmClickOnElement(dateNextButton);
    }


}
