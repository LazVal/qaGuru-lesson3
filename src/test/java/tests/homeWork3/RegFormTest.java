package tests.homeWork3;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.testdata.TestData;


public class RegFormTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Description("Позитивно проверяются все поля формы, а не только обязательные")
    void successFullFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.userName)
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
                .submitForm()
                .checkAppear(testData.tableText)
                .checkResponce("Student Name", testData.fullName)
                .checkResponce("Student Email", testData.userEmail)
                .checkResponce("Gender", testData.gender)
                .checkResponce("Mobile", testData.userNumber)
                .checkResponce("Date of Birth", testData.dateofBirth)
                .checkResponce("Subjects", testData.subjectsInput)
                .checkResponce("Hobbies", testData.hobbies)
                .checkResponce("Picture", testData.uploadPicture)
                .checkResponce("Address", testData.currentAddress)
                .checkResponce("State and City", testData.stateAndCity);


    }

    @Test
    @Description("Позитивно проверяются только обязательные поля")
    void successCompulsoryFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.userName)
                .typeLastName(testData.lastName)
                .selectGenterWrapper(testData.gender)
                .typeUserNumber(testData.userNumber)
                .setDayOfBirth(testData.dateDat, testData.dateMonth, testData.dateYear)
                .submitForm()
                .checkResponce("Student Name", testData.fullName)
                .checkResponce("Gender", testData.gender)
                .checkResponce("Mobile", testData.userNumber)
                .checkResponce("Date of Birth", testData.dateofBirth);

    }

    @Test
    @Description("Негативная проверка на незаполнение имени")
    void negativeFirstNameTest() {
        registrationPage.openPage()
                .typeLastName(testData.lastName)
                .selectGenterWrapper(testData.gender)
                .typeUserNumber(testData.userNumber)
                .submitForm()
                .checkBorderColorFirstName();

    }

    @Test
    @Description("Негативная проверка на незаполнение фамилии")
    void negativeLastNameTest() {
        registrationPage.openPage()
                .typeFirstName(testData.userName)
                .selectGenterWrapper(testData.gender)
                .typeUserNumber(testData.userNumber)
                .submitForm()
                .checkBorderColorLastName();

    }

    @Test
    @Description("Негативная проверка на незаполнение телефона")
    void negativeMobileTest() {
        registrationPage.openPage()
                .typeFirstName(testData.userName)
                .typeLastName(testData.lastName)
                .selectGenterWrapper(testData.gender)
                .typeUserNumber(testData.userNumberNegative)
                .submitForm()
                .checkBorderColorNumber();


    }

}
