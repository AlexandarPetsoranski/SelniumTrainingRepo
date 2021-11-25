package spec.seleniumSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.seleniumTraining.LoadingDataPage;
import spec.BaseSpec;

import java.time.Duration;

public class WaitForLoadingElementSpec extends BaseSpec {
    private LoadingDataPage loadingDataPage;

    @Test
    public void verifyNewUserIsPresented(){
        loadingDataPage = new LoadingDataPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(loadingDataPage.getFIND_NEW_USER_BUTTON()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(loadingDataPage.getUSER_INFORMATION()));
        Assertions.assertTrue(driver.findElement(loadingDataPage.getUSER_INFORMATION()).isEnabled());
    }
}
