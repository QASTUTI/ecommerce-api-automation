package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductTests extends BaseTest {

    @Test(priority = 1)
    public void getAllProducts() {
        Response res = RestAssured.given().get("/products");
        assertEquals(res.getStatusCode(), 200);
        assertTrue(res.jsonPath().getList("products").size() > 0);
    }

    @Test(priority = 2)
    public void getProductById() {
        int id = 1;
        Response res = RestAssured.given().get("/products/" + id);
        assertEquals(res.getStatusCode(), 200);
        assertEquals(res.jsonPath().getInt("id"), id);
    }
}
