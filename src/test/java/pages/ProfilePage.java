package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class ProfilePage {

    //Кнопка Конструктор
    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    //Лого
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    //Кнопка Выход
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }
    public MainPage clickLogo() {
        logo.click();
        return page(MainPage.class);
    }
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        sleep(500);
        return page(LoginPage.class);
    }

}
