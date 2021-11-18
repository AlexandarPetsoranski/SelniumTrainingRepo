package Pages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class HomePage {
    final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By HomePageTitle = By.xpath("//div[@class=\"HeadBanner-Title\"]");
    private By CreateAccountButton = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[1]");
    private By LogInButton = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[2]");
    private By acceptCoockies = By.xpath("//button[@data-id=\"button-all\"]");


    public HomePage acceptCoockies() {
        driver.findElement(acceptCoockies).click();
        return new HomePage(driver);
    }

    public LogInPage clickOnLogInButton() {
        driver.findElement(LogInButton).click();
        return new LogInPage(driver);
    }
}
