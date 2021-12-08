package pages.yandex;

import helperClasses.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'compose')]")
    private static WebElement WRITE_EMAIL;

    @FindBy(css = "span.mail-App-Footer-Item.mail-App-Footer-Item_lite")
    private static WebElement LIGHT_VERSION_BUTTON;

    @FindBy(css = ".b-pseudo-link")
    private WebElement CUSTOMER_NAME;

    @FindBy(css = "a.b-header__link_exit")
    private static WebElement LOG_OUT_LINK;

    @FindBy(xpath = "//div[@class='b-head-user']//a[contains(@href,'profile')]")
    private static WebElement USER_NAME;

    public MailPage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public MailPage switchToLightVersion() {
        LIGHT_VERSION_BUTTON.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".b-pseudo-link")));
        return new MailPage();
    }

    public YandexMainPage logOut(){
        LOG_OUT_LINK.click();
        return new YandexMainPage();
    }
    public String getUserName(){
        return USER_NAME.getAttribute("aria-label");
    }
}
