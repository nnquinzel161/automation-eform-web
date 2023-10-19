package pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;

public class TrackingOrderPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'TRACKING ORDER')]/ancestor::div[contains(@class, 'z-treecell-content')]/span[1]")
    private WebElementFacade trackingOrderArrow;
    @FindBy(xpath = "//span[contains(string(), \"DEVELOPER\")]")
    private WebElementFacade developerMenu;
    @FindBy(xpath = "//span[@class='z-label'][contains(text(),'TRACKING ORDER')]")
    private WebElementFacade trackingOrderSubMenu;
    @FindBy(css = "input[id$='lh']")
    private WebElementFacade applNo;
    @FindBy(css = "select[class='z-select'][id$='s2']")
    private WebElementFacade officeCodeDropdown;
    @FindBy(css = "input[id$='uh-real']")
    private WebElementFacade applNoFrom;
    @FindBy(css = "input[id$='wh-real']")
    private WebElementFacade applNoTo;
    @FindBy(xpath = "//button[contains(text(),'Find')]")
    private WebElementFacade btnFind;
    @FindBy(css = "button[title='Generate Final']")
    private WebElementFacade btnGenerateFinal;
    @FindBy(css = "//div[class='z-loading-indicator']")
    private WebElementFacade loadingBar;
    @FindBy(css = "div[class='z-messagebox-window  z-window z-window-modal z-window-shadow']")
    private WebElementFacade notificationBox;
    @FindBy(css = "button[title='Print']")
    private WebElementFacade btnPrint;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElementFacade btnOkNotification;

    public void selectDeveloperMenu() {
        developerMenu.click();
    }
    public void selectMenuTrackingOrder() {
        waitFor(ExpectedConditions.visibilityOf(trackingOrderArrow));
        trackingOrderArrow.click();
    }
    public void selectSubmenuTrackingOrder() {
        waitFor(ExpectedConditions.visibilityOf(trackingOrderSubMenu));
        trackingOrderSubMenu.click();
    }
    public void inputApplNo(String applNo) {
        typeInto(this.applNo, applNo);
    }
    public void selectOfficeCode() {
        officeCodeDropdown.selectByVisibleText(BaseTest.getOfficeCode());
    }
    public void inputApplNoFrom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", applNoFrom, BaseTest.getApplNoFrom());
    }
    public void inputApplNoTo() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", applNoTo, BaseTest.getApplNoTo());
    }
    public void clickFindButton() {
        waitFor(ExpectedConditions.visibilityOf(btnFind));
        btnFind.click();
        waitFor(ExpectedConditions.invisibilityOf(loadingBar));
    }
    public void clickGenerateFinal() {
        btnGenerateFinal.click();
    }
    public void notificationSuccess() {
        waitFor(ExpectedConditions.visibilityOf(notificationBox));
        notificationBox.containsText("Generate Final Sukses!");
    }

    public void closeNotification() {
        btnOkNotification.click();
        waitFor(ExpectedConditions.invisibilityOf(btnOkNotification));
    }
    public boolean notificationFail(String msg) {
        waitFor(ExpectedConditions.visibilityOf(notificationBox));
        return notificationBox.getText().toLowerCase().contains(msg.toLowerCase());
    }

    public boolean generateFinalBtnEnabled() {
        return btnGenerateFinal.isEnabled();
    }

    public boolean printBtnEnabled() {
        return btnFind.isEnabled();
    }

}
