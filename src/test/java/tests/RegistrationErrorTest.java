package tests;

import com.UserOperations;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationErrorTest extends BaseTest {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/register";
    public Map userData;
    UserOperations userOperations = new UserOperations();
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        userData = userOperations.generateInvalidUserInfo();
        this.name = userData.get("name").toString();
        this.email = userData.get("email").toString();
        this.password = userData.get("password").toString();
        browserSetUp();
    }

    @Test
    public void invalidDataRegistrationTest() {
        RegistrationPage registrationPage = page(RegistrationPage.class);
        Selenide.open(registrationPage.URL);
        registrationPage
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegister();
        String currentUrl = WebDriverRunner.driver().url();
        Assert.assertEquals("Произошел переход на страницу авторизации", expectedUrl, currentUrl);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
