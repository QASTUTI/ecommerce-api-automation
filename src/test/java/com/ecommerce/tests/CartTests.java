package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.utils.AuthUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTest {

    @Test
    public void addToCart() {
        String token = AuthUtility.extractToken("michaelw", "michaelwpass");

        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 1);
        payload.put("products", new Object[]{Map.of("id", 1, "quantity", 2)});

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/carts/add");

        assertEquals(res.getStatusCode(), 201);
    }

    @Test(dependsOnMethods = "addToCart")
    public void getCartById() {
        Response res = given().get("/carts/1");
        assertEquals(res.getStatusCode(), 200);
    }
}
