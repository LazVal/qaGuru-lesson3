package tests.homeWork3;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegFormTest extends BaseTest{

@Test
    void successFullFillFormTest() {
    open("/automation-practice-form");
    $("#firstName").setValue("Vera");
    $("#lastName").setValue("Semenova");
    $("#userEmail-wrapper #userEmail").setValue("Semenova@fewf.ru");
    $("input.form-check-input[value=Female]").click();
    $("#userNumber-wrapper #userNumber").setValue("4325274196");
    //$("#dateOfBirthInput").setValue("28 Mar 2026");
    $("#subjectsInput").setValue("English");
    $x("//div[contains(@class,'subjects-auto-complete__option') and text()='English']").click();
    $("#hobbies-checkbox-1[value='1']").click();
    $("#uploadPicture").sendKeys("D:\\Testing\\qaGuru-lesson3\\src\\test\\java\\tests\\homeWork3\\downloads\\горы.jpg");
    $(".col-md-9.col-sm-12 #currentAddress").setValue("Semenova@fewf");
    $("#react-select-3-input").click();
    $x("//div[contains(@class,'css-d7l1ni-option') and text()='NCR']").click();
    $("#react-select-4-input").click();
    $x("//div[contains(@class,'css-d7l1ni-option') and text()='Delhi']").click();
    $("#submit").click();

    $x("//tr[td[normalize-space()='Student Name']]/td[2]")
            .shouldHave(text("Vera Semenova"));
    $x("//tr[td[normalize-space()='Student Email']]/td[2]")
            .shouldHave(text("Semenova@fewf.ru"));
    $x("//tr[td[normalize-space()='Gender']]/td[2]")
            .shouldHave(text("Female"));
    $x("//tr[td[normalize-space()='Mobile']]/td[2]")
            .shouldHave(text("4325274196"));
    $x("//tr[td[normalize-space()='Date of Birth']]/td[2]")
            .shouldHave(text("29 March,2026"));
    $x("//tr[td[normalize-space()='Subjects']]/td[2]")
            .shouldHave(text("English"));
    $x("//tr[td[normalize-space()='Hobbies']]/td[2]")
            .shouldHave(text("Sports"));
    $x("//tr[td[normalize-space()='Picture']]/td[2]")
            .shouldHave(text("горы.jpg"));
    $x("//tr[td[normalize-space()='Address']]/td[2]")
            .shouldHave(text("Semenova@fewf"));
    $x("//tr[td[normalize-space()='State and City']]/td[2]")
            .shouldHave(text("NCR Delhi"));




    }

    @Test
    void successCompulsoryFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vera");
        $("#lastName").setValue("Semenova");
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue("4325274196");
        $("#submit").click();


        $x("//tr[td[normalize-space()='Student Name']]/td[2]")
                .shouldHave(text("Vera Semenova"));

        $x("//tr[td[normalize-space()='Gender']]/td[2]")
                .shouldHave(text("Female"));
        $x("//tr[td[normalize-space()='Mobile']]/td[2]")
                .shouldHave(text("4325274196"));
        $x("//tr[td[normalize-space()='Date of Birth']]/td[2]")
                .shouldHave(text("29 March,2026"));

    }

    @Test
    void negativeFirstNameTest() {
        open("/automation-practice-form");

        $("#lastName").setValue("Semenova");
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue("4325274196");
        $("#submit").click();


        $("#firstName")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeLastNameTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Vera");
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue("4325274196");
        $("#submit").click();


        $("#lastName")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }

    @Test
    void negativeMobileTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Vera");
        $("#lastName").setValue("Semenova");
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue("432532147");
        $("#submit").click();


        $("#userNumber-wrapper #userNumber")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }

}
