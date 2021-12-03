package spec;

import helperClasses.SingletonBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVariables;

import java.time.Duration;

public class BaseSpec {
    protected static WebDriver driver;

    @BeforeEach
    void setup(){
        driver = SingletonBrowser.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ProjectVariables.MAIN_URL);
    }

    @AfterEach
    void cleanup() {
        SingletonBrowser.closeBrowser();
    }
}
