package com.hostelworld.pageobjects;

import com.hostelworld.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by M on 21/05/2016.
 */
public class ResultsPage {
    public void clickOnSortButton(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.xpath("//*/span[contains(text(), 'Sort')]"));
        WebUtil.click(driver, By.xpath("//*/span[contains(text(), 'Sort')]"));
    }

    public void clickOnSortByNameItem(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.id("sortByName"));
        WebUtil.click(driver, By.id("sortByName"));
    }

    public void clickOnSortByPriceItem(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.id("sortByPrice"));
        WebUtil.click(driver, By.id("sortByPrice"));
    }

    public String getResultName(WebDriver driver, int i) {
        String locator = "(//*/h2/a[contains(concat(' ', @class, ' '), 'hwta-property-link')])[" + i + "]";
        WebUtil.waitForElementVisible(driver, By.xpath(locator));
        return WebUtil.getElementText(driver, By.xpath(locator));
    }

    public String getResultPrice(WebDriver driver, int i) {
        String locator = "(//*/a[contains(concat(' ', @class, ' '), 'dormroom')])[" + i + "]";
        WebUtil.waitForElementVisible(driver, By.xpath(locator));
        return WebUtil.getElementText(driver, By.xpath(locator));
    }
}
