package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.utils.AuthUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginPage extends BaseTest {

    @Test(description = "Verify login and token generation")
    public void loginTest() {
        Response response = AuthUtility.getToken("michaelw", "michaelwpass");
        System.out.println(response.asPrettyString());
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().get("accessToken") != null, true);
    }
}
