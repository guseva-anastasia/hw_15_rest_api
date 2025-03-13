package helpers;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));
    public
    String userName = faker.name().fullName(),
            userJob = faker.job().title();

}
