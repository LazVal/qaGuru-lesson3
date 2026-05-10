package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.SubjectComponent;
import pages.components.TableComponent;
import tests.testdata.TestData;
import utils.JsSnippets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static tests.testdata.TestData.*;

public class RegistrationPage {

    TableComponent tableComponent = new TableComponent();
    SubjectComponent subject = new SubjectComponent();
    CalendarComponent calendar = new CalendarComponent();
    TestData testData = new TestData();

    //Elements (локаторы)
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement userLastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail-wrapper #userEmail");
    private final SelenideElement genterWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber-wrapper #userNumber");
    private final SelenideElement calendarClick = $("#dateOfBirthInput");
    private final SelenideElement userHobbies = $("#hobbiesWrapper");
    private final SelenideElement userPicture = $("#uploadPicture");
    private final SelenideElement userAddress = $(".col-md-9.col-sm-12 #currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement tableAppear = $(".modal-dialog");
    private final SelenideElement tableText = $("#example-modal-sizes-title-lg");


    //Actions (то, что делаем с локаторами)
    @Step("Открываем главную старницу /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        JsSnippets.deleteAdvertisement();
        return this;
    }

    @Step("Вводим имя \"{value}\"")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим фамилию \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        userLastName.setValue(value);

        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage selectGenterWrapper(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setDayOfBirth(String day, String month, String year) {
        calendarClick.click();
        calendar.setDatesOfBirth(day, month, year);

        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subject.setSubject(value);
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        userHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        userPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        userAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.scrollIntoView(true).click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.scrollIntoView(true).click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }


    public RegistrationPage submitForm() {
        submitButton.scrollIntoView(true).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage checkAppear(String value) {
        tableAppear.should(appear);
        tableText.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkResponce(String key, String value) {
        tableComponent.checkResponce(key, value);
        return this;
    }

    public RegistrationPage checkBorderColorLastName() {
        userLastName.shouldHave(cssValue("border-color", testData.borderColorRed));
        return this;
    }

    public RegistrationPage checkBorderColorFirstName() {
        firstNameInput.shouldHave(cssValue("border-color", testData.borderColorRed));
        return this;
    }

    public RegistrationPage checkBorderColorNumber() {
        userNumber.shouldHave(cssValue("border-color", testData.borderColorRed));
        return this;
    }

}
