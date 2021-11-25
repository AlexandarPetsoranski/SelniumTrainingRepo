package pages.seleniumTraining;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Data
public class SelectPage {
    final WebDriver driver;
    private static final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    private final By MULTISELECT = By.cssSelector("#multi-select");

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }


}
