package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import org.aeonbits.owner.ConfigFactory;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;

/**
 * @author NardinVN
 */
public class UsersTest {
    private final UserApiService userApiService = new UserApiService();
//    private final Faker faker = new Faker(new Locale("ru"));
    private Faker faker;
    private final UserPayload user = new UserPayload();
    @BeforeAll
    public void setUp() {
        // owner читаем конфиги перед тестами
        ConfigFactory.create(ProjectConfig.class);
        faker = new Faker(new Locale("ru"));

//        RestAssured.baseURI = "http://157.230.26.92/";
    }

    @Test
    void testCanRegisterNewUser() {
        // создаем нового юзера
        user
                .userName(faker.name().username())
                .email(faker.internet().emailAddress())
                .password("test123");

        // вызываем регистрацию юзера
        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", (Matcher) not(isEmptyOrNullString())));

        // POJO
//        UserRegistrationResponse response = userApiService.registerUser(user)
//                .shouldHave(Conditions.statusCode(200)).asPojo(UserRegistrationResponse.class);
//
//        response.getId();

    }
}
