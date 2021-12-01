package spec.yandexSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.yandex.HomePage;
import pages.yandex.LogInPage;
import pages.yandex.MailPage;
import projectVeriables.ProjectVariables;
import spec.BaseSpec;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CreateAccount extends BaseSpec {
    private static final Logger logger = LoggerFactory.getLogger(CreateAccount.class);

    private HomePage homePage;
    private LogInPage logInPage;
    private MailPage mailPage;

    @Test
    public void verifyYandexHomePage() throws IOException {
        homePage = new HomePage(driver);
        takeScreenShot("YandexHomePage");
        Assertions.assertTrue(driver.getTitle().contains(ProjectVariables.EXPECTED_TITLE));
    }

    @Test
    public void verifyUserCanLogInSuccessfully() throws IOException {
        homePage = new HomePage(driver);
        takeScreenShot("YandexHomePage");

        logInPage = homePage.clickOnLogInButton();
        mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD);

        mailPage.switchToLightVersion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(mailPage.getCUSTOMER_NAME()));

        Assertions.assertTrue(driver.getTitle().contains(ProjectVariables.EXPECTED_TITLE));
        logger.info("Yandex Logo is not displayed");
    }

    @Test
    public void verifyUserLogOutSuccessfully() throws IOException {
        verifyUserCanLogInSuccessfully();
        mailPage.logOut();

        Assertions.assertEquals(driver.getCurrentUrl(), ProjectVariables.YANDEX_URL);
    }

    @ParameterizedTest
    @CsvSource({"+359886806048, coherentSolutions!92",
            "t.te5tuser,    coherentSolutions!92"})
    public void logInWithDifferentCredentials(String login, String pass) throws IOException {
        homePage = new HomePage(driver);
        takeScreenShot("YandexHomePage");
        logInPage = homePage.clickOnLogInButton();
        mailPage = logInPage.logIn(login, pass);

        Assertions.assertTrue(driver.getTitle().contains(ProjectVariables.MAIL_PAGE_TITLE) );
    }
}
