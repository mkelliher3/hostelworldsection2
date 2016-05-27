package com.hostelworld.util;

import com.hostelworld.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by M on 21/05/2016.
 */
public class WebUtil {
    final static int WAIT_TIME_OUT = 30;

    public static HomePage goToHomePage(WebDriver driver) {
        driver.get("http://t.hostelworld.com");
        return PageFactory.initElements(driver, HomePage.class);
    }

    public static void clearAndSendKeys(WebDriver driver, By by, String s) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(s);
    }

    public static void click(WebDriver driver, By by) {
        driver.findElement(by).click();
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static String getElementText(WebDriver driver, By by) {
        System.out.println(driver.findElement(by).getText());
        return driver.findElement(by).getText();
    }
}
