package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class Example2 {

    @Test
    public void test1() {
        //Removed RestAssured from the import statement
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("Content-Type"));

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
