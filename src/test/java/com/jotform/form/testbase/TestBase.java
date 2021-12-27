package com.jotform.form.testbase;

import com.jotform.form.propertyreader.PropertyReader;
import com.jotform.form.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod (alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

   /* @Test
    public void testMethod(){
        System.out.println("Hello World");
    }*/

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

}
