package com.jotform.form.testsuite;

import com.jotform.form.pages.*;
import com.jotform.form.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JotFormTest extends TestBase {

    HomePage homePage;
    CalendarPage calendarPage;
    FileUploadPage fileUploadPage;
    NamePage namePage;
    SecurityQuestionPage securityQuestionPage;
    SignaturePage signaturePage;
    ThankYouPage thankYouPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        calendarPage = new CalendarPage();
        fileUploadPage = new FileUploadPage();
        namePage = new NamePage();
        securityQuestionPage = new SecurityQuestionPage();
        signaturePage = new SignaturePage();
        thankYouPage = new ThankYouPage();
    }

    @Test
    @Parameters({"fname","lname","dayText","securityQuestion","securityAnswer"})
    public void userCanSubmitFormSuccessfully(String firstName, String lastName, String day, String securityQuestionText, String securityAnswerText){
        //homePage.goToNextPageFromHomePage();

        namePage.enterFirstName(firstName);
        namePage.enterLastName(lastName);
        namePage.goToNextPageFromNamePage();

        fileUploadPage.uploadTestFile("C:\\Users\\jimil\\uploadTest.txt");
        fileUploadPage.goToNextPageFromFileUpload();

        signaturePage.enterSignature();
        signaturePage.goToNextPageFromSignaturePage();

        calendarPage.selectDateFromCalender(day);
        calendarPage.goToNextPageFromDatePage();

        securityQuestionPage.selectSecurityQuestion(securityQuestionText);
        securityQuestionPage.enterAnswerInTextBox(securityAnswerText);
        securityQuestionPage.clickOnSubmitButton();

        thankYouPage.verifyThankYouMessage();
    }




}
