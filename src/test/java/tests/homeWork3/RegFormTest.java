package tests.homeWork3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import static io.qameta.allure.Allure.step;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import tests.testdata.TestData;


@Story("Форма регистиации")
public class RegFormTest extends BaseTest {


    @Test
    @Description("Позитивно проверяются все поля формы, а не только обязательные")
    @DisplayName("Позитивно проверяются все поля формы, а не только обязательные")
    @Step()
    void successFullFillFormTest() {

        step("Открыть страницу регистарции", () -> {
            registrationPage.openPage();
        });
        step("Заполнение всех полей формы", () -> {
            registrationPage.typeFirstName(testData.userName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .selectGenterWrapper(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .setDayOfBirth(testData.dateDat, testData.dateMonth, testData.dateYear)
                    .typeSubject(testData.subjectsInput)
                    .setHobbies(testData.hobbies)
                    .uploadPicture(testData.uploadPicture)
                    .typeAddress(testData.currentAddress)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .submitForm();
        });
        step("Проверка результатов заполнения формы", () -> {
            ;
            registrationPage.checkAppear(testData.tableText)
                    .checkResponce("Student Name", testData.fullName)
                    .checkResponce("Student Email", testData.userEmail)
                    .checkResponce("Gender", testData.gender)
                    .checkResponce("Mobile", testData.userNumber)
                    .checkResponce("Date of Birth", testData.dateOfBirth)
                    .checkResponce("Subjects", testData.subjectsInput)
                    .checkResponce("Hobbies", testData.hobbies)
                    .checkResponce("Picture", testData.uploadPicture)
                    .checkResponce("Address", testData.currentAddress)
                    .checkResponce("State and City", testData.stateAndCity);
        });
    }

    @Test
    @DisplayName("Позитивно проверяются только обязательные поля")
    @Tags({
            @Tag("SMOKE"),
            @Tag("REGRESS")
    })
    void successCompulsoryFillFormTest() {
        step("Открыть страницу регистарции", () -> {
            registrationPage.openPage();
        });
        step("Заполняются обязательные поля формы", () -> {
            registrationPage.typeFirstName(testData.userName)
                    .typeLastName(testData.lastName)
                    .selectGenterWrapper(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .setDayOfBirth(testData.dateDat, testData.dateMonth, testData.dateYear)
                    .submitForm();
        });
        step("Проверка результатов заполнения формы", () -> {
            ;
            registrationPage.checkResponce("Student Name", testData.fullName)
                    .checkResponce("Gender", testData.gender)
                    .checkResponce("Mobile", testData.userNumber)
                    .checkResponce("Date of Birth", testData.dateOfBirth);
        });

    }

    @Test
    @Description("Негативная проверка на незаполнение имени")
    void negativeFirstNameTest() {
        step("Открыть страницу регистарции", () -> {
            registrationPage.openPage();
        });
        step("Заполняются поля формы без FirstName", () -> {
            registrationPage.typeLastName(testData.lastName)
                    .selectGenterWrapper(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });
        step("Проверка подсвечивание красным обязательного поля FirstName", () -> {
            registrationPage.checkBorderColorFirstName();
        });

    }

    @Test
    @DisplayName("Негативная проверка на незаполнение фамилии")
    void negativeLastNameTest() {
        step("Открыть страницу регистарции", () -> {
            registrationPage.openPage();
        });
        step("Заполняются поля формы без LastName", () -> {
            registrationPage.typeFirstName(testData.userName)
                    .selectGenterWrapper(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });
        step("Проверка подсвечивание красным обязательного поля LastName", () -> {
            registrationPage.checkBorderColorLastName();
        });

    }

    @Test
    @DisplayName("Негативная проверка на незаполнение телефона")
    void negativeMobileTest() {
        step("Открыть страницу регистарции", () -> {
            registrationPage.openPage();
        });
        step("Заполняются поля формы без Number", () -> {
            registrationPage.typeFirstName(testData.userName)
                    .typeLastName(testData.lastName)
                    .selectGenterWrapper(testData.gender)
                    .typeUserNumber(testData.userNumberNegative)
                    .submitForm();
        });
        step("Проверка подсвечивание красным обязательного поля LastName", () -> {
            registrationPage.checkBorderColorNumber();
        });

    }

}
