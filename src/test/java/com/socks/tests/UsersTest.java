package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

/**
 * @author NardinVN
 */
public class UsersTest {
    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker(new Locale("ru"));
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://157.230.26.92/";
    }

    @Test
    void testCanRegisterNewUser() {
        // создаем нового юзера
        UserPayload user = new UserPayload()
                .userName(faker.name().username())
                .email(faker.internet().emailAddress())
                .password("test123");
        // вызываем регистрацию юзера
        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", (Matcher) not(isEmptyOrNullString())));
    }
}
