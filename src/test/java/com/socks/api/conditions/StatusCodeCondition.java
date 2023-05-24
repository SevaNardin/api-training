package com.socks.api.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

/**
 * @author NardinVN
 */
@RequiredArgsConstructor
public class StatusCodeCondition implements Condition {
    private final int statusCode;
    @Override
    public void check(Response response) {
        response.then().assertThat().statusCode(statusCode);
    }
}
