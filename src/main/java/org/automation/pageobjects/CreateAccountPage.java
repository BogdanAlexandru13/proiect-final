package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

import java.util.List;

public class CreateAccountPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By INREGISTRARE_LOGARE_BUTTON = By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/a");
    private final static By UTILIZATOR_MAIL_TEXT = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[1]/label");
    private final static By ADRESA_MAIL_TEXT = By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[1]/label");
    private final static By AUTENTIFICARE_TEXT = By.xpath("//*[@id=\"customer_login\"]/div[1]/h2");
    private final static By INREGISTREAZA_TE_TEXT = By.xpath("//*[@id=\"customer_login\"]/div[2]/h2");
    private final static By NO_ROBOT_TEXT = By.xpath("//*[@id=\"recaptcha-anchor-label\"]");
    private final static By TINE_MINTE_TEXT = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/div[2]/span[1]/label/span");
    private final static By PAROLA_TEXT = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]/label");

    public void clickCreateAccountButton() {
        log.info("Click create account button");
        actions.clickElement(INREGISTRARE_LOGARE_BUTTON);
    }

    public List<String> getAccountLabels() {
        log.info("Get account labels");
        String utilizatorText = actions.getElementText(UTILIZATOR_MAIL_TEXT);
        String mailText = actions.getElementText(ADRESA_MAIL_TEXT);
        String autentificareText = actions.getElementText(AUTENTIFICARE_TEXT);
        String inregistrareText = actions.getElementText(INREGISTREAZA_TE_TEXT);
        String noRobotText = actions.getElementText(NO_ROBOT_TEXT);
        String tineMinteText = actions.getElementText(TINE_MINTE_TEXT);
        String parolaText = actions.getElementText(PAROLA_TEXT);

        return List.of(utilizatorText, mailText, autentificareText, inregistrareText, noRobotText, tineMinteText, parolaText);
    }
}