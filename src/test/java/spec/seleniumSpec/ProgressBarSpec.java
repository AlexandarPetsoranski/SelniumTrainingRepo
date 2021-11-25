package spec.seleniumSpec;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.seleniumTraining.StylishProgressBarPage;
import spec.BaseSpec;

import java.time.Duration;

public class ProgressBarSpec extends BaseSpec {

    private StylishProgressBarPage stylishProgressBarPage;

    @Test
    public void verifyObjectNotDownloadedIfPageReloaded(){
        stylishProgressBarPage = new StylishProgressBarPage(driver);
        driver.findElement(stylishProgressBarPage.getDOWNLOAD_BUTTON()).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement inputPercent = driver.findElement(stylishProgressBarPage.getPERCEMT_INPUT());
        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(inputPercent));

        WebElement loadingBarText = driver.findElement(stylishProgressBarPage.getPERCENTAGE_CIRCLE());

        while (isInvisible){
            String txt= loadingBarText.getText();
            int hiddenInputPercent = Integer.parseInt(inputPercent.getAttribute("value"));

            if ( hiddenInputPercent>=50 | txt.equals("51")){
                break;
            }
        }
        driver.navigate().refresh();

    }
}
