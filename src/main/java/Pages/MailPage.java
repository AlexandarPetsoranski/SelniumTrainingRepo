package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage {

    WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    By yandexLogo = By.cssSelector(".PSHeaderLogo360_theme_light");
}
