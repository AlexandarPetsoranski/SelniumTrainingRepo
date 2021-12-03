package pages.yandex;

import helperClasses.SingletonBrowser;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class HomePage {
    final WebDriver driver;

    private static final By HOME_PAGE_TITLE = By.xpath("//div[@class=\"HeadBanner-Title\"]");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//div[@class='HeadBanner-ButtonsWrapper']/a/span[contains(text(),'Create an account')]");
    private static final By LOG_IN_BUTTON = By.className("HeadBanner-Button-Enter");
    private static final By ACCEPT_COOKIES = By.xpath("//button[@data-id=\"button-all\"]");

    public HomePage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
        //this.driver = driver;
        //this.driver.get(ProjectVariables.MAIN_URL);
    }

    public LogInPage clickOnLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
        return new LogInPage();
    }
}
