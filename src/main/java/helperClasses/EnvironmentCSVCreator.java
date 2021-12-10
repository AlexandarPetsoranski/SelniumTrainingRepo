package helperClasses;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentCSVCreator {

    public static void writeHashMapToCsv(String filePath) {
        Capabilities caps = ((RemoteWebDriver) SingletonBrowser.getInstance().getDriver()).getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getVersion();

        Map<String, String> map = new HashMap<>();
        map.put("Browser", browserName);
        map.put("Version", browserVersion);
        map.put("Stand", "production");
        String endOfLine = System.getProperty("line.separator");

        try (Writer writer = new FileWriter(filePath)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append(endOfLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
