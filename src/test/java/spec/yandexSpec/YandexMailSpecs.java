package spec.yandexSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.yandex.HomePage;
import pages.yandex.LogInPage;
import pages.yandex.MailPage;
import pages.yandex.YandexMainPage;
import projectVeriables.ProjectVariables;
import spec.BaseSpec;

public class YandexMailSpecs extends BaseSpec {
    private static final Logger logger = LoggerFactory.getLogger(YandexMailSpecs.class);
    private HomePage homePage;

    @Test
    public void verifyYandexHomePage() {
        homePage = new HomePage();
        driver = homePage.getDriver();

        Assertions.assertTrue(homePage.verifyHomePage());
    }

    @Test
    public void verifyUserCanLogInSuccessfully() {
        homePage = new HomePage();
        driver = homePage.getDriver();

        LogInPage logInPage = homePage.clickOnLogInButton();
        MailPage mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD).switchToLightVersion();

        WebElement userName = driver.findElement(mailPage.getUSER_NAME());
        String expectedRealName = userName.getAttribute("aria-label");

        Assertions.assertTrue(expectedRealName.contains(ProjectVariables.USER_NAME),
                "User name does not match! ");
    }

    @Test
    public void verifyUserLogOutSuccessfully() {
        homePage = new HomePage();
        driver = homePage.getDriver();

        LogInPage logInPage = homePage.clickOnLogInButton();
        MailPage mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD).switchToLightVersion();

        YandexMainPage yandexMainPage = mailPage.logOut();

        Assertions.assertTrue(yandexMainPage.verifyYandexNavigationBarPresented());
    }

    @ParameterizedTest
    @CsvSource({"+359886806048, coherentSolutions!92",
            "t.te5tuser,    coherentSolutions!92"})
    public void logInWithDifferentCredentials(String login, String pass) {
        homePage = new HomePage();
        LogInPage logInPage = homePage.clickOnLogInButton();
        logInPage.logIn(login, pass);

        driver = homePage.getDriver();
        Assertions.assertTrue(driver.getTitle().contains(ProjectVariables.MAIL_PAGE_TITLE),
                "Title does not match!" );
    }
}
