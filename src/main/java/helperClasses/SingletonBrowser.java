package helperClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonBrowser {

    private static SingletonBrowser instance =null;
    private final WebDriver driver;

    private SingletonBrowser() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public static SingletonBrowser getInstance() {
        if (instance == null) {
            instance = new SingletonBrowser();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeBrowser(){
        driver.close();
        instance = null;
    }
}