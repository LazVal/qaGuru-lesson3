package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SubjectComponent {
    public void setSubject (String subject) {
        $("#subjectsInput").setValue(subject);
        $x("//div[contains(@class,'subjects-auto-complete__option') and text()='English']").click();
    }
}
