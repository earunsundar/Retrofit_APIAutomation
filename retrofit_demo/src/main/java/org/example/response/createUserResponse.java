package org.example.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class createUserResponse {
    @JsonProperty("code")
    public int code;

    @JsonProperty("message")
    public String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
