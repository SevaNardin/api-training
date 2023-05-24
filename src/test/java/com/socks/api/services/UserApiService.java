package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserPayload;

/**
 * @author NardinVN
 */
public class UserApiService extends ApiService {
    // отправляем нашего юзера на регистрацию
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp().body(user).when().post("register"));
    }
}
