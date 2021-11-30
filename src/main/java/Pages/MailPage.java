package Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class MailPage {

    final WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    private By yandexLogo = By.cssSelector(".PSHeaderLogo360_theme_light");
}
