import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginTaw;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTawTest {

    LoginTaw login = new LoginTaw();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.openTawLoginPage();
    }

    @Test
    @DisplayName("Taw log in test")
    public void loginTest() {
        login.loginTaw();
    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }

}