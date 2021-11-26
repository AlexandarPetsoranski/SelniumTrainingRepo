package spec.seleniumSpec;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.seleniumTraining.StylishProgressBarPage;
import spec.BaseSpec;

import java.time.Duration;

public class ProgressBarSpec extends BaseSpec {

    private StylishProgressBarPage stylishProgressBarPage;

    @Test
    public void verifyObjectNotDownloadedIfPageReloaded() {
        stylishProgressBarPage = new StylishProgressBarPage(driver);
        driver.findElement(stylishProgressBarPage.getDOWNLOAD_BUTTON()).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement inputPercent = driver.findElement(stylishProgressBarPage.getPERCENT_INPUT());

        wait.until((ExpectedCondition<Boolean>) driver -> {
            boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(inputPercent));

            while (isInvisible) {
                int hiddenInputPercent = Integer.parseInt(inputPercent.getAttribute("value"));
                if (hiddenInputPercent >= 50) {
                    break;
                }
            }
            return true;
        });
        driver.navigate().refresh();
    }
}