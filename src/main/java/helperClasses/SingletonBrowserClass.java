package helperClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projectVeriables.ProjectVariables;

import java.time.Duration;

public class SingletonBrowserClass {

    // instance of singleton class
    private static SingletonBrowserClass singletonBrowserClass =null;
    private WebDriver driver;

    // Constructor
    private SingletonBrowserClass() {
    }

    // To create instance of class
    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass() {
            if (singletonBrowserClass == null) {
            singletonBrowserClass = new SingletonBrowserClass();
        }
        return singletonBrowserClass;
    }

    // To get driver
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ProjectVariables.MAIN_URL);
        return driver;
    }


    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
