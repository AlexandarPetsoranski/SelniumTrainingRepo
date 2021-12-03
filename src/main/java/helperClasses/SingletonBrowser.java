package helperClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projectVeriables.ProjectVariables;

import java.time.Duration;

public class SingletonBrowser {

    private static SingletonBrowser instance =null;
    private static WebDriver driver;

    private SingletonBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

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

    public static void closeBrowser(){
        driver.quit();
        instance = null;
    }
}