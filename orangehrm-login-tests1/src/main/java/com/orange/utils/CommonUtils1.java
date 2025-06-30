package com.orange.utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils1 {

    public static WebDriverWait wait;
    public static Properties config;
    public static WebDriver driver;
    public static FileInputStream fis;
    public static final String configFilePath = "/src/test/resources/config.properties";

    // -------------------- Properties Implementations ----------------------

    public static void readPropertiesFile() {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + configFilePath);
            config = new Properties();
            config.load(fis);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static void launchBrowserAndNavigateToApp() {
        try {
            String browserName = config.getProperty("browser");
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.get(config.getProperty("url"));
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    // ---------------------- Selenium Implementations -------------------------

    public static WebElement findElement(By by) {
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static List<WebElement> findElements(By by) {
        try {
            return driver.findElements(by);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static void clickElement(By by) {
        try {
            findElement(by).click();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static void enterValue(By by, String value, Boolean isClear) {
        try {
            if (isClear) clearWholeText(by);
            findElement(by).sendKeys(value);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static void clearWholeText(By by) throws Exception {
        try {
            findElement(by).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static void selectDropDownValue(By dropDown, String option) {
        try {
            clickElement(dropDown);
            clickElement(getCommonLocatorUsingText(option));
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static void switchToWindow() {
        try {
            String parentWindow = driver.getWindowHandle();
            for (String window : driver.getWindowHandles()) {
                if (!parentWindow.equals(window)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static By getCommonLocatorUsingText(String value) {
        try {
            return By.xpath("//*[text()='" + value + "']");
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static String getWindowTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static String getCurrentPageUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static String getElementText(By by) {
        try {
            return findElement(by).getText();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static String getElementAttributeValue(By by, String attributeName) {
        try {
            return findElement(by).getAttribute(attributeName);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return null;
        }
    }

    public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static Boolean isElementDisplayed(By by) {
        try {
            return findElement(by).isDisplayed();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return false;
        }
    }

    public static Boolean isElementSelected(By by) {
        try {
            return findElement(by).isSelected();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return false;
        }
    }

    public static void scrollToElement(By by) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findElement(by));
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static boolean waitForElementToBeVisible(By by) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("loadTime"))));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
            return false;
        }
    }

    public static void dragAndDrop(By byDrag, By byDrop) {
        try {
            new Actions(driver).dragAndDrop(findElement(byDrag), findElement(byDrop)).build().perform();
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }

    public static void moveToElement(By by) {
        try {
            if (waitForElementToBeVisible(by)) {
                new Actions(driver).moveToElement(findElement(by)).perform();
            }
        } catch (Exception e) {
            TestNGUtility1.assertFail(e.getMessage());
        }
    }
}
