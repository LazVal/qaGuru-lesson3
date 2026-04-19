package tests.homeWork3;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;


public class RegFormTest extends BaseTest {

    @Test
    @Description("Позитивно проверяются все поля формы, а не только обязательные")
    void successFullFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .setDayOfBirth(dateDat, dateMonth, dateYear)
                .typeSubject(subjectsInput)
                .setHobbies()
                .uploadPicture(uploadPicture)
                .typeAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkAppear(tableText)
                .checkResponce("Student Name", fullName)
                .checkResponce("Student Email", userEmail)
                .checkResponce("Gender", gender)
                .checkResponce("Mobile", userNumber)
                .checkResponce("Date of Birth", dateofBirth)
                .checkResponce("Subjects", subjectsInput)
                .checkResponce("Hobbies", Hobbies)
                .checkResponce("Picture", uploadPicture)
                .checkResponce("Address", currentAddress)
                .checkResponce("State and City", stateAndCity);


    }

    @Test
    @Description("Позитивно проверяются только обязательные поля")
    void successCompulsoryFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .typeLastName(lastName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .setDayOfBirth(dateDat, dateMonth, dateYear)
                .submitForm()
                .checkResponce("Student Name", fullName)
                .checkResponce("Gender", gender)
                .checkResponce("Mobile", userNumber)
                .checkResponce("Date of Birth", dateofBirth);

    }

    @Test
    @Description("Негативная проверка на незаполнение имени")
    void negativeFirstNameTest() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .submitForm()
                .checkBorderColorFirstName();

    }

    @Test
    @Description("Негативная проверка на незаполнение фамилии")
    void negativeLastNameTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .submitForm()
                .checkBorderColorLastName();

    }

    @Test
    @Description("Негативная проверка на незаполнение телефона")
    void negativeMobileTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .typeLastName(lastName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumberNegative)
                .submitForm()
                .checkBorderColorNumber();


    }

}
