package pages.yandex;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class MailPage {
    final WebDriver driver;

    @FindBy(css = ".PSHeaderLogo360_theme_light")
    private static WebElement YANDEX_LOGO;

    @FindBy(xpath = "//i[contains(text(),'Compose')]")
    private static WebElement WRITE_EMAIL;

    @FindBy(css = "span.mail-App-Footer-Item.mail-App-Footer-Item_lite")
    private static WebElement LIGHT_VERSION_BUTTON;

    @FindBy(css = ".b-pseudo-link")
    private WebElement CUSTOMER_NAME;

    @FindBy(css = "a.b-header__link_exit")
    private static WebElement LOG_OUT_LINK;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MailPage switchToLightVersion() {
        LIGHT_VERSION_BUTTON.click();
        return new MailPage(driver);
    }

    public MailPage logOut(){
        LOG_OUT_LINK.click();
        return new MailPage(driver);
    }
}
