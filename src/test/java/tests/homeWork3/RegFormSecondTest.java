package tests.homeWork3;

import org.junit.jupiter.api.Test;
import tests.homeWork3.BaseTest;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static tests.testdata.TestData.*;

public class RegFormSecondTest extends BaseTest {


    @Test
    void successCompulsoryFillFormTest() {
        open(openHostSecond);
        $("#userName-wrapper #userName").setValue(userName);
        $("#userEmail-wrapper #userEmail").setValue(userEmail);
        $("#submit").click();


        $(".border.col-md-12.col-sm-12 #name").shouldHave(text(userName));

    }

    @Test
    void negativeEmailTest() {
        open(openHostSecond);
        $("#userName-wrapper #userName").setValue(userName);
        $("#userEmail-wrapper #userEmail").setValue(userEmailNegative);
        $("#submit").click();


        $("#userEmail-wrapper #userEmail")
                .shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));

    }
}
