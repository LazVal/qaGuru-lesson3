package tests.homeWork3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import pages.RegistrationPageSecond;
import tests.testdata.TestData;
import helpers.Attach;

import java.util.Map;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageSecond registrationPageSecond = new RegistrationPageSecond();
    TestData testData = new TestData();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    public static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080"; //расширение браузера
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "128.0";

        //Код нужен для того, чтобы в selenoid началась запись видео
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //передать два значения (enableVNC и enableVideo) в версию браузера
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        //Запуск браузера в selenoid
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }


    @AfterEach
    void closeWebDriver() {
        Attach.screenshootAs("Last screenshoot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.getVideoUrl();
        Selenide.closeWebDriver();
    }
}
