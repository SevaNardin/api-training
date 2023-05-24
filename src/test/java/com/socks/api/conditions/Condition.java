package com.socks.api.conditions;

import io.restassured.response.Response;

/**
 * @author NardinVN
 */
public interface Condition {
    // валидация ответа
    void check(Response response);
}
