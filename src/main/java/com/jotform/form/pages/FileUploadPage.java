package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@id='form-pagebreak-next_4']")
    WebElement fileUploadNextButton;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input_6']")
    WebElement uploadFileWindow;



    public FileUploadPage(){
        PageFactory.initElements(driver, this);
    }

    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void uploadTestFile(String fileName){

        pmMouseHoverAndClick(uploadFileWindow);
        try {
            //Setting clipboard with file location
            setClipboardData(fileName);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    public void goToNextPageFromFileUpload(){
        pmClickOnElement(fileUploadNextButton);
    }

}
