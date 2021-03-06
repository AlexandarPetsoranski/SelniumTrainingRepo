package pages.yandex;

import helperClasses.SingletonBrowser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage {
    private static final By WRITE_EMAIL = By.xpath("//a[contains(@href,'compose')]");
    private static final By LIGHT_VERSION_BUTTON = By.cssSelector("span.mail-App-Footer-Item.mail-App-Footer-Item_lite");
    private static final By CUSTOMER_NAME = By.cssSelector(".b-pseudo-link");
    private static final By LOG_OUT_LINK = By.cssSelector("a.b-header__link_exit");
    private static final By USER_NAME = By.xpath("//div[@class='b-head-user']//a[contains(@href,'profile')]");

    private final WebDriver driver;

    public MailPage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
    }

    @Step ("Switch from full version to light version")
    public MailPage switchToLightVersion(){
        driver.findElement(LIGHT_VERSION_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".b-pseudo-link")));
        return new MailPage();
    }

    @Step ("Log out from Yandex mail")
    public YandexMainPage logOut(){
        driver.findElement(LOG_OUT_LINK).click();
        return new YandexMainPage();
    }

    public String getUserName(){
        return driver.findElement(USER_NAME).getAttribute("aria-label");
    }
}
