package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPageSecond extends BasePage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResult = $("[id=output]");

    @Step("Открываем главную старницу /text-box")
    public RegistrationPageSecond openPage() {
        open("/text-box");
        return this;
    }

    @Step("Ввести имя \"{value}\"")
    public RegistrationPageSecond inputName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    @Step("Ввести почту \"{value}\"")
    public RegistrationPageSecond inputEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Отправить форму")
    public RegistrationPageSecond submitForm() {
        submitButton.click();
        return this;
    }

    @Step("Проверка заполнения формы")
    public RegistrationPageSecond checkField(String key, String value) {
        outputResult.$(byId(key)).shouldHave(text(value));
        return this;
    }

    @Step("Проверка незаполнения обязательного поля UserEmail")
    public RegistrationPageSecond checkBorderColorUserEmail() {
        userEmailInput.shouldHave(cssValue("border-color", testData.borderColorRedSecond));
        return this;
    }

}
