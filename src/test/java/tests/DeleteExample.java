package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteExample {

     @Test
    public void deleteExample() {


        baseURI = "https://reqres.in/api";
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
