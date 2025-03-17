import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HomeTest {

    HomePage homePage = new HomePage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();

    }

    @Test
    @DisplayName("Validate title test")
    public void validateTitle() {
        log.info("Validate title");
        String title = homePage.homePageTitle();
        assertEquals("Panouri Fotovoltaice - TAWEnergy.ro", title, "Title of page was: " + title);
    }

    @Test
    @DisplayName("Validate banner test")
    public void validateBanner() {
        log.info("Validate home page banner");
        boolean isBannerDisplayed = homePage.isBannerDisplayed();
        boolean isBannerEnabled = homePage.isBannerEnabled();
        assertTrue(isBannerDisplayed, "Banner is not displayed");
        assertTrue(isBannerEnabled, "Banner is not enabled");
    }

    @Test
    @DisplayName("Add elements to cart")
    public void addElementsToCart() {
        log.info("Add elements to cart");
        homePage.addElementsToCart();
        int numberOfProducts = homePage.getNumberOfProductsInCart();
        assertEquals(3, numberOfProducts, "Number of products in cart is not 3");
    }

    @Test
    @DisplayName("Add element to cart")
    public void addElementToCart() {
        log.info("Add element to cart");
        homePage.addElementToCart();
        String numberOfProducts = homePage.getCart();
        assertEquals(2, numberOfProducts, "Number of products in cart is not 2");
    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}