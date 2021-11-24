package Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class HomePage {
    final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By HOME_PAGE_TITLE = By.xpath("//div[@class=\"HeadBanner-Title\"]");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[1]");
    private static final By LOG_IN_BUTTON = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[2]");
    private static final By ACCEPT_COOKIES = By.xpath("//button[@data-id=\"button-all\"]");

    public LogInPage clickOnLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
        return new LogInPage(driver);
    }
}
