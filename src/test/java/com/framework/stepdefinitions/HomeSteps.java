package com.framework.stepdefinitions;

import com.framework.drivers.DriverFactory;
import com.framework.pages.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @Then("User should see DemoQA homepage loaded")
    public void verify_homepage_loaded() {

        Assert.assertTrue(homePage.isHomePageLoaded(),
                "Homepage is not loaded correctly");
    }
}