package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //Поле Имя
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement nameField;
    //Поле Email
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private ElementsCollection emailField;
    //Поле Пароль
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    //Ссылка Войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    public RegistrationPage setName(String name) {
        nameField.sendKeys(name);
        return page(RegistrationPage.class);
    }

    public RegistrationPage setEmail(String email) {
        emailField.get(1).sendKeys(email);
        return page(RegistrationPage.class);
    }

    public RegistrationPage setPassword(String password) {
        passwordField.sendKeys(password);
        return page(RegistrationPage.class);
    }

    public void clickRegister() {
        registerButton.click();
        sleep(500);
    }
    public LoginPage clickLoginLink() {
        loginLink.click();
        sleep(500);
        return page(LoginPage.class);
    }

}
