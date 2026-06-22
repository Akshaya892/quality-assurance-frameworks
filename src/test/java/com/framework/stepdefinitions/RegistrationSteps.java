package com.framework.stepdefinitions;

import com.framework.drivers.DriverFactory;
import com.framework.pages.RegistrationPage;
import com.framework.utils.ScreenshotUtils;
import com.framework.utils.WaitUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

public class RegistrationSteps {

    WebDriver driver = DriverFactory.getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("User opens DemoQA website")
    public void open_site() throws IOException {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        ScreenshotUtils.takeScreenshot("homePage");
        WaitUtils.waitForHomePageReady(driver);
    }

    @When("User clicks on Forms card")
    public void clickForms() throws IOException {
        registrationPage.clickFormsCard();
    }

    @When("User fills the registration form")
    public void fillRegistrationForm(DataTable userDetails) {

        Map<String, String> data =
                userDetails.asMap(String.class, String.class);

        registrationPage.enterNameAndMail(
                data.get("firstName"),
                data.get("lastName"),
                data.get("email")
        );
        registrationPage.selectGender(data.get("gender"));
        registrationPage.enterMobileNumber(data.get("mobile"));
        registrationPage.selectDateOfBirt(
                data.get("month"),
                data.get("year"),
                data.get("day")
        );
        registrationPage.enterSubject(data.get("subject"));
        registrationPage.selectHobby(data.get("hobby"));
        registrationPage.uploadPhoto();
        registrationPage.enterAddress(data.get("address"));
        registrationPage.selectStateAndCity(data.get("state"),
                data.get("city"));
    }

    @Then("User should see the submitted form details")
    public void validateSubmittedForm() throws IOException {
        registrationPage.verifySubmission();
    }
}