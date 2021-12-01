package pages.seleniumTraining;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class LoadingDataPage {
    final WebDriver driver;
    private static final String URl = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";

    private final By FIND_NEW_USER_BUTTON = By.id("save");
    private final By USER_INFORMATION = By.id("loading");

    public LoadingDataPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.driver.get(URl);
    }
}
