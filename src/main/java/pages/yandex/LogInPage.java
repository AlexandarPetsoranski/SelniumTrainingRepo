package pages.yandex;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class LogInPage {

    final WebDriver driver;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (id="passp-field-login")
    private static WebElement ENTER_YOUR_ID_INPUT;

    @FindBy (id="passp:sign-in")
    private static WebElement LOG_IN_BUTTON;

    @FindBy (id="passp-field-passwd")
    private static WebElement ENTER_PASSWORD_INPUT;


    public MailPage logIn(String userName, String password) {
        ENTER_YOUR_ID_INPUT.sendKeys(userName);
        LOG_IN_BUTTON.click();
        ENTER_PASSWORD_INPUT.sendKeys(password);
        LOG_IN_BUTTON.click();
        return new MailPage(driver);
    }

}
