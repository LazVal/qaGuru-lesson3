package tests.homeWork3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.RegistrationPageSecond;

public class BaseTest {

    @BeforeAll
    public static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080"; //расширение браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }


    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
