package spec.seleniumSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.seleniumTraining.AlertBoxesPage;
import spec.BaseSpec;

public class AlertsSpec extends BaseSpec {
    private AlertBoxesPage alertBoxesPage;

    private static final String CONFIRMATION_ALERT_DISMISSED = "You pressed Cancel!";
    private static final String CONFIRMATION_ALERT_APPROVED = "You pressed OK!";
    private static final String HELLO_TEXT = "HELLO_TEXT";
    private static final String PROMT_CONFIRMATION_TEXT = "You have entered 'HELLO_TEXT' !";

    @Test
    public void acceptConfirmationAlert() {
        alertBoxesPage = new AlertBoxesPage(driver);

        driver.findElement(alertBoxesPage.getCLICK_ME_BUTTON()).click();
        driver.switchTo().alert().accept();

        Assertions.assertEquals(driver.findElement(alertBoxesPage.getCONFIRMATION_TEXT()).getText(), CONFIRMATION_ALERT_APPROVED);
    }

    @Test
    public void dismissConfirmationAlert() {
        alertBoxesPage = new AlertBoxesPage(driver);

        driver.findElement(alertBoxesPage.getCLICK_ME_BUTTON()).click();
        driver.switchTo().alert().dismiss();
        Assertions.assertEquals(driver.findElement(alertBoxesPage.getCONFIRMATION_TEXT()).getText(), CONFIRMATION_ALERT_DISMISSED);
    }

    @Test
    public void confirmPromptAlertBox() {
        alertBoxesPage = new AlertBoxesPage(driver);

        driver.findElement(alertBoxesPage.getCLICK_FOR_PROMT_TEXT_BUTTON()).click();
        driver.switchTo().alert().sendKeys(HELLO_TEXT);
        driver.switchTo().alert().accept();

        Assertions.assertEquals(driver.findElement(alertBoxesPage.getPROMT_CONFIRMATION_TEXT()).getText(), PROMT_CONFIRMATION_TEXT);
    }
}
