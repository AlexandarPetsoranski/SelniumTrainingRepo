package spec.seleniumGridSpecs;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import projectVeriables.ProjectVariables;

import java.net.MalformedURLException;
import java.net.URL;

public class ad {
    private WebDriver driver;

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);

        driver = new RemoteWebDriver(new URL(ProjectVariables.REMOTE_URL), chromeOptions);

        driver.get(ProjectVariables.MAIN_URL);
        driver.quit();

    }
}
