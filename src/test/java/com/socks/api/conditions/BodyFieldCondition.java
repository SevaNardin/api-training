package com.socks.api.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;


/**
 * @author NardinVN
 */
@RequiredArgsConstructor
public class BodyFieldCondition implements Condition {

    private final String jsonPath;
    private final Matcher matcher;
    @Override
    public void check(Response response) {
        response.then().assertThat().body(jsonPath, matcher);
    }
}
