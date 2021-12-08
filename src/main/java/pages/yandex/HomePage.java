package pages.yandex;

import helperClasses.SingletonBrowser;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectVeriables.ProjectVariables;

public class HomePage {
    final WebDriver driver;

    @FindBy(xpath="//div[@class=\"HeadBanner-Title\"]")
    private static WebElement HOME_PAGE_TITLE;

    @FindBy(xpath ="//div[@class='HeadBanner-ButtonsWrapper']/a/span[contains(text(),'Create an account')]" )
    private static  WebElement CREATE_ACCOUNT_BUTTON;

    @FindBy(className="HeadBanner-Button-Enter")
    private static WebElement LOG_IN_BUTTON;

    @FindBy(xpath="//button[@data-id=\"button-all\"]")
    private static WebElement ACCEPT_COOKIES;

    public LogInPage clickOnLogInButton() {
        LOG_IN_BUTTON.click();
        return new LogInPage(driver);
    }
    public boolean isHomePageDisplayed() {
        return driver.findElement(CREATE_ACCOUNT_BUTTON).isDisplayed() &&
                driver.findElement(LOG_IN_BUTTON).isDisplayed();
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(ProjectVariables.MAIN_URL);
    }
}
