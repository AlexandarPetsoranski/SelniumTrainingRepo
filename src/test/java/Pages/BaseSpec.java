package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projectVeriables.ProjectVeriables;

import java.time.Duration;

public class BaseSpec {
    public WebDriver driver;

    @BeforeEach
    void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ProjectVeriables.MAIN_URL);
    }

    @AfterEach
    void cleanup(){
        driver.quit();
    }
}
