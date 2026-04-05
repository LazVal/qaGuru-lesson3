package tests.homeWork3;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;


public class RegFormTest extends BaseTest{


    @Test
    void successFullFillFormTest() {
        open(openHost);
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail-wrapper #userEmail").setValue(userEmail);
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select option[value='0']").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select option[value='1990']").click();
        $("div.react-datepicker__day.react-datepicker__day--004").click();
        $("#subjectsInput").setValue(subjectsInput);
        $x("//div[contains(@class,'subjects-auto-complete__option') and text()='English']").click();
        $("#hobbies-checkbox-1[value='1']").click();
        $("#uploadPicture").sendKeys(uploadPicture);
        $(".col-md-9.col-sm-12 #currentAddress").setValue(currentAddress);
        $("#react-select-3-input").click();
        $x("//div[contains(@class,'css-d7l1ni-option') and text()='NCR']").click();
        $("#react-select-4-input").click();
        $x("//div[contains(@class,'css-d7l1ni-option') and text()='Delhi']").click();
        $("#submit").click();

        $x("//tr[td[normalize-space()='Student Name']]/td[2]")
                .shouldHave(text(fullNmae));
        $x("//tr[td[normalize-space()='Student Email']]/td[2]")
                .shouldHave(text(userEmail));
        $x("//tr[td[normalize-space()='Gender']]/td[2]")
                .shouldHave(text(sex));
        $x("//tr[td[normalize-space()='Mobile']]/td[2]")
                .shouldHave(text(userNumber));
        $x("//tr[td[normalize-space()='Date of Birth']]/td[2]")
                .shouldHave(text(dateofBirth));
        $x("//tr[td[normalize-space()='Subjects']]/td[2]")
                .shouldHave(text(subjectsInput));
        $x("//tr[td[normalize-space()='Hobbies']]/td[2]")
                .shouldHave(text(Hobbies));
        $x("//tr[td[normalize-space()='Picture']]/td[2]")
                .shouldHave(text(namePicture));
        $x("//tr[td[normalize-space()='Address']]/td[2]")
                .shouldHave(text(currentAddress));
        $x("//tr[td[normalize-space()='State and City']]/td[2]")
                .shouldHave(text(StateAndCity));

    }

    @Test
    void successCompulsoryFillFormTest() {
        open(openHost);
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select option[value='0']").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select option[value='1990']").click();
        $("div.react-datepicker__day.react-datepicker__day--004").click();
        $("#submit").click();


        $x("//tr[td[normalize-space()='Student Name']]/td[2]")
                .shouldHave(text(fullNmae));

        $x("//tr[td[normalize-space()='Gender']]/td[2]")
                .shouldHave(text(sex));
        $x("//tr[td[normalize-space()='Mobile']]/td[2]")
                .shouldHave(text(userNumber));
        $x("//tr[td[normalize-space()='Date of Birth']]/td[2]")
                .shouldHave(text(dateofBirth));

    }

    @Test
    void negativeFirstNameTest() {
        open(openHost);

        $("#lastName").setValue(lastName);
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue(userNumber);
        $("#submit").click();


        $("#firstName")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeLastNameTest() {
        open(openHost);

        $("#firstName").setValue(userName);
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue(userNumber);
        $("#submit").click();


        $("#lastName")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }

    @Test
    void negativeMobileTest() {
        open(openHost);

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("input.form-check-input[value=Female]").click();
        $("#userNumber-wrapper #userNumber").setValue(userNumberNegative);
        $("#submit").click();


        $("#userNumber-wrapper #userNumber")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }

}
