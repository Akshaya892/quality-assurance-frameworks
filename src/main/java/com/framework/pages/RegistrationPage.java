package com.framework.pages;

import com.framework.utils.ScreenshotUtils;
import com.framework.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By formsCard = By.xpath("//h5[text()='Forms']");
    private By practiceForm = By.xpath("//span[text() ='Practice Form']");
    private By userFirstName = By.id("firstName");
    private By userLastName = By.id("lastName");
    private By emailId = By.id("userEmail");
    private By mobileNumber = By.id("userNumber");
    private By datePicker = By.id("dateOfBirthInput");
    private By monthDropdown = By.cssSelector("select.react-datepicker__month-select");
    private By yearDropdown = By.cssSelector(".react-datepicker__year-select");
    private By subjectsInput = By.id("subjectsInput");
    private By uploadFile = By.id("uploadPicture");
    private By homeAddress = By.id("currentAddress");
    private By stateInput = By.id("react-select-3-input");
    private By cityInput = By.id("react-select-4-input");
    private By submit = By.id("submit");
    private By successPopupTitle = By.id("example-modal-sizes-title-lg");


    public void clickFormsCard() throws IOException {

        WaitUtils.waitForElementVisible(formsCard);
        WebElement forms = driver.findElement(formsCard);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", forms);
        WaitUtils.pause(1);

        forms.click();
        WaitUtils.waitForElementVisible(practiceForm);
        WebElement mainForm = driver.findElement(practiceForm);
        mainForm.click();
        WaitUtils.pause(2);
        ScreenshotUtils.takeScreenshot("formPage");


    }

    public void enterNameAndMail(String firstName, String lastName, String email) {
        WaitUtils.waitForElementVisible(userFirstName);
        WebElement userName = driver.findElement(userFirstName);
        userName.sendKeys(firstName);
        WebElement LastName = driver.findElement(userLastName);
        LastName.sendKeys(lastName);
        WebElement userEmail = driver.findElement(emailId);
        userEmail.sendKeys(email);


    }
    public void selectGender(String gender){
        WebElement genderSelection = driver.findElement(
                By.xpath("//label[text()='" + gender + "']"));
        genderSelection.click();

    }
    public  void  enterMobileNumber(String num){
        WebElement phnNumber = driver.findElement(mobileNumber);
        phnNumber.sendKeys(num);
    }


    public void selectDateOfBirt(String month, String year, String day) {
        WebElement dateOfBirth = driver.findElement(datePicker);
        dateOfBirth.click();
        Select select = new Select(driver.findElement(monthDropdown));
        select.selectByVisibleText(month);
        Select select1 = new Select(driver.findElement(yearDropdown));
        select1.selectByValue(year);
        driver.findElement(
                By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']")
        ).click();
    }

    public void enterSubject(String subject) {
        WebElement subjectInp = driver.findElement(subjectsInput);
        subjectInp.click();
        subjectInp.sendKeys(subject);
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
    }

    public void selectHobby(String hobby) {
        By hobbyLocator = By.xpath(
                "//label[contains(@class,'form-check-label') and normalize-space()='" + hobby + "']"
        );
        driver.findElement(hobbyLocator).click();
        WaitUtils.pause(1);
    }

    public void uploadPhoto() {
        WebElement fileUpload = driver.findElement(uploadFile);
        fileUpload.sendKeys("C:\\Users\\leksh\\Downloads\\image.jpg");
        WaitUtils.pause(1);
    }

    public void enterAddress(String address) {
        WebElement currAddress = driver.findElement(homeAddress);
        currAddress.sendKeys(address);
    }

    public void selectStateAndCity(String state, String city) {
        WebElement stateInp = driver.findElement(stateInput);
        stateInp.sendKeys(state, Keys.ENTER);
        WebElement cityInp = driver.findElement(cityInput);
        cityInp.sendKeys(city, Keys.ENTER);
        WaitUtils.pause(1);

    }

    public void verifySubmission() throws IOException {
        driver.findElement(submit).click();
        WaitUtils.waitForElementVisible(successPopupTitle);
        String actualTitle =
                driver.findElement(successPopupTitle).getText();
        Assertions.assertEquals(
                "Thanks for submitting the form",
                actualTitle);
        WaitUtils.pause(1);
        ScreenshotUtils.takeScreenshot("submissionPage");


    }
}