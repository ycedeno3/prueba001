package Page;

import com.github.javafaker.Faker;

import java.util.Random;

public class fakerClass {
    private static Faker FAKER = new Faker();

    public static String getFirstName() {
        return FAKER.name().firstName();
    }

    public static String getLastName() {
        return FAKER.name().lastName();
    }

    public static String getPhone() {
        Random random = new Random();
        return String.valueOf(random.nextInt(100000000) + 1000000000);
    }

    public static String getEmail() {
        return FAKER.name().firstName();
    }

    public static String devuelveMailAleatorio() {
        String SALTCHARS = "abcdefghijklmnopqrstuwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@yopmail.com";
    }
}