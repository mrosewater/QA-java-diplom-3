package tests;

import com.UserOperations;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationTest extends BaseTest {

    public Map userData;
    UserOperations userOperations = new UserOperations();
    String login;
    String password;

    @Before
    public void setUp() {
        userData = userOperations.register();
        this.login = userData.get("email").toString();
        this.password = userData.get("password").toString();
        browserSetUp();
    }

    @Test
    public void logoutTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        LoginPage loginPage = page(LoginPage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(userData.get("email").toString(), userData.get("password").toString())
                .clickProfileButton()
                .clickLogoutButton();
        Assert.assertEquals("Не произошел переход на главную страницу", expectedUrl, WebDriverRunner.driver().url());
    }

    @After
    public void tearDown() {
        userOperations.delete();
        WebDriverRunner.closeWebDriver();
    }
}
