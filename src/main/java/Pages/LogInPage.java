package Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVeriables;

@Getter
@Setter
public class LogInPage {

    final WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By enterYourIDInput = By.id("passp-field-login");
    private By logInButton = By.id("passp:sign-in");
    private By enterPasswordInput = By.id("passp-field-passwd");


    public MailPage logIn() {
        driver.findElement(enterYourIDInput).sendKeys(ProjectVeriables.PHONE_NUMBER);
        driver.findElement(logInButton).click();
        driver.findElement(enterPasswordInput).sendKeys(ProjectVeriables.PASSWORD);
        driver.findElement(logInButton).click();
        return new MailPage(driver);
    }
}
