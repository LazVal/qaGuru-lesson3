package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    //Elements (локаторы)
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement userLastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail-wrapper #userEmail");
    private final SelenideElement genterWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber-wrapper #userNumber");


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
}
