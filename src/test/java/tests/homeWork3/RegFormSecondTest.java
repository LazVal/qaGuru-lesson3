package tests.homeWork3;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Story("Вторая форма регистрации")
public class RegFormSecondTest extends BaseTest {

    @Test
    @DisplayName("Позитивно проверяется заполнение формы")
    void successCompulsoryFillFormTest() {
        step("Открыть страницу регистарции", () -> {
            registrationPageSecond.openPage();
        });
        step("Заполнение обязательных полей формы", () -> {
            registrationPageSecond
                    .inputName(testData.userName)
                    .inputEmail(testData.userEmail)
                    .submitForm();
        });
        step("Проверка результатов заполнения формы", () -> {
            registrationPageSecond.checkField(testData.name, testData.userName);
        });
    }

    @Test
    @DisplayName("Нешативная проверка на неверное заполнение поля Email")
    void negativeEmailTest() {
        step("Открыть страницу регистарции", () -> {
            registrationPageSecond.openPage();
        });
        step("Неверно заполнить поле Email", () -> {
            registrationPageSecond
                    .inputName(testData.userName)
                    .inputEmail(testData.userEmailNegative)
                    .submitForm();
        });
        step("Проверка подсвечивания красным обязательного поля Email", () -> {
            registrationPageSecond.checkBorderColorUserEmail();
        });
    }
}
