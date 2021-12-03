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
        driver.get(ProjectVariables.MAIN_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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