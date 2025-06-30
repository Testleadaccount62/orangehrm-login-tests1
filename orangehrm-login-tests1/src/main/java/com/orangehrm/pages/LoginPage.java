// LoginPage1.java

package com.orangehrm.pages;

import org.openqa.selenium.By;
import com.orange.utils.CommonUtils1;
import com.orange.utils.TestNGUtility1;

public class LoginPage {

    // Updated locators based on the new OrangeHRM DOM
    private final By by_username = By.name("username");
    private final By by_password = By.name("password");
    private final By by_loginBtn = By.xpath("//button[@type='submit']");
    private final By by_welcomeText = By.xpath("//p[contains(text(),'Paul')]");

    public void login() {
        try {
            CommonUtils1.enterValue(getUsername(), "Admin", true);
            CommonUtils1.enterValue(getPassword(), "admin123", true);
            CommonUtils1.clickElement(getLoginButton());
        } catch (Exception e) {
            TestNGUtility1.assertFail("Login failed: " + e.getMessage());
        }
    }

    public By getUsername() {
        return by_username;
    }

    public By getPassword() {
        return by_password;
    }

    public By getLoginButton() {
        return by_loginBtn;
    }

    public By getWelcomePage() {
        return by_welcomeText;
    }
}
