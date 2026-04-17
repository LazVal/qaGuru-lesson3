package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class TableComponent {
    public void checkResponce(String key, String value) {
        $x("//tr[td[normalize-space()='" + key + "']]/td[2]").shouldHave(text(value));
    }
}
