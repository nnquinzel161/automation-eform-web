package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pageobjects.LoginPage;
public class LoginSteps {
    @Steps
    LoginPage loginPage;
    @Given("User navigate to Eform login page")
    public void navigateToLoginPage() {
        loginPage.openUrlEformLoginPage();
    }
    @When("User enters a valid username")
    public void enterValidUsername() {
        loginPage.inputValidUsername();
    }
    @And("User enters a valid password")
    public void enterValidPassword() {
        loginPage.inputValidPassword();
    }
    @And("User click login")
    public void clickLogin() {
        loginPage.clickLogin();
    }
    @Then("User should be navigated to Eform dashboard")
    public void navigateToDashboard() {
        loginPage.openUrlEformHomePage();
    }
}