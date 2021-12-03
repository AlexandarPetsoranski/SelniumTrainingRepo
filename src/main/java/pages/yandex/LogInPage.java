package pages.yandex;

import helperClasses.SingletonBrowser;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class LogInPage {

    final WebDriver driver;

    private static final By ENTER_YOUR_ID_INPUT = By.id("passp-field-login");
    private static final By LOG_IN_BUTTON = By.id("passp:sign-in");
    private static final By ENTER_PASSWORD_INPUT = By.id("passp-field-passwd");

    public LogInPage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
    }
    public MailPage logIn(String userName, String password) {
        driver.findElement(ENTER_YOUR_ID_INPUT).sendKeys(userName);
        driver.findElement(LOG_IN_BUTTON).click();
        driver.findElement(ENTER_PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOG_IN_BUTTON).click();
        return new MailPage();
    }

}
