package tests.lesson3;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends BaseTest {

   @Test
    void successFullFillFormTest() {
       open("/text-box"); // открываем сайт
       $("[id=userName]").setValue("Vera"); //ввести значение в поле
       $("#userEmail").setValue("fwwqg@mail.ru"); // #-сокращение для id
       $("[id=currentAddress]").setValue("first address 1");
       $("[id=permanentAddress]").setValue("second address 1"); //CTR+D - копирует строчки кода
       $("[id=submit]").click(); //нажать кнопку

       $("[id=output] [id=name]").shouldHave(text("Vera")); //должен быть текст
       $("[id=output] [id=email]").shouldHave(text("fwwqg@mail.ru"));
       $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
       $("[id=output] [id=permanentAddress]").shouldHave(text("second address 1"));
    }

}
