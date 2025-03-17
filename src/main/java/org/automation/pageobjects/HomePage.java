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
    //private final static By SEARCH_BUTTON = By.xpath("//span[@class='sr-search-btn']");
    //private final static By SEARCH_FIELD = By.xpath("//input[@id='s']");

    private final static By MAGAZIN_PAGE_BUTTON = By.xpath("//a[normalize-space()='Magazin']");
    private final static By FIRST_ITEM_BUTTON = By.xpath("//a[@class='sr-single-title'][normalize-space()='Sistem Solar Fotovoltaic 5kW, Trifazat, Panouri Longi Solar, Inverter Huawei']");
    private final static By SECOND_ITEM_BUTTON = By.xpath("//a[@class='sr-single-title'][normalize-space()='Sistem Solar Fotovoltaic 5kW, Monofazat, Panouri Longi Solar, Inverter Huawei']");
    private final static By THIRD_ITEM_BUTTON = By.xpath("//a[contains(text(),'Sistem Solar Fotovoltaic 6kW, Monofazat, Panouri L')]");
    private final static By ADD_ITEM_BUTTON = By.xpath("//button[contains(text(),'Adaugă în coș')]");
    private final static By CART_BUTTON = By.xpath("//span[@class='sr-cart-icon']");
    private final static By POP_UP_BUTTON = By.xpath("//button[normalize-space()='Permite totul']");

    private final static By INCREASE_QUANTITY_BUTTON = By.xpath("//button[normalize-space()='+']");
    private final static By SEE_CART_BUTTON = By.xpath("//a[contains(text(),'Vezi coșul')]");
    private final static By CART_TEXT = By.xpath("//input[@id='quantity_67d80f0cc1a63']");




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

    public void addElementsToCart(){
        log.info("Add elements to cart");
        actions.clickElement(MAGAZIN_PAGE_BUTTON);
        actions.waitElementToBeClickable(FIRST_ITEM_BUTTON, 5);
        actions.clickElement(FIRST_ITEM_BUTTON);
        actions.waitElementToBeClickable(ADD_ITEM_BUTTON, 5);
        actions.clickElement(ADD_ITEM_BUTTON);


        actions.waitElementToBeClickable(MAGAZIN_PAGE_BUTTON, 5);
        actions.clickElement(MAGAZIN_PAGE_BUTTON);
        actions.waitElementToBeClickable(SECOND_ITEM_BUTTON, 5);
        actions.clickElement(SECOND_ITEM_BUTTON);
        actions.waitElementToBeClickable(ADD_ITEM_BUTTON, 5);
        actions.clickElement(ADD_ITEM_BUTTON);


        actions.waitElementToBeClickable(MAGAZIN_PAGE_BUTTON, 5);
        actions.clickElement(MAGAZIN_PAGE_BUTTON);
        actions.waitElementToBeClickable(THIRD_ITEM_BUTTON, 5);
        actions.clickElement(THIRD_ITEM_BUTTON);
        actions.waitElementToBeClickable(ADD_ITEM_BUTTON, 5);
        actions.clickElement(ADD_ITEM_BUTTON);

        actions.waitElementToBeClickable(HOME_PAGE_BANNER, 5);
        actions.clickElement(HOME_PAGE_BANNER);



    }

    public int getNumberOfProductsInCart() {
        log.info("Get number of products in cart");
        List<WebElement> products = actions.getElements(By.xpath("//span[@class='sr-cart-count']"));
        return products.size();
    }

    public void addElementToCart() {
        log.info("Add elements to cart");
        actions.clickElement(MAGAZIN_PAGE_BUTTON);
        actions.waitElementToBeClickable(FIRST_ITEM_BUTTON, 5);
        actions.clickElement(FIRST_ITEM_BUTTON);
        actions.waitElementToBeClickable(ADD_ITEM_BUTTON, 5);
        actions.clickElement(ADD_ITEM_BUTTON);

        actions.waitElementToBeClickable(CART_BUTTON, 5);
        actions.clickElement(CART_BUTTON);
        actions.waitElementToBeClickable(SEE_CART_BUTTON, 5);
        actions.clickElement(SEE_CART_BUTTON);

        actions.waitElementToBeClickable(INCREASE_QUANTITY_BUTTON, 5);
        actions.clickElement(INCREASE_QUANTITY_BUTTON);
    }

        ////input[@id='quantity_67d80ac545e88']

    //public int getNumberOfProductInCart() {
      //  log.info("Get number of products in cart");
      //  List<WebElement> products = actions.getElements(By.xpath("//input[@id='quantity_67d80ac545e88']"));
      //  return products.size();
    //}

    public String getCart() {
        // actions.waitToSpinnerToHide(CART_SPINNER, 10);
        actions.clickElement(CART_BUTTON);
        actions.clickElement(SEE_CART_BUTTON);
        actions.waitFluentElementVisible(CART_TEXT, 10);
        return actions.getElementText(CART_TEXT);
    }


    //public List<WebElement> productsDisplayed() {
       //log.info("Check if products are displayed");
      // return actions.getElements(HOME_PAGE_PRODUCTS);
    //}
}
