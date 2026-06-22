package com.framework.pages;

import com.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By homeBanner = By.className("home-banner");

    public boolean isHomePageLoaded() {
        WaitUtils.waitForElementVisible(homeBanner);

        return driver.getCurrentUrl().contains("demoqa")
                && driver.getTitle().length() > 0
                && driver.findElement(homeBanner).isDisplayed();
    }
}