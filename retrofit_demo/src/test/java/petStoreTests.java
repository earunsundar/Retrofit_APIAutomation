import org.example.clients.userClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class petStoreTests {
    userClient userClientAPI = new userClient();

    @Test
    public void userCreationTest() {
        //TestData
        String userName = "JohnDoe";
        String password = "strong";
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@gmail.com";
        int userId = 1;
        String phoneNumber = "123456789";
        HashMap<String,String> usersMap=userClientAPI.createUser(userName,password, firstName, lastName, email, userId,phoneNumber);
        Assert.assertEquals(usersMap.get("codeFromResponse"),"200");
    }
}
