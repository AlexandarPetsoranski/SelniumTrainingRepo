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

    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.cssSelector("#lastname");
    private By enterLoginInput = By.xpath("//input[@id='login']");
    private By passwordInput = By.name("password");
    private By confirmPasswordInput = By.id("password_confirm");
    private By phoneNumberInput = By.id("phone");
    private By registerButton = By.xpath("//button[@type=\"submit\"]");

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
