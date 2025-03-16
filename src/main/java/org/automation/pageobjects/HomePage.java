package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By HOME_PAGE_BANNER = By.xpath("/html/body/header/div[2]/div/div/div[1]/div/a");
    private final static By HOME_PAGE_ECO_HOUSE_VIDEO = By.xpath("/html/body/div[2]/article/div/div/section[5]/div/div[1]/div/div/video");

    public void openHomePage() {
        log.info("Open home page");
        manager.openBrowser();
        manager.getDriver().get("https://tawenergy.ro/");
        manager.getDriver().manage().window().maximize();
        actions.waitElementToBeClickable(HOME_PAGE_BANNER, 10);
    }

    public String homePageTitle() {
        log.info("Get home page title");
        return manager.getDriver().getTitle();
    }

    public boolean isBannerDisplayed() {
        log.info("Check if Element is displayed");
        return actions.isElementDisplayed(HOME_PAGE_BANNER);
    }

    public boolean isBannerEnabled() {
        log.info("Check if Element is enabled");
        return actions.isElementEnabled(HOME_PAGE_BANNER);
    }




    //public List<WebElement> productsDisplayed() {
       //log.info("Check if products are displayed");
      // return actions.getElements(HOME_PAGE_PRODUCTS);
    //}
}
