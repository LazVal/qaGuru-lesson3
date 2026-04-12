package utils;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    //psvm
//    public static void main(String[] args) {
//        System.out.println(getRandomString(8));
//        System.out.println(getRandomEmail());
//        System.out.println(getRandomInt(0, 9999));
//        System.out.println(getRandomInt(111111111, 888888888));
//        System.out.println(getRandomPhone());
//        System.out.println(getRandomGender());
//    }

    public static String getRandomString(int length) {
        //String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom(); //экземпляр рандома

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));//Добавляем в строку рандомный символ
        }

        return result.toString();
    }

    public static String getRandomEmail() {

        //return getRandomString(8) + "@" + getRandomString(8) + ".com";
        return format("%s@%s.com", getRandomString(8), getRandomString(8));
    }
    public static String getRandomNegativeEmail() {

        return format("%s@%s.", getRandomString(8), getRandomString(8));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);//вариант 1
//        SecureRandom rnd = new SecureRandom();
//        return rnd.nextInt(max - min + 1) + min; //вариант 2
    }

    //+3 (263) 253 - 66 - 12
    public static String getRandomPhone() {
        String phoneTemplate = "+%s (%s) %s - %s - %s";

        return format(phoneTemplate, getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999)
                , getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender_bad_practice() {
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = getRandomInt(0, 2);
        return genders[randomIndex];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromStringArray(genders);
    }
    public static String getRandomItemFromStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);

        return stringArray[randomIndex];
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return getRandomItemFromStringArray(months);
    }
}
