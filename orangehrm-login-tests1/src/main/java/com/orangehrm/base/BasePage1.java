package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.orange.utils.CommonUtils1;



public class BasePage1 {

    WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {
        //  Load config and open browser to demo site
        CommonUtils1.readPropertiesFile();
        CommonUtils1.launchBrowserAndNavigateToApp();
    }

    @AfterTest
    public void close() throws Exception {
        //  Uncomment to close browser after tests
        // CommonUtils.driver.quit();
    }
}
