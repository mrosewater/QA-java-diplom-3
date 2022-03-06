package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoveryPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Ссылка Войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }

}
