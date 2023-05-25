package com.socks.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author NardinVN
 */
@Getter
@Setter
public class UserRegistrationResponse {

    @JsonProperty("id")
    private String id;
}
