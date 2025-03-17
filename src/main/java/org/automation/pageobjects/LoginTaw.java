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

    private final static By USERNAME_FIELD = By.xpath("//input[@id='username']");
    private final static By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    private final static By SUBMIT_BUTTON = By.xpath("//div[@class='g-recaptcha']");
    //private final static By SEARCH_BUTTON = By.xpath("//span[@class='sr-search-btn']");
    //private final static By SEARCH_BOX = By.xpath("//input[@id='s']");
    //private final static By COOCKIE_BUTTON = By.xpath("//button[normalize-space()='Permite totul']");
    //private final static By SEARCH_BOX_PAGE = By.xpath("//input[@id='s']");
    private final static By SPINNER = By.xpath("/*[@id=\"recaptcha-anchor\"]/div[4]");
    private final static By NO_ROBOT_BUTTON = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[4]);


    public void openTawLoginPage() {
        log.info("Open Taw login page");
        manager.openBrowser();
        manager.getDriver().get("https://tawenergy.ro/my-account/");
        manager.getDriver().manage().window().maximize();
        actions.waitElementToBeClickable(USERNAME_FIELD, 10);
    }

    public void loginTaw() {
        log.info("Login to Taw Page");
        String user = LoginDetails.LOGIN_USER.getUsername();
        String pass = LoginDetails.LOGIN_USER.getPassword();

        actions.waitElementToBeClickable(USERNAME_FIELD, 10);
        actions.sendKeys(USERNAME_FIELD, user);
        actions.sendKeys(PASSWORD_FIELD, pass);

        actions.waitToSpinnerToHide(SPINNER, 10);

        actions.waitElementToBeClickable(NO_ROBOT_BUTTON, 10);
        actions.clickElement(NO_ROBOT_BUTTON);


        actions.waitElementToBeClickable(SUBMIT_BUTTON, 10);
        actions.clickElement(SUBMIT_BUTTON);
    }
}


