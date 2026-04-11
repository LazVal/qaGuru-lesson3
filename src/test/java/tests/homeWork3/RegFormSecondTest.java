package tests.homeWork3;

import org.junit.jupiter.api.Test;
import pages.RegistrationPageSecond;
import tests.homeWork3.BaseTest;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static tests.testdata.TestData.*;

public class RegFormSecondTest extends BaseTest {


    @Test
    void successCompulsoryFillFormTest() {
        registrationPageSecond.openPage()
                .inputName(userName)
                .inputEmail(userEmail)
                .submitForm()
                .checkField(name,userName);
//        $("#userName").setValue(userName);
//        $("#userEmail").setValue(userEmail);
//        $("#submit").click();
//        $("[id=output]").shouldHave(text(userName));

    }

    @Test
    void negativeEmailTest() {
        registrationPageSecond.openPage()
                .inputName(userName)
                .inputEmail(userEmailNegative)
                .submitForm()
                .checkBorderColorUserEmail();


//        $("#userName-wrapper #userName").setValue(userName);
//        $("#userEmail-wrapper #userEmail").setValue(userEmailNegative);
//        $("#submit").click();
//
//        $("#userEmail-wrapper #userEmail")
//                .shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));

    }
}
