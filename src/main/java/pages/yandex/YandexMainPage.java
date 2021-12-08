package pages.yandex;

import helperClasses.SingletonBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@role='navigation']")
    private static WebElement NAVIGATION_BAR;

    public YandexMainPage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
    }

    public boolean verifyYandexNavigationBarPresented(){
        return NAVIGATION_BAR.isDisplayed();
    }
}
