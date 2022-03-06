package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.page;

public class RedirectToLoginTest extends BaseTest {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/login";


    @Before
    public void setUp() {
        browserSetUp();
    }

    //Вход по кнопке «Войти в аккаунт» на главной
    @Test
    public void loginFromMainPageTest() {
        MainPage mainPage = page(MainPage.class);
        Selenide.open(mainPage.URL);
        mainPage.clickLoginButton();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }
    //Вход через кнопку «Личный кабинет»
    @Test
    public void redirectUnauthorizedUserToLoginTest() {
        MainPage mainPage = page(MainPage.class);
        Selenide.open(mainPage.URL);
        mainPage.clickProfileButton();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }
    //Вход через кнопку в форме регистрации
    @Test
    public void loginFromRegistrationPageTest() {
        RegistrationPage registrationPage = page(RegistrationPage.class);
        Selenide.open(registrationPage.URL);
        registrationPage.clickLoginLink();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }
    //Вход через кнопку в форме восстановления пароля
    @Test
    public void loginFromPasswordRecoveryPageTest() {
        PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
        Selenide.open(passwordRecoveryPage.URL);
        passwordRecoveryPage.clickLoginLink();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
