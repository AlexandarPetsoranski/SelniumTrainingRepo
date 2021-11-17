package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    LogInPage logInPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By HomePageTitle = By.xpath("//div[@class=\"HeadBanner-Title\"]");
    By CreateAccountButton = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[1]");
    By LogInButton = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[2]");
    By acceptCoockies = By.xpath("//button[@data-id=\"button-all\"]");

    public void acceptCoockies(){
        driver.findElement(acceptCoockies).click();
    }

    public void clickOnLogInButton() {
        driver.findElement(LogInButton).click();
    }
}
