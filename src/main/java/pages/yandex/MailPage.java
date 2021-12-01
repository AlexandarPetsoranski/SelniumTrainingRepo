package pages.yandex;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class MailPage {
    private static  final By YANDEX_LOGO = By.cssSelector(".PSHeaderLogo360_theme_light");
    private static final By WRITE_EMAIL = By.xpath("//i[contains(text(),'Compose')]");
    private static final By LIGHT_VERSION_BUTTON = By.cssSelector("span.mail-App-Footer-Item.mail-App-Footer-Item_lite");
    private final By CUSTOMER_NAME = By.cssSelector(".b-pseudo-link");

    final WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public MailPage switchToLightVersion(){
        driver.findElement(LIGHT_VERSION_BUTTON).click();
        return new MailPage(driver);
    }

}
