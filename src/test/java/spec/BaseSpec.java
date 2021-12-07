package spec;

import helperClasses.ScreenShotWatcher;
import helperClasses.SingletonBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVariables;

import java.time.Duration;


public class BaseSpec {
    protected WebDriver driver;

   @RegisterExtension
   ScreenShotWatcher watcher = new ScreenShotWatcher( ProjectVariables.SCREENSHOT_PATH);

    @BeforeEach
    void setup() {
        driver = SingletonBrowser.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ProjectVariables.MAIN_URL);
    }

    @AfterEach
    public void cleanup() {

        SingletonBrowser.getInstance().closeBrowser();
    }
}

