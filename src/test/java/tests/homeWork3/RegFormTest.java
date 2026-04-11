package tests.homeWork3;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;


public class RegFormTest extends BaseTest {

    @Test
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
                .submitForm()
                .checkResponce(studentName, fullName)
                .checkResponce(studentEmail, userEmail)
                .checkResponce(studentGender, gender)
                .checkResponce(studentMobile, userNumber)
                .checkResponce(studentDateOfBirth, dateofBirth)
                .checkResponce(studentSubjects, subjectsInput)
                .checkResponce(studentHobbies, Hobbies)
                .checkResponce(studentPicture, namePicture)
                .checkResponce(studentAddress, currentAddress);
        // .checkResponce(studentStateAndCity,stateAndCity);


    }

    @Test
    void successCompulsoryFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .typeLastName(lastName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .setDayOfBirth(dateDat, dateMonth, dateYear)
                .submitForm()
                .checkResponce(studentName, fullName)
                .checkResponce(studentGender, gender)
                .checkResponce(studentMobile, userNumber)
                .checkResponce(studentDateOfBirth, dateofBirth);

    }

    @Test
    void negativeFirstNameTest() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .submitForm()
                .checkBorderColorFirstName();

//        $("#lastName").setValue(lastName);
//        $("input.form-check-input[value=Female]").click();
//        $("#userNumber-wrapper #userNumber").setValue(userNumber);
//        $("#submit").click();
//
//
//        $("#firstName")
//                .shouldHave(cssValue("border-color", borderColorRed));

    }

    @Test
    void negativeLastNameTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumber)
                .submitForm()
                .checkBorderColorLastName();


//        $("#firstName").setValue(userName);
//        $("input.form-check-input[value=Female]").click();
//        $("#userNumber-wrapper #userNumber").setValue(userNumber);
//        $("#submit").click();
//
//        $("#lastName")
//                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }

    @Test
    void negativeMobileTest() {
        registrationPage.openPage()
                .typeFirstName(userName)
                .typeLastName(lastName)
                .selectGenterWrapper(gender)
                .typeUserNumber(userNumberNegative)
                .submitForm()
                .checkBorderColorNumber();

//        $("#firstName").setValue(userName);
//        $("#lastName").setValue(lastName);
//        $("input.form-check-input[value=Female]").click();
//        $("#userNumber-wrapper #userNumber").setValue(userNumberNegative);
//        $("#submit").click();
//
//
//        $("#userNumber-wrapper #userNumber")
//                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }

}
