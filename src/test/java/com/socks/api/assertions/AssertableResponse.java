package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

/**
 * @author NardinVN
 */
@RequiredArgsConstructor
public class AssertableResponse {
    private final Response register;
    // что хотим проверить при ответе
    public void shouldHave(Condition condition) {

    }

    // ломбок автоматически сгенрит конструтктор

//    public AssertableResponse(Response register) {
//        this.register = register;
//    }
}
