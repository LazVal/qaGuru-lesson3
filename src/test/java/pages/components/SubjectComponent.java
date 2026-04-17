package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SubjectComponent {
    private final SelenideElement subjectInput = $("#subjectsInput");

    public void setSubject (String subject) {
        subjectInput.setValue(subject);
        $x("//div[contains(@class,'subjects-auto-complete__option') and text()='" + subject + "']").click();
    }
}
