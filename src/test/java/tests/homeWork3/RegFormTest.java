package tests.homeWork3;

import org.junit.jupiter.api.Test;

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




}
}
