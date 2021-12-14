package helperClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import projectVeriables.ProjectVariables;

import java.net.MalformedURLException;
import java.net.URL;

public class SingletonBrowser {

    private static SingletonBrowser instance =null;
    private final WebDriver driver;

    private SingletonBrowser() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);

        //WebDriverManager.chromedriver().setup();
        this.driver = new RemoteWebDriver(new URL(ProjectVariables.REMOTE_URL), chromeOptions);
    }

    @SneakyThrows
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