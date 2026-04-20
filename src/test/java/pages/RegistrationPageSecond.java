package pages;

import com.codeborne.selenide.SelenideElement;
import tests.testdata.TestData;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPageSecond {
    TestData testData = new TestData();
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResult = $("[id=output]");

    public RegistrationPageSecond openPage() {
        open("/text-box");
        return this;
    }

    public RegistrationPageSecond inputName(String value) {
        userNameInput.setValue(value);
        return this;
    }   public RegistrationPageSecond inputEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPageSecond submitForm() {
        submitButton.click();
        return this;
    }
    public RegistrationPageSecond checkField(String key, String value) {
        outputResult.$(byId(key)).shouldHave(text(value));
        return this;
    }
    public RegistrationPageSecond checkBorderColorUserEmail() {
        userEmailInput.shouldHave(cssValue("border-color", testData.borderColorRedSecond));
        return this;
    }

}
