package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.LoginDetails;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class LoginTaw {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By USERNAME_FIELD = By.xpath("//*[@id=\"username\"]");
    private final static By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
    private final static By SUBMIT_BUTTON = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/div[3]/button");
    private final static By SEARCH_BUTTON = By.xpath("/html/body/header/div[2]/div/div/div[2]/div/div[2]/span[1]/svg");
    private final static By SEARCH_RESULT = By.xpath("//*[@id=\"s\"]");
    private final static By SEARCH_BOX_PAGE = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
    private final static By SEARCH_BUTTON_ADMIN_PAGE = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");


    public void openTawLoginPage() {
        log.info("Open Taw login page");
        manager.openBrowser();
        manager.getDriver().get("https://tawenergy.ro/my-account/");
        manager.getDriver().manage().window().maximize();
    }

    public void loginTaw() {
        log.info("Login to Taw Page");
        String user = LoginDetails.LOGIN_USER.getUsername();
        String pass = LoginDetails.LOGIN_USER.getPassword();

        actions.waitElementToBeClickable(USERNAME_FIELD, 10);
        actions.sendKeys(USERNAME_FIELD, user);
        actions.sendKeys(PASSWORD_FIELD, pass);
        actions.clickElement(SUBMIT_BUTTON);
    }

    public List<WebElement> searchItemLeftPanel(String elementForSearch) {
        actions.waitElementToBeClickable(SEARCH_BUTTON, 5);
        actions.clickElement(SEARCH_BUTTON);
        actions.sendKeys(SEARCH_BUTTON, elementForSearch);
        return actions.getElements(SEARCH_RESULT);
    }

    public void clickOnResult(String objectToClick) {
        List<WebElement> results = actions.getElements(SEARCH_RESULT);
        for (WebElement element : results) {
            if (element.getText().equals(objectToClick)) {
                element.click();
            }
        }
    }

    public String searchAdminPage(String userForSearch, int timeToWait) {
        actions.waitFluentElementClickable(SEARCH_BOX_ADMIN_PAGE, timeToWait);
        actions.sendKeys(SEARCH_BOX_ADMIN_PAGE, userForSearch);
        actions.clickElement(SEARCH_BUTTON_ADMIN_PAGE);
        actions.waitToSpinnerToHide(SPINNER, 10);
        return actions.getElementText(ADMIN_PAGE_RESULT);
    }

    public String resetAdminSearch() throws InterruptedException {
        actions.clickElement(RESET_ADMIN_SEARCH);
//        Thread.sleep(10000);
        actions.waitToSpinnerToHide(SPINNER, 10);
        manager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return actions.getElementText(SEARCH_BOX_ADMIN_PAGE);
    }
}