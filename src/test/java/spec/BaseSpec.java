package spec;

import helperClasses.SingletonBrowserClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseSpec {
    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    protected WebDriver driver = null;

    @BeforeEach
     void setup() {
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        this.driver = singletonBrowserClass.getDriver();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
        driver = null;
    }

/*     @BeforeEach
     void setup() {
         GetDriver.initialize();
    }

    @AfterEach
    void cleanup() {
        GetDriver.quit();
    }*/
}
