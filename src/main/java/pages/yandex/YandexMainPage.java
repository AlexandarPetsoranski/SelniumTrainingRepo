package pages.yandex;

import helperClasses.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMainPage {
    private final WebDriver driver;

    private static final By NAVIGATION_BAR = By.xpath("//div[@role='navigation']");

    public YandexMainPage() {
        this.driver = SingletonBrowser.getInstance().getDriver();
    }

    public boolean verifyYandexNavigationBarPresented(){
        return driver.findElement(NAVIGATION_BAR).isDisplayed();
    }
}
