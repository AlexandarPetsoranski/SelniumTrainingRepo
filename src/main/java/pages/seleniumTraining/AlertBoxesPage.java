package pages.seleniumTraining;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class AlertBoxesPage {

    final WebDriver driver;
    private static final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private final By CLICK_ME_BUTTON = By.xpath("//p[@id=\"confirm-demo\"]//preceding-sibling::button");
    private final By CLICK_FOR_PROMT_TEXT_BUTTON = By.xpath("//p[@id=\"prompt-demo\"]//preceding-sibling::button");

    private final By CONFIRMATION_TEXT = By.id("confirm-demo");
    private final By PROMT_CONFIRMATION_TEXT =By.id("prompt-demo");

    public AlertBoxesPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }

}
