package pages.yandex;

import helperClasses.SingletonBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private final WebDriver driver;

    @FindBy (id="passp-field-login")
    private static WebElement ENTER_YOUR_ID_INPUT;

    @FindBy (id="passp:sign-in")
    private static WebElement LOG_IN_BUTTON;

    @FindBy(id="passp-field-passwd")
    private static WebElement ENTER_PASSWORD_INPUT;

    public LogInPage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public MailPage logIn(String userName, String password) {
        ENTER_YOUR_ID_INPUT.sendKeys(userName);
        LOG_IN_BUTTON.click();
        ENTER_PASSWORD_INPUT.sendKeys(password);
        LOG_IN_BUTTON.click();
        return new MailPage();
    }
}
