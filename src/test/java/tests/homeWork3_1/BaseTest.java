package tests.homeWork3_1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //расширение браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }

    //    @AfterEach
//    void afterEach() {
//        closeWebDriver();
//    }
}
