package helperClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import projectVeriables.ProjectVariables;

import java.time.Duration;

public class GetDriver {

    public static WebDriver driver = null;

    public static void initialize() {
        //singleton pattern
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
