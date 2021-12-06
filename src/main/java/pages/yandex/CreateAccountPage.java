package pages.yandex;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVariables;

@Getter
@Setter
public class CreateAccountPage {
    private final WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FIRST_NAME_INPUT = By.id("firstname");
    private static final By LAST_NAME_INPUT = By.cssSelector("#lastname");
    private static final By ENTER_LOGIN_INPUT = By.xpath("//input[@id='login']");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("password_confirm");
    private static final By PHONE_NUMBER_INPUT = By.id("phone");
    private static final By REGISTER_BUTTON = By.xpath("//button[@type=\"submit\"]");

    public MailPage createAccount() {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(ProjectVariables.FIRST_NAME);
        driver.findElement(LAST_NAME_INPUT).sendKeys(ProjectVariables.LAST_NAME);
        driver.findElement(ENTER_LOGIN_INPUT).sendKeys(ProjectVariables.USER_NAME);
        driver.findElement(PASSWORD_INPUT).sendKeys(ProjectVariables.PASSWORD);
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(ProjectVariables.PASSWORD);
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(ProjectVariables.PHONE_NUMBER);
        driver.findElement(REGISTER_BUTTON).click();
        return new MailPage();
    }
}
