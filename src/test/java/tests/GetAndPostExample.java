package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
 import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetAndPostExample {

    @Test
    public void getExample() {
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name",equalTo("George"))
                .body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void postExample(){
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "morpheus");
        map.put("job", "leader");
        System.out.println(map);

        JSONObject  request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }
}
