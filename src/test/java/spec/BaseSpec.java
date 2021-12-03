package spec;

import helperClasses.SingletonBrowser;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseSpec {
    protected static WebDriver driver;

    @AfterEach
    void cleanup() {
        SingletonBrowser.closeBrowser();
    }
}
