package tests.testdata;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import tests.homeWork3.BaseTest;
import utils.RandomUtils;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class TestData {
    static Faker faker = new Faker();
    static Faker fakerRu = new Faker(new Locale("ru"));
    public static String userName = RandomUtils.getRandomString(5);
    public static String lastName = fakerRu.name().lastName();
    public static String fullName = userName + " " + lastName;
    public static String userEmail = faker.internet().emailAddress();
    public static String userEmailNegative = RandomUtils.getRandomNegativeEmail();
    public static String gender = RandomUtils.getRandomGender();
    public static String userNumber = faker.phoneNumber().subscriberNumber(10);
    public static String userNumberNegative = "43252741";
    public static String dateDat = String.valueOf(faker.number().numberBetween(1, 31));
    public static String dateMonth = RandomUtils.getRandomMonth();
    public static String dateYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    public static String dateofBirth = String.format("%s %s,%s", dateDat, dateMonth, dateYear);
    public static String subjectsInput = "English";
    public static String Hobbies = "Sports";
    public static String uploadPicture = "горы.jpg";
    public static String namePicture = "горы.jpg";
    public static String currentAddress = faker.address().fullAddress();
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String stateAndCity = "NCR Delhi";
    public static String tableText = "Thanks for submitting the form";
    public static String studentName = "Student Name";
    public static String studentEmail = "Student Email";
    public static String studentGender = "Gender";
    public static String studentMobile = "Mobile";
    public static String studentDateOfBirth = "Date of Birth";
    public static String studentSubjects = "Subjects";
    public static String studentHobbies = "Hobbies";
    public static String studentPicture = "Picture";
    public static String studentAddress = "Address";
    public static String studentStateAndCity = "State and City";
    public static String borderColorRed = "rgb(220, 53, 69)";

    //переменный для второй формы
    public static String name = "name";
    public static String borderColorRedSecond = "rgb(255, 0, 0)";

}
