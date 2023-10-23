package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageobjects.LoginPage;
import pageobjects.TrackingOrderPage;
import utilities.BaseTest;
public class GenerateFinalSteps{
    @Steps
    LoginPage loginPage;
    @Steps
    TrackingOrderPage trackingOrderPage;
    @Given("User already in home page")
    public void alreadyInHomePage() {
        loginPage.alreadyInHomePage();
    }
    @And("User select menu tracking order submenu tracking order")
    public void selectTrackingOrderSubmenu() {
        trackingOrderPage.selectDeveloperMenu();
        trackingOrderPage.selectMenuTrackingOrder();
        trackingOrderPage.selectSubmenuTrackingOrder();
        Assert.assertTrue(trackingOrderPage.verifyMenu("tracking order"));
    }
    @When("User input success appl no")
    public void inputSuccessApplNo() {
        trackingOrderPage.inputApplNo(BaseTest.getSuccessApplNo());
    }
    @When("User input failed {string}")
    public void inputFailedApplNo(String applNo) {
        trackingOrderPage.inputApplNo(applNo);
    }
    @And("User click Find and page display retrieved data")
    public void clickFindAndDataRetrieved() {
        trackingOrderPage.clickFindButton();
    }
    @And("User click generate final button")
    public void clickGenerateFinal() {
        trackingOrderPage.clickGenerateFinal();
    }
    @Then("Page will display success notification box")
    public void displaySuccessNotification() {
        trackingOrderPage.notificationSuccess();
    }
    @Then("Page will display failed notification with message {string}")
    public void pageWillDisplayNotificationWithMessage(String msg) {
        Assert.assertTrue(trackingOrderPage.notificationFail(msg));
    }
    @And("User click OK")
    public void userClickOK() {
        trackingOrderPage.closeNotification();
    }
    @And("Generate Final button is disabled")
    public void generateFinalButtonIsDisabled() {
        Assert.assertTrue(trackingOrderPage.generateFinalBtnDisabled());
    }
    @And("Generate Final button is enabled")
    public void generateFinalButtonIsEnabled() {
        Assert.assertFalse(trackingOrderPage.generateFinalBtnDisabled());
    }
    @And("Print button is disabled")
    public void printButtonIsDisabled() {
        Assert.assertTrue(trackingOrderPage.printBtnDisabled());
    }
    @And("Print button is enabled")
    public void printButtonIsEnabled() {
        Assert.assertFalse(trackingOrderPage.printBtnDisabled());
    }
}