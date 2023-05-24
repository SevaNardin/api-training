package com.socks.tests;

import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author NardinVN
 */
public class UsersTest {
    private final UserApiService userApiService = new UserApiService();
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://157.230.26.92/";
    }

    @Test
    void testCanRegisterNewUser() {
        // создаем нового юзера
        UserPayload user = new UserPayload()
                .userName(RandomStringUtils.randomAlphanumeric(6))
                .email("test@mail.com")
                .password("test123");
        // вызываем регистрацию юзера
        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(200));
//                .body("id", (Matcher<?>) not(isEmptyString()));
    }
}
