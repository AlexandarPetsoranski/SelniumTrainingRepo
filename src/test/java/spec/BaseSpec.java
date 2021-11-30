package spec;

import helperClasses.SingletonBrowserClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseSpec {
    protected static WebDriver driver;

    @BeforeEach
    void setup() {
        SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        driver = singletonBrowserClass.getDriver();
    }

    @AfterEach
     void cleanup(){
        driver.quit();
        driver = null;
    }
}
