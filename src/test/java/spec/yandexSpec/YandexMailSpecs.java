package spec.yandexSpec;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("1")
    @Description("This test verifies user can successfully open YandexHomePage")
    @DisplayName("Verify Yandex Home Page can successfully be opened")
    public void verifyYandexHomePage() {
        homePage = new HomePage();

        Assertions.assertTrue(homePage.isHomePageDisplayed(),
                "Home page is not displayed! Might be because some elements are not displayed.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("2")
    @Description ("This test verifies user can successfully log in into Yandex mail")
    @DisplayName("Verify user can log in into Yandex Mail with relevant credentials")
    public void verifyUserCanLogInSuccessfully() {
        homePage = new HomePage();

        LogInPage logInPage = homePage.clickOnLogInButton();
        MailPage mailPage =
                logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD)
                .switchToLightVersion();

        Assertions.assertTrue(mailPage.getUSER_NAME().contains(ProjectVariables.USER_NAME),
                "User name does not match! ");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("3")
    @Description ("This test verifies user can successfully log оут into Yandex mail")
    @DisplayName("Verify user can successfully log out from Yandex Mail Page")
    public void verifyUserLogOutSuccessfully() {
        homePage = new HomePage();

        LogInPage logInPage = homePage.clickOnLogInButton();
        MailPage mailPage = logInPage.logIn(ProjectVariables.PHONE_NUMBER, ProjectVariables.PASSWORD)
                .switchToLightVersion();

        YandexMainPage yandexMainPage = mailPage.logOut();

        Assertions.assertTrue(yandexMainPage.verifyYandexNavigationBarPresented(),
                "Yandex page is not presented! Navigation bar not displayed.");
    }

    @ParameterizedTest
    @Severity(SeverityLevel.NORMAL)
    @Description ("This test verifies user can successfully log in into Yandex mail with different credentials")
    @AllureId("4")
    @CsvSource({"+359886806048, coherentSolutions!92",
            "t.te5tuser,    coherentSolutions!92"})
    @DisplayName("Verify user can log in into Yandex Mail with different relevant credentials")
    public void logInWithDifferentCredentials(String login, String pass) {
        homePage = new HomePage();
        LogInPage logInPage = homePage.clickOnLogInButton();
        logInPage.logIn(login, pass);

        Assertions.assertTrue(driver.getTitle().contains(ProjectVariables.MAIL_PAGE_TITLE),
                "Title does not match!" );
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @AllureId("5")
    @Description ("This test aims to fail and generate screenshot")
    @DisplayName("Verify screen shot is captured when tests fails")
    public void failingTest() {
        homePage = new HomePage();

        Assertions.fail();
    }

    @Ignore
    @Test
    @Severity(SeverityLevel.MINOR)
    @AllureId("6")
    @Description ("This test is ignored in order to fill Ignored Category in Allure Report")
    @DisplayName("Verify @Ignore annotations works and goes to relevant category in report")
    public void ignoredTest() {
        homePage = new HomePage();

        Assertions.fail();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @AllureId("7")
    @Description ("This test aims to troll NoSuchElementException")
    @DisplayName("Verify element not presented")
    public void elementNotFount() {
        homePage = new HomePage();

        homePage.get_NOT_EXISTING_ELEMENT();
    }
}
