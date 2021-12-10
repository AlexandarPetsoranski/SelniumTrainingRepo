package helperClasses;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class ScreenShotWatcher implements TestWatcher {

    private final WebDriver driver;
    private final String path;

    public ScreenShotWatcher(String path) {
        this.driver = SingletonBrowser.getInstance().getDriver();
        this.path = path;
    }

    public void captureScreenshot(WebDriver driver, String fileName) {
        try {
            Allure.addAttachment("TEST NAME", "TEST CONTENT ");

            new File(path).mkdirs();

            try ( FileOutputStream out = new FileOutputStream(path + File.separator + "screenshot-" + fileName + ".jpg")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        captureScreenshot(driver, context.getDisplayName());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
    }

}
