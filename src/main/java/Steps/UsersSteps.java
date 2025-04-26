package Steps;

import POJO.Users;
import Utils.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersSteps {
    protected static final Logger logger = LoggerFactory.getLogger(UsersSteps.class);
    public static Users login(String username, String password) {
        Users User = new Users(username, password);
        logger.info("Logging in with username: " + username);
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(User)
                .post(Constants.BASEURL + Constants.LOGIN_ENDPOINT)
                .then().statusCode(200).extract().response().as(Users.class);
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
