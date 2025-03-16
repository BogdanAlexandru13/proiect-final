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
    private final static By SEARCH_BUTTON = By.xpath("//span[@class='sr-search-btn']");
    private final static By SEARCH_BOX = By.xpath("//input[@id='s']");
    //private final static By COOCKIE_BUTTON = By.xpath("");
    private final static By SEARCH_BOX_PAGE = By.xpath("//input[@id='s']");
    private final static By SEARCH_BUTTON_ADMIN_PAGE = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final static By SPINNER = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[3]");
    private final static By ADMIN_PAGE_RESULT = By.xpath("//div[@class='admin-page-result']");
    private final static By RESET_ADMIN_SEARCH = By.xpath("//button[@class='reset-admin-search']");
    private final static By NO_ROBOT_BUTTON = By.xpath("//div[@class='g-recaptcha']");


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

        actions.waitElementToBeClickable(NO_ROBOT_BUTTON, 5);
        actions.clickElement(NO_ROBOT_BUTTON);


        actions.waitElementToBeClickable(SUBMIT_BUTTON, 10);
        actions.clickElement(SUBMIT_BUTTON);
    }
}
  //  public List<WebElement> searchItemLeftPanel(String elementForSearch) {
   //     actions.waitElementToBeClickable(SEARCH_BUTTON, 5);
   //     actions.clickElement(SEARCH_BUTTON);
   //     actions.sendKeys(SEARCH_BUTTON, elementForSearch);
   //     return actions.getElements(SEARCH_BOX);

      //  actions.waitElementToBeClickable(SEARCH_BOX, 5);
      //  actions.clickElement(SEARCH_BOX);

    //}

   // public void clickOnResult(String objectToClick) {
   //     List<WebElement> results = actions.getElements(SEARCH_BOX);
    //    for (WebElement element : results) {
    //        if (element.getText().equals(objectToClick)) {
   //             element.click();
     //       }
      //  }
    //}

    //public String searchAdminPage(String userForSearch, int timeToWait) {
    //    actions.waitFluentElementClickable(SEARCH_BOX_PAGE, timeToWait);
    //    actions.sendKeys(SEARCH_BOX_PAGE, userForSearch);
    //    actions.clickElement(SEARCH_BUTTON_ADMIN_PAGE);
     //   actions.waitToSpinnerToHide(SPINNER, 10);
     //   return actions.getElementText(ADMIN_PAGE_RESULT);
  //  }

  //  public String resetAdminSearch() throws InterruptedException {
  //      actions.clickElement(RESET_ADMIN_SEARCH);
//        Thread.sleep(10000);
  //      actions.waitToSpinnerToHide(SPINNER, 10);
  //      return actions.getElementText(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
   // }

