package tests.testdata;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class TestData {
    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));
    public String userName = RandomUtils.getRandomString(5);
    public String lastName = fakerRu.name().lastName();
    public String fullName = userName + " " + lastName;
    public String userEmail = faker.internet().emailAddress();
    public String userEmailNegative = RandomUtils.getRandomNegativeEmail();
    public String gender = RandomUtils.getRandomGender();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String userNumberNegative = faker.phoneNumber().subscriberNumber(5);
    ;
    public String dateDat = String.format("%02d", faker.number().numberBetween(1, 28));
    public String dateMonth = RandomUtils.getRandomMonth();
    public String dateYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String dateOfBirth = String.format("%s %s,%s", dateDat, dateMonth, dateYear);
    public String subjectsInput = faker.options().option("English", "Chemistry", "Computer Science", "Commerce",
            "Economics", "Social Studies");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String uploadPicture = "mountain.jpg";
    public String currentAddress = faker.address().fullAddress();

    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "Delhi";
    };
    public String stateAndCity = state + " " + city;
    public String tableText = "Thanks for submitting the form";
    public String borderColorRed = "rgb(220, 53, 69)";

    //переменный для второй формы
    public String name = "name";
    public String borderColorRedSecond = "rgb(255, 0, 0)";

}
