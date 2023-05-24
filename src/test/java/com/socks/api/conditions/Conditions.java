package com.socks.api.conditions;

import lombok.experimental.UtilityClass;

/**
 * @author NardinVN
 */
@UtilityClass
public class Conditions {
    public StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

}
