package com.socks.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author NardinVN
 */
@Getter
@Setter
@Accessors(fluent = true)
public class UserPayload {

    @JsonProperty
    private String password;

    @JsonProperty
    private String email;

    @JsonProperty
    private String userName;

}
