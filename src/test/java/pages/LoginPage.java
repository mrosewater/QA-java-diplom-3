package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Поле Email
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement emailField;
    //Поле Пароль
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //Кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement registerButton;

    public LoginPage setEmail(String email) {
        emailField.sendKeys(email);
        return page(LoginPage.class);
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return page(LoginPage.class);
    }

    public void clickLogin() {
        registerButton.click();
    }

    public MainPage loginUser(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
        return page(MainPage.class);
    }

}
