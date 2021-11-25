package pages.seleniumTraining;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Getter
public class StylishProgressBarPage {

    final WebDriver driver;
    private static final String URL= "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    private final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private final By PERCENTAGE_CIRCLE = By.cssSelector(".percenttext");
    private final By PERCENT_INPUT = By.id("cricleinput");

    public StylishProgressBarPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }
}
