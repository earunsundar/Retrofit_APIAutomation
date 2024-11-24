package org.example.services;

import org.example.request.createUserRequest;
import org.example.response.createUserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface user {

    @POST("/user")
    Call<createUserResponse> addUser(@Body createUserRequest createUserPayload);
}
