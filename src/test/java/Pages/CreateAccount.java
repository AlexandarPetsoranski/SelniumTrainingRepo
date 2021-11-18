package Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAccount extends BaseSpec {
    private static final Logger logger = LoggerFactory.getLogger(CreateAccount.class);

    HomePage homePage;
    LogInPage logInPage;
    MailPage mailPage;

    @Test
    public void NavigateToYandexHomePage_YandexHomePagePresented() {
        String ExpectedPageTitle = "Yandex.Mail — free, reliable email";

        Assertions.assertEquals(driver.getTitle(), ExpectedPageTitle);
    }

    @Test
    public void LogIn_UserLogSuccessfully() {
        homePage = new HomePage(driver);
        logInPage = homePage.clickOnLogInButton();
        mailPage = logInPage.logIn();

        boolean yandexLogoDisplayed = driver.findElement(mailPage.getYandexLogo()).isEnabled();

        Assertions.assertTrue(yandexLogoDisplayed);
        logger.info("Yandex Logo is not displayed");
    }
}
