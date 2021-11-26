package spec.yandexSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.yandex.HomePage;
import pages.yandex.LogInPage;
import pages.yandex.MailPage;
import projectVeriables.ProjectVariables;
import spec.BaseSpec;

import java.time.Duration;

public class CreateAccount extends BaseSpec {
    private static final Logger logger = LoggerFactory.getLogger(CreateAccount.class);
    private static final String EXPECTED_TITLE = "Inbox () — Yandex.Mail";

    private HomePage homePage;
    private LogInPage logInPage;
    private MailPage mailPage;

    @Test
    public void verifyYandexHomePage() {
        String ExpectedPageTitle = "Yandex.Mail — free, reliable email";

        Assertions.assertEquals(driver.getTitle(), ExpectedPageTitle);
    }

    @Test
    public void verifyUserCanLogInSuccessfully() throws InterruptedException {
        homePage = new HomePage(driver);
        logInPage = homePage.clickOnLogInButton();
        mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD);

        //Sleep is neither implicit nor explicit wait. It is way of controlling the test flow
        //by freezing the code execution for certain amount of time
        Thread.sleep(1000);

        mailPage.switchToLightVersion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(mailPage.getCUSTOMER_NAME()));

        Assertions.assertEquals(driver.getTitle(), EXPECTED_TITLE);
        logger.info("Yandex Logo is not displayed");
    }

    @ParameterizedTest
    @CsvSource({"+359886806048, coherentSolutions!92",
                "t.te5tuser,    coherentSolutions!92"})
    public void logInWithDifferentCredentials(String login, String pass) {
        homePage = new HomePage(driver);
        logInPage = homePage.clickOnLogInButton();
        mailPage = logInPage.logIn(login, pass);

        Assertions.assertEquals(driver.getTitle(), EXPECTED_TITLE);
    }
}
