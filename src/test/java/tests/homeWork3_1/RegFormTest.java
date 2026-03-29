package tests.homeWork3_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RegFormTest extends BaseTest{

    ///text-box

    @Test
    void successCompulsoryFillFormTest() {
        open("/text-box");
        $("#userName-wrapper #userName").setValue("Vera");
        $("#userEmail-wrapper #userEmail").setValue("Vera@mail.ru");
        $("#submit").click();


        $(".border.col-md-12.col-sm-12 #name").shouldHave(text("Vera"));

    }

    @Test
    void negativeEmailTest() {
        open("/text-box");
        $("#userName-wrapper #userName").setValue("Vera");
        $("#userEmail-wrapper #userEmail").setValue("Vera@mail.");
        $("#submit").click();


        $("#userEmail-wrapper #userEmail")
                .shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));

    }
}
