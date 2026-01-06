package com.amdocs.halo.automation.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestExample {

    public static void main(String[] args) {

        // Base URI of the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Perform GET request
        Response response = RestAssured
                .given()
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        // Print status code
        System.out.println("Status Code: " + response.getStatusCode());

        // Print response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
    }
}
