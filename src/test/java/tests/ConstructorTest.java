package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {

    @Test
    public void openBunListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.URL);
        Assert.assertTrue("Раздел Булки не открылся", mainPage.switchToBuns());
    }
    @Test
    public void openSauceListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.URL);
        Assert.assertTrue("Раздел Соусы не открылся", mainPage.switchToSauces());
    }
    @Test
    public void openFillingListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.URL);
        Assert.assertTrue("Раздел Начинки не открылся", mainPage.switchToFillings());
    }
    @After
    public void TearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
