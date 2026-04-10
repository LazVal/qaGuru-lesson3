package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.SubjectComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SubjectComponent subject = new SubjectComponent();
    //Elements (локаторы)
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement userLastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail-wrapper #userEmail");
    private final SelenideElement genterWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber-wrapper #userNumber");
    private final SelenideElement userHobbies = $("#hobbies-checkbox-1[value='1']");
    private final SelenideElement userPicture = $("#uploadPicture");
    private final SelenideElement userAddress = $(".col-md-9.col-sm-12 #currentAddress");
    private final SelenideElement scrollIntoView = $("#react-select-3-input");
    //private final SelenideElement stateCity = $("#stateCity-wrapper").$(byText("NCR");


    //Actions (то, что делаем с локаторами)
    public RegistrationPage openPage() {
        open("/automation-practice-form");
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

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

    public RegistrationPage setDayOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDatesOfBirth(day, month, year);

        return this;
    }

    public RegistrationPage typeSubject(String value){
        subject.setSubject(value);
        return this;
    }

    public RegistrationPage setHobbies () {
        userHobbies.click();
        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        userPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage typeAddress (String value) {
        userAddress.setValue(value);
        return this;
    }
}
