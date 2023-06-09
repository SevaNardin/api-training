package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

/**
 * @author NardinVN
 */
@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;
    // что хотим проверить при ответе
    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }
    // для проверки больших json
    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    // ломбок автоматически сгенрит конструтктор

//    public AssertableResponse(Response register) {
//        this.register = register;
//    }
}
