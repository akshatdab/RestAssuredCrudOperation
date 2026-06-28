import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.when;

public class CRUDOperation {

    public static String recordId;

    @Test(priority = 1)
        public void createRecord() {

            JSONObject data = new JSONObject();
            data.put("Name", "ajay");
            data.put("id", "2");
            data.put("school", "yamunanagar");
            data.put("Section", "B");

        JSONObject body = new JSONObject();
        body.put("data", data);

        Response rs = RestAssured.given()
                .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
                .header("X-Reqres-Env", "prod")
                .header("Content-Type", "application/json")
                .body(body.toString())
                .baseUri("https://reqres.in")
                .when().post("/api/collections/users/records?project_id=32402");
        rs.then().statusCode(201).log().all();
        JsonPath js = rs.jsonPath();
        recordId = js.getString("data.id");
        System.out.println(recordId);
    }

    @Test(priority = 2)
    public void updateRecord() {
        JSONObject data = new JSONObject();
        data.put("Name", "amit");
        data.put("id", "2");
        data.put("school", "st johns");
        data.put("Section", "B");

        JSONObject body = new JSONObject();
        body.put("data", data);
        System.out.println(recordId);
        Response rs = RestAssured.given()
                .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
                .header("X-Reqres-Env", "prod")
                .header("Content-Type", "application/json")
                .body(body.toString())
                .baseUri("https://reqres.in")
                .when().put("/api/collections/users/records/" + recordId + "?project_id=32402");
        rs.then().statusCode(200).log().all();
    }


    @Test(priority = 3, enabled = true)
    public void listAllRecord() {
        Response rs = RestAssured.given()
                .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
                .header("X-Reqres-Env", "prod")
                .baseUri("https://reqres.in")
                .when().get("/api/collections/users/records?project_id=32402");
        rs.then().statusCode(200).log().all();
    }

        @Test(priority = 4)
    public void deleteRecords() {
        Response rs = RestAssured.given()
                .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
                .header("X-Reqres-Env", "prod")
                .baseUri("https://reqres.in")
                .when()
                .delete("/api/collections/users/records/" + recordId + "?project_id=32402");
        rs.then().statusCode(204).log().all();
    }

    @Test(priority = 5, enabled = true)
    public void listAllRecord1() {
    listAllRecord();
}
    @Test(priority = 6)
    public void deleteAllRecord() {
        Response rs = RestAssured
                .given()
                .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
                .header("X-Reqres-Env", "prod")
                .baseUri("https://reqres.in")
                .get("/api/collections/users/records?project_id=32402");
        List<String> allrecord = rs.jsonPath().getList("data.id");
        System.out.println(allrecord.toString());

        for (String s1 : allrecord) {
            Response rs1 = RestAssured
                    .given()
                    .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
                    .header("X-Reqres-Env", "prod").
            when().delete("https://reqres.in/api/collections/users/records/" + s1 + "?project_id=32402");
            System.out.println("Deleted sucess " + s1);
            rs1.then().statusCode(204).log().all();
            //sfvhsbfnskfnwjfks

        }
    }
}
