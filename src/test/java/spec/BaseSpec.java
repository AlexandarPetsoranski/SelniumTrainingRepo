package spec;

import helperClasses.SingletonBrowserClass;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseSpec {
    protected static WebDriver driver;
    SingletonBrowserClass singletonBrowserClass = null;

    @BeforeEach
    void setup() {
        singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        driver = singletonBrowserClass.getDriver();
    }

    @AfterEach
    void cleanup() {
        singletonBrowserClass.closeDriver();
    }

    public static void takeScreenShot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,
                new File("src/main/resources/screenShots/"+fileName+".jpg"));
    }

}
