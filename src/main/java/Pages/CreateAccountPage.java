package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVeriables;

public class CreateAccountPage {
    WebDriver driver;

    By firstNameInput = By.id("firstname");
    By lastNameInput = By.cssSelector("#lastname");
    By enterLoginInput = By.xpath("//input[@id='login']");
    By passwordInput = By.name("password");
    By confirmPasswordInput = By.id("password_confirm");
    By phoneNumberInput = By.id("phone");
    By registerButton = By.xpath("//button[@type=\"submit\"]");

    public void createAccount(){
        driver.findElement(firstNameInput).sendKeys(ProjectVeriables.FIRST_NAME);
        driver.findElement(lastNameInput).sendKeys(ProjectVeriables.LAST_NAME);
        driver.findElement(enterLoginInput).sendKeys(ProjectVeriables.USER_NAME);
        driver.findElement(passwordInput).sendKeys(ProjectVeriables.PASSWORD);
        driver.findElement(confirmPasswordInput).sendKeys(ProjectVeriables.PASSWORD);
        driver.findElement(phoneNumberInput).sendKeys(ProjectVeriables.PHONE_NUMBER);
        driver.findElement(registerButton).click();

    }
}
