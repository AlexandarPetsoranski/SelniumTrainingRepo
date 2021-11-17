package Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccount extends BaseSpec {
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
        homePage.acceptCoockies();

        homePage.clickOnLogInButton();

        logInPage = new LogInPage(driver);
        logInPage.logIn();

        mailPage = new MailPage(driver);
        Boolean yandexLogoDisplayed = driver.findElement(mailPage.yandexLogo).isEnabled();

        Assertions.assertTrue(yandexLogoDisplayed);

    }
}
