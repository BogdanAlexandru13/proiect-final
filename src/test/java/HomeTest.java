import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Validate products test")
    public void validateProducts() {
        log.info("Validate products");
        List<WebElement> listOfProducts = homePage.productsDisplayed();
        assertNotNull(listOfProducts, "List of products is null");
        assertEquals(3, listOfProducts.size(), "Number of products is: " + listOfProducts.size());
        assertTrue(listOfProducts.get(2).getText().contains("Sistem Solar Fotovoltaic"));
    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}