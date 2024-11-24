package org.example.clients;

import org.example.request.ImmutableCreateUserRequest;
import org.example.request.createUserRequest;
import org.example.response.createUserResponse;
import org.example.services.user;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.mail.internet.ContentType;
import javax.swing.text.AbstractDocument;
import java.util.HashMap;

public class userClient {

    private final String baseUrl = "https://petstore.swagger.io/v2/";
    user userAPI;

    public user createUserService() {
        Retrofit retrofit = new Retrofit.Builder().
        baseUrl(baseUrl).addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(user.class);
    }

    public HashMap<String, String> createUser(String userName,String password, String firstName, String lastName, String email, int id,String phone) {
        try {
            userAPI = this.createUserService();
            HashMap<String, String> createUserMap = null;
            createUserRequest createuserPayload = ImmutableCreateUserRequest.builder()
                    .firstName(firstName)
                    .username(userName)
                    .lastName(lastName)
                    .password(password)
                    .email(email)
                    .id(id)
                    .phone(phone)
                    .userStatus(1)
                    .build();
            Response<createUserResponse> createdUserResponse = userAPI.addUser(createuserPayload, "application/json").execute();
            if (createdUserResponse.code() == 200) {
                createUserMap.put("codeFromResponse", String.valueOf(createdUserResponse.body().getCode()));
                createUserMap.put("message", createdUserResponse.body().getMessage());

                return createUserMap;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred:" + e);
            return null;
        }
    }

}
