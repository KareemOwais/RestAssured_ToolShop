package Steps;

import POJO.Users;
import Utils.RestClient;
import Utils.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class UsersSteps {
    protected static final Logger logger = LoggerFactory.getLogger(UsersSteps.class);
    public static Users login(String username, String password , int statusCode) {
        Users User = new Users(username, password);
        Response response = RestClient.sendPostRequest(User, Constants.LOGIN_ENDPOINT);
        if(statusCode == 200) {
            Assert.assertEquals(response.getStatusCode(),statusCode);
            return response.as(Users.class);
        }
        else if(statusCode == 401 ){
           Assert.assertEquals(response.getStatusCode(),statusCode);
            return null;
        }
        else {
            logger.error("Unexpected status code: " + statusCode);
            return null;
        }
    }
    public static void logout(String token) {
         RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(Constants.BASEURL + Constants.LOGOUT_ENDPOINT)
                .then().statusCode(200).extract().response().as(Users.class);
        logger.info("Logged out successfully");
    }
    public static void Register(String username, String password) {
        Users User = new Users(username, password);
          Response response = RestAssured.given()
                .contentType(ContentType.JSON).accept("application/json")
                .body(User)
                .post(Constants.BASEURL + Constants.REGISTER_ENDPOINT)
                  .then().extract().response();
          response.prettyPrint();
          response.then().statusCode(201);
            logger.info("User registered successfully");
    }
}
