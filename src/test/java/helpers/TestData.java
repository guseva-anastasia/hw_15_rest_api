package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));
    public
    String userName = faker.name().username(),
            userPassword = faker.internet().password(8, 12, true, true, true) + "Ua1@";


}
