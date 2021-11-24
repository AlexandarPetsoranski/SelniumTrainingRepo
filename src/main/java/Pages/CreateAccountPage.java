package Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVeriables;

@Getter
@Setter
public class CreateAccountPage {
    final WebDriver driver;

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
        driver.findElement(FIRST_NAME_INPUT).sendKeys(ProjectVeriables.FIRST_NAME);
        driver.findElement(LAST_NAME_INPUT).sendKeys(ProjectVeriables.LAST_NAME);
        driver.findElement(ENTER_LOGIN_INPUT).sendKeys(ProjectVeriables.USER_NAME);
        driver.findElement(PASSWORD_INPUT).sendKeys(ProjectVeriables.PASSWORD);
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(ProjectVeriables.PASSWORD);
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(ProjectVeriables.PHONE_NUMBER);
        driver.findElement(REGISTER_BUTTON).click();
        return new MailPage(driver);
    }
}
