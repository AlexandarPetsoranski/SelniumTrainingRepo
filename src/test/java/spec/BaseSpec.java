package spec;

import helperClasses.SingletonBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import projectVeriables.ProjectVariables;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseSpec {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = SingletonBrowser.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ProjectVariables.MAIN_URL);
    }

    @AfterEach
    void cleanup() {
        SingletonBrowser.getInstance().closeBrowser();
    }

    public static void takeScreenShot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,
                new File("src/main/resources/screenShots/"+fileName+".jpg"));
    }
}
