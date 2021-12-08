package spec.yandexSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.yandex.HomePage;
import pages.yandex.LogInPage;
import pages.yandex.MailPage;
import pages.yandex.YandexMainPage;
import projectVeriables.ProjectVariables;
import spec.BaseSpec;

public class YandexMailSpecs extends BaseSpec {
    private HomePage homePage;

    @Test
    public void verifyYandexHomePage() {
        homePage = new HomePage();

        Assertions.assertTrue(homePage.isHomePageDisplayed(),
                "Home page is not displayed! Might be because some elements are not displayed.");
    }

    @Test
    public void verifyUserCanLogInSuccessfully() {
        homePage = new HomePage();

        LogInPage logInPage = homePage.clickOnLogInButton();
        MailPage mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD).switchToLightVersion();

        Assertions.assertTrue(mailPage.getUserName().contains(ProjectVariables.USER_NAME),
                "User name does not match! ");
    }

    @Test
    public void verifyUserLogOutSuccessfully() {
        homePage = new HomePage();

        LogInPage logInPage = homePage.clickOnLogInButton();
        MailPage mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD).switchToLightVersion();

        YandexMainPage yandexMainPage = mailPage.logOut();

        Assertions.assertTrue(yandexMainPage.verifyYandexNavigationBarPresented(),
                "Yandex page is not presented! Navigation bar not displayed.");
    }

    @ParameterizedTest
    @CsvSource({"+359886806048, coherentSolutions!92",
            "t.te5tuser,    coherentSolutions!92"})
    public void logInWithDifferentCredentials(String login, String pass) {
        homePage = new HomePage();
        LogInPage logInPage = homePage.clickOnLogInButton();
        logInPage.logIn(login, pass);

        Assertions.assertTrue(driver.getTitle().contains(ProjectVariables.MAIL_PAGE_TITLE),
                "Title does not match!" );
    }
}
