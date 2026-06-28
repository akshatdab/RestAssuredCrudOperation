//import static io.restassured.RestAssured.*;
//
//import io.restassured.RestAssured;
//import io.restassured.RestAssured.*;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.json.simple.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class FirstGetRequest {
//
////    @Test(priority = 1)
////    public void getUser(){
////        Response rs = given().header("x-api-key", "reqres_4789a2229c484f968784c615d4135482").when().get("https://reqres.in/api/users/2");
////        System.out.println(rs.getStatusCode());
////        System.out.println(rs.asString());
////
////    }
////    @Test(priority = 2)
////    public void getAllUser(){
////        Response rs = given().header("x-api-key", "reqres_4789a2229c484f968784c615d4135482").when().get("https://reqres.in/api/users?page=2");
//
//    /// /        System.out.println(rs.asString());
////        System.out.println(rs.getStatusCode());
////        System.out.println(rs.getBody().asString());
////        System.out.println(rs.time());
////        System.out.println(rs.getHeader("Content-Type"));
////
////        int code = rs.getStatusCode();
////        Assert.assertEquals(2001, code);
////
////
////    }
//
////    @Test(priority= 3)
////public void getAllUsers(){
////        baseURI="https://reqres.in/api";
////        RestAssured.given().queryParam("page", 2).when().get(baseURI).then().statusCode(210);
////
////    }
//    @Test(priority = 3)
//    public void putMethod() {
//        JSONObject data = new JSONObject();
//        data.put("name", "Akshat");
//        data.put("job", "QA");
//        data.put("email", "akshat@123.com");
//
//        JSONObject body = new JSONObject();
//        body.put("data", data);
//
//        RestAssured.baseURI =
//                "https://reqres.in/api/collections/users/records";
//
//        RestAssured.given()
//                .header("x-api-key", "pro_6b90065a0a903a4b2d3ab557a03c15da12a83a7bb53a06190a792e5995a326fb")
//                .contentType(ContentType.JSON)
//                .header("X-Reqres-Env", "prod")
//                .queryParam("project_id", "32402")
//                .body(body.toJSONString())
//                .when()
//                .post()
//                .then()
//                .statusCode(201).log().all();
//    }
//
//
//    }
//
//}