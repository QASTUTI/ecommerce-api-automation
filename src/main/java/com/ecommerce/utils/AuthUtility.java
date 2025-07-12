package com.ecommerce.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthUtility {

    public static Response getToken(String username, String password) {
        HashMap<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("/auth/login");
    }

    public static String extractToken(String username, String password) {
        return getToken(username, password).jsonPath().getString("accessToken");
    }
}
