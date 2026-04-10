package tests.homeWork3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.components.SubjectComponent;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    SubjectComponent subjectComponent = new SubjectComponent();
    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //расширение браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
