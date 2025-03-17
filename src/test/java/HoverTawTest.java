package org.automation;
import org.automation.pageobjects.HoverTaw;
import org.junit.jupiter.api.Test;

public class HoverTawTest {

    HoverTaw tawPage = new HoverTaw();

    @Test
    public void testHoverTaw() {
        tawPage.openHoverTaw();
    }
}