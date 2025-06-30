package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orange.utils.CommonUtils1;
import com.orange.utils.TestNGUtility1;
import com.orangehrm.base.BasePage1;
import com.orangehrm.pages.LoginPage;



public class TestLoginPage extends BasePage1 {

    LoginPage loginPage = new LoginPage();

    @Test(description="Verify login functionality")
    public void verifyLoginPage() throws Exception {
        loginPage.login();
        CommonUtils1.hardWait(5);
        TestNGUtility1.assertTrue("Paul", CommonUtils1.getElementText(loginPage.getWelcomePage()));
    }
}
