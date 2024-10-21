package utilities;

import com.github.javafaker.Faker;

public class FakerInstance {
    private static Faker faker;

    private FakerInstance() {}

    public static Faker getFaker() {
        if (faker == null) {
            faker = new Faker();
        }
        return faker;
    }
}