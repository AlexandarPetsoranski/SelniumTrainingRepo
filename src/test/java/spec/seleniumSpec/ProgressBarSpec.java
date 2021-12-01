package spec.seleniumSpec;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.seleniumTraining.StylishProgressBarPage;
import spec.BaseSpec;

import java.time.Duration;

public class ProgressBarSpec extends BaseSpec {
    StylishProgressBarPage stylishProgressBarPage;

    @Test
    public void downloadTest() {
        stylishProgressBarPage = new StylishProgressBarPage(driver);
        WebElement downloadButton = driver.findElement(stylishProgressBarPage.getDOWNLOAD_BUTTON());
        downloadButton.click();
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(driver -> {
            String currentPercentText = driver.findElement(By.cssSelector(".percenttext")).getText();
            int currentPercent = Integer.parseInt(currentPercentText.split("%")[0]);

            return currentPercent >= 50;
        });

        driver.navigate().refresh();
    }
}