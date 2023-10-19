package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;
public class LoginPage extends PageObject {
    private final String URL_EFORMWEB_LOGIN_PAGE = BaseTest.getBaseUrl() + BaseTest.getUrlLogin();
    private final String URL_EFORMWEB_HOME_PAGE = BaseTest.getBaseUrl() + BaseTest.getUrlHome();
    public final By SELECTOR_INPUT_USERNAME = By.cssSelector("input[type='text']");
    public final By SELECTOR_INPUT_PASSWORD = By.cssSelector("input[type='password']");
    public final By SELECTOR_LOGIN = By.cssSelector("button[class='z-button']");
    public void openUrlEformLoginPage() {
        openUrl(URL_EFORMWEB_LOGIN_PAGE);
        waitFor(ExpectedConditions.urlToBe(URL_EFORMWEB_LOGIN_PAGE));
    }
    public void inputValidUsername() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_INPUT_USERNAME));
        typeInto(find(SELECTOR_INPUT_USERNAME), BaseTest.getValidUsername());
    }
    public void inputValidPassword() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_INPUT_PASSWORD));
        typeInto(find(SELECTOR_INPUT_PASSWORD), BaseTest.getValidPassword());
    }
    public void clickLogin() {
        find(SELECTOR_LOGIN).click();
    }

    public void openUrlEformHomePage() {
        waitFor(ExpectedConditions.urlToBe(URL_EFORMWEB_HOME_PAGE));
    }

    public void alreadyInHomePage() {
        openUrlEformLoginPage();
        inputValidUsername();
        inputValidPassword();
        clickLogin();
        openUrlEformHomePage();
    }
}