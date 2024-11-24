package org.example.clients;

import org.example.request.ImmutableCreateUserRequest;
import org.example.request.createUserRequest;
import org.example.response.createUserResponse;
import org.example.services.user;
import retrofit2.Response;

import java.util.HashMap;

public class userClient {

    private final String baseUrl = "https://petstore.swagger.io/v2";
    user userAPI;

    public HashMap<String,String> createUser(String userName, String firstName, String lastName, String email, int id) {
        try {
            HashMap<String,String> createUserMap = null;
//            userAPI = new RetrofitAPIClient<userClient>();
            createUserRequest createuserPayload = ImmutableCreateUserRequest.builder()
                    .firstName(firstName)
                    .username(userName)
                    .lastName(lastName)
                    .email(email)
                    .id(id)
                    .userStatus(1)
                    .build();
            Response<createUserResponse> createdUserResponse = userAPI.addUser(createuserPayload).execute();
            if (createdUserResponse.code() == 200) {
                createUserMap.put("codeFromResponse", String.valueOf(createdUserResponse.body().getCode()));
                createUserMap.put("message",createdUserResponse.body().getMessage());

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
