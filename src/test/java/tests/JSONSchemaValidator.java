package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {


    @Test
    public void putExample(){
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("json-schema-example.json"))
                .statusCode(200)
                .log().all();
    }

}
