package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVeriables;

public class LogInPage {

    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    By enterYourIDinput = By.id("passp-field-login");
    By logInButton = By.id("passp:sign-in");
    By enterPasswordInput = By.id("passp-field-passwd");


    public void logIn() {
        driver.findElement(enterYourIDinput).sendKeys(ProjectVeriables.PHONE_NUMBER);
        driver.findElement(logInButton).click();
        driver.findElement(enterPasswordInput).sendKeys(ProjectVeriables.PASSWORD);
        driver.findElement(logInButton).click();

    }
}
