package com.hostelworld.pageobjects;

import com.hostelworld.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by M on 21/05/2016.
 */
public class HomePage {
    public void fillInSearchBox(WebDriver driver, String s) {
        WebUtil.clearAndSendKeys(driver, By.id("home-search-keywords"), s);
    }

    public void clickOnSearchResult(WebDriver driver, String result) {
        String locator = "//*/li[contains(concat(' ', @class, ' '), 'result-type-city')][contains(concat(' ', @title, ' '), '" + result + "')]";
        WebUtil.waitForElementVisible(driver, By.xpath(locator));
        WebUtil.click(driver, By.xpath(locator));
    }

    public ResultsPage clickOnSearchButton(WebDriver driver) {
        WebUtil.click(driver, By.xpath("//*/button[contains(text(), 'SEARCH')]"));

        return PageFactory.initElements(driver, ResultsPage.class);
    }
}
