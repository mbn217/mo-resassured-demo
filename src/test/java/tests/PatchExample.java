package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PatchExample {
    @Test
    public void patchExample() {
        JSONObject request = new JSONObject();
        request.put("name", "morphy");
        request.put("job", "leader");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
