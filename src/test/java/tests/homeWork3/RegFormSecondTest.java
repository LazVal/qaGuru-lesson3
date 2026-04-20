package tests.homeWork3;

import org.junit.jupiter.api.Test;
import pages.RegistrationPageSecond;
import tests.homeWork3.BaseTest;
import tests.testdata.TestData;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static tests.testdata.TestData.*;

public class RegFormSecondTest extends BaseTest {
    RegistrationPageSecond registrationPageSecond = new RegistrationPageSecond();
    TestData testData = new TestData();


    @Test
    void successCompulsoryFillFormTest() {
        registrationPageSecond.openPage()
                .inputName(testData.userName)
                .inputEmail(testData.userEmail)
                .submitForm()
                .checkField(testData.name,testData.userName);

    }

    @Test
    void negativeEmailTest() {
        registrationPageSecond.openPage()
                .inputName(testData.userName)
                .inputEmail(testData.userEmailNegative)
                .submitForm()
                .checkBorderColorUserEmail();

    }
}
