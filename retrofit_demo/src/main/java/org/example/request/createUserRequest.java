package org.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateUserRequest.class)
@JsonDeserialize(as = ImmutableCreateUserRequest.class)
public abstract class createUserRequest {

    @JsonProperty("id")
    abstract int id();
    @JsonProperty("username")
    abstract String username();

    @JsonProperty("firstName")
    abstract String firstName();

    @JsonProperty("lastName")
    abstract String lastName();

    @JsonProperty("email")
    abstract String email();

    @JsonProperty("password")
    abstract String password();

    @JsonProperty("phone")
    abstract String phone();

    @JsonProperty("userStatus")
    abstract int userStatus();
}
